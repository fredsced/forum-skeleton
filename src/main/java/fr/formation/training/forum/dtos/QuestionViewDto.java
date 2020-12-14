package fr.formation.training.forum.dtos;

import java.time.LocalDateTime;

public class QuestionViewDto {

    private final Long id;

    private final String phrase;

    private final String text;

    private final String author;

    private final LocalDateTime questionDate;

    private final String technologyName;

    public QuestionViewDto(Long id, String phrase, String text, String author,
	    LocalDateTime questionDate, String technologyName) {
	this.id = id;
	this.phrase = phrase;
	this.text = text;
	this.author = author;
	this.questionDate = questionDate;
	this.technologyName = technologyName;
    }

    public Long getId() {
	return id;
    }

    public String getPhrase() {
	return phrase;
    }

    public String getText() {
	return text;
    }

    public String getAuthor() {
	return author;
    }

    public LocalDateTime getQuestionDate() {
	return questionDate;
    }

    public String getTechnologyName() {
	return technologyName;
    }
}
