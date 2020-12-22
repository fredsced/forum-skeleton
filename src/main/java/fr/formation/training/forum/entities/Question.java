package fr.formation.training.forum.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A question. The natural key of the entity is the author and question creation
 * datetime.
 */
@Entity
@Table(name = "questions")
public class Question extends AbstractEntity {

    @Column(name = "question_phrase")
    private String phrase;

    @Column(name = "question_text")
    private String text;

    @Column(name = "question_author")
    private String author;

    @Column(name = "question_datetime")
    private LocalDateTime questionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_id")
    private Technology technology;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "question")
    private List<Answer> answers;

    public void setQuestionDate(LocalDateTime creationDate) {
	questionDate = creationDate;
    }

    public void setTechnology(Technology technology) {
	this.technology = technology;
    }

    public String getPhrase() {
	return phrase;
    }

    public void setPhrase(String phrase) {
	this.phrase = phrase;
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

    public LocalDateTime getQuestionDate() {
	return questionDate;
    }

    public Technology getTechnology() {
	return technology;
    }
}
