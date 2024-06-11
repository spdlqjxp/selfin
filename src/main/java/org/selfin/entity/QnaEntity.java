package org.selfin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.selfin.dto.QnaDTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class QnaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;
    private String answer;

    public QnaDTO to() {
        return new QnaDTO(question, answer);
    }
}
