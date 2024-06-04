package org.selfin.dto;

import lombok.Getter;
import lombok.Setter;
import org.selfin.entity.CoverLetterEntity;
import org.selfin.entity.PassedCoverLetterEntity;

@Setter
@Getter
public class PassedCoverLetterDTO {

    private String username;
    private String title;
    private String company;
    private String question1;
    private String content1;

    private String question2;
    private String content2;

    private String question3;
    private String content3;

    private String question4;
    private String content4;

    private String question5;
    private String content5;


    public PassedCoverLetterDTO(PassedCoverLetterEntity coverLetter) {
        this.title = coverLetter.getTitle();
        this.username = coverLetter.getUsername();
        this.company = coverLetter.getCompany();

        this.question1 = coverLetter.getQuestion1();
        this.content1 = coverLetter.getContent1();

        this.question2 = coverLetter.getQuestion2();
        this.content2 = coverLetter.getContent2();

        this.question3 = coverLetter.getQuestion3();
        this.content3 = coverLetter.getContent3();

        this.question4 = coverLetter.getQuestion4();
        this.content4 = coverLetter.getContent4();

        this.question5 = coverLetter.getQuestion5();
        this.content5 = coverLetter.getContent5();


    }

    public CoverLetterEntity toEntity() {
        CoverLetterEntity entity = new CoverLetterEntity();
        entity.setUsername(this.username);
        entity.setTitle(this.title);
        entity.setQuestion1(this.question1);
        entity.setQuestion2(this.question2);
        entity.setQuestion3(this.question3);
        entity.setQuestion4(this.question4);
        entity.setQuestion5(this.question5);
        entity.setContent1(this.content1);
        entity.setContent2(this.content2);
        entity.setContent3(this.content3);
        entity.setContent4(this.content4);
        entity.setContent5(this.content5);
        return entity;
    }
}
