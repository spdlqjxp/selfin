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
public class PassedCoverLetterEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column
    private String username;
    @Column
    private String title;
    @Column
    private String company;
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

}

