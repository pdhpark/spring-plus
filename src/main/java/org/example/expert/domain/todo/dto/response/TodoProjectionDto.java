package org.example.expert.domain.todo.dto.response;

import lombok.Getter;

@Getter
public class TodoProjectionDto {
    private final String title;
    private final Integer userCount; // 담당자 수
    private final Integer commentCount; // 댓글 개수

    public TodoProjectionDto(String title, Integer userCount, Integer commentCount) {
        this.title = title;
        this.userCount = userCount;
        this.commentCount = commentCount;
    }
}
