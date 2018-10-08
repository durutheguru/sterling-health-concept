package io.duru.projects.sterling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * created by dduru on 07/10/2018
 */
@Entity
@Table(name = "faq")
public class FAQ extends BaseEntity {


    @NotEmpty(message = "Question cannot be empty")
    @Column(nullable = false, length = 250)
    @Size(max = 250, message = "Question length cannot exceed 250")
    private String question;

    @NotEmpty(message = "FAQ Answer cannot be empty")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String answer;



    public String getQuestion() {
        return question;
    }

    public FAQ setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public FAQ setAnswer(String answer) {
        this.answer = answer;
        return this;
    }


}