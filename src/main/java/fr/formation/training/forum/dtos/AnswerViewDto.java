package fr.formation.training.forum.dtos;

import java.time.LocalDateTime;

public class AnswerViewDto {
    private final String author;
    private final String text;
    private final LocalDateTime answerDate;

    public AnswerViewDto(String author, String text, LocalDateTime answerDate) {
        this.author = author;
        this.text = text;
        this.answerDate = answerDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getAnswerDate() {
        return answerDate;
    }
}
