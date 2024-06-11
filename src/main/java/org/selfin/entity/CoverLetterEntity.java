package org.selfin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoverLetterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String title;

    private LocalDate editDate;

    // -1 : 개인 자소서, -2 : 첨삭 전 자소서, 그 외 : 첨삭 후 자소서이며 첨삭 전 자소서의 ID값
    private Long state;

    @OneToMany(cascade = CascadeType.ALL)
    private List<QnaEntity> qna;
}

