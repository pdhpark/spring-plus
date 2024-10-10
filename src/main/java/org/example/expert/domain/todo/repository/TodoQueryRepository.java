package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.dto.response.TodoProjectionDto;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TodoQueryRepository {

    Optional<Todo> findByIdWithUserDSL(Long todoId);

    Page<TodoProjectionDto> findTodos(String title, LocalDateTime startDate, LocalDateTime endDate, String nickname, Pageable pageable);
}
