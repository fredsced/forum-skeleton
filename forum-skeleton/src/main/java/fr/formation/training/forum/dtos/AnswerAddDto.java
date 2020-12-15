package fr.formation.training.forum.dtos;

import javax.validation.constraints.*;

public class AnswerAddDto {

    @NotBlank
    @Size(max = 1000)
    private String text;

    @NotBlank
    @Size(max = 50)
    private String author;

    @NotNull
    @Positive
    private Long questionId;

    public Long getQuestionId() {
	return questionId;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public void setQuestionId(Long questionId) {
	this.questionId = questionId;
    }
}
