package org.example.expert.domain.todo.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.dto.response.TodoProjectionDto;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.example.expert.domain.comment.entity.QComment.comment;
import static org.example.expert.domain.manager.entity.QManager.manager;
import static org.example.expert.domain.todo.entity.QTodo.todo;
import static org.example.expert.domain.user.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class TodoQueryRepositoryImpl implements TodoQueryRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Todo> findByIdWithUserDSL(Long todoId) {
        return Optional.ofNullable(
                queryFactory
                .select(todo)
                .join(todo.user, user).fetchJoin()
                .from(todo)
                .where(todo.id.eq(todoId))
                .fetchOne()
        );
    }

    @Override
    public Page<TodoProjectionDto> findTodos(String title, LocalDateTime startDate, LocalDateTime endDate, String nickname, Pageable pageable) {
        // 동적 검색 조건 생성
        BooleanBuilder builder = new BooleanBuilder();

        if (title != null && !title.isEmpty()) {
            builder.and(todo.title.containsIgnoreCase(title));
        }

        if (startDate != null && endDate != null) {
            builder.and(todo.createdAt.between(startDate, endDate));
        }

        if (nickname != null && !nickname.isEmpty()) {
            builder.and(todo.user.nickname.containsIgnoreCase(nickname));
        }

        // QueryDSL로 검색 쿼리 실행
        List<TodoProjectionDto> results = queryFactory
                .select(Projections.constructor(
                        TodoProjectionDto.class,
                        todo.title, // 제목만 반환
                        todo.managers.size().as("userCount"), // 담당자 수
                        todo.comments.size().as("commentCount") // 댓글 개수
                ))
                .from(todo)
                .leftJoin(todo.managers, manager) // 담당자와 join
                .leftJoin(todo.comments, comment) // 댓글과 join
                .where(builder)
                .groupBy(todo.id)
                .orderBy(todo.createdAt.desc()) // 최신순 정렬
                .offset(pageable.getOffset()) // 페이징 처리
                .limit(pageable.getPageSize())
                .fetch();

        // 페이징된 전체 결과 개수 조회
        Long total = queryFactory
                .select(Wildcard.count)
                .from(todo)
                .where(builder)
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }
}
