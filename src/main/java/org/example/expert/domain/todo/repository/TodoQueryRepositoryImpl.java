package org.example.expert.domain.todo.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
}
