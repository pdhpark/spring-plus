package org.example.expert.domain.log.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;

@Getter
@Entity
@NoArgsConstructor
public class Log extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Long requestId;

    private String additionalInfo;

    public Log(String message, Long requestId, String additionalInfo) {
        this.message = message;
        this.requestId = requestId;
        this.additionalInfo = additionalInfo;
    }
}
