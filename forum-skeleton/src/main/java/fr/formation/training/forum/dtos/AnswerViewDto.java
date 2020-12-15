package fr.formation.training.forum.dtos;

import java.time.LocalDateTime;

public class AnswerViewDto {

    private final String text;

    private final String author;

    private final LocalDateTime answerDate;

    public AnswerViewDto(String text, String author, LocalDateTime answerDate) {
	this.text = text;
	this.author = author;
	this.answerDate = answerDate;
    }

    public String getText() {
	return text;
    }

    public LocalDateTime getAnswerDate() {
	return answerDate;
    }

    public String getAuthor() {
	return author;
    }
}
