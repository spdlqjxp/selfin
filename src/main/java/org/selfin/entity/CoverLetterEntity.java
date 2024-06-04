package org.selfin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CoverLetterEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column
    private String username;
    @Column
    private String title;
    @Column
    private String question1;
    @Column
    private String content1;
    @Column
    private String question2;
    @Column
    private String content2;
    @Column
    private String question3;
    @Column
    private String content3;
    @Column
    private String question4;
    @Column
    private String content4;
    @Column
    private String question5;
    @Column
    private String content5;

    public CoverLetterEntity patch(CoverLetterEntity coverLetter) {
        if (coverLetter.title != null) {
            this.title = coverLetter.title;
        }
        if (coverLetter.question1 != null) {
            this.question1 = coverLetter.question1;
        }
        if (coverLetter.content1 != null) {
            this.content1 = coverLetter.content1;
        }
        if (coverLetter.question2 != null) {
            this.question2 = coverLetter.question2;
        }
        if (coverLetter.content2 != null) {
            this.content2 = coverLetter.content2;
        }
        if (coverLetter.question2 != null) {
            this.question2 = coverLetter.question2;
        }
        if (coverLetter.content3 != null) {
            this.content3 = coverLetter.content3;
        }
        if (coverLetter.question4 != null) {
            this.question4 = coverLetter.question4;
        }
        if (coverLetter.content4 != null) {
            this.content4 = coverLetter.content4;
        }
        if (coverLetter.question5 != null) {
            this.question5 = coverLetter.question5;
        }
        if (coverLetter.content5 != null) {
            this.content5 = coverLetter.content5;
        }
        return this;
    }
}

