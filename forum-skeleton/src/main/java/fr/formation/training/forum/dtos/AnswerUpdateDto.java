package fr.formation.training.forum.dtos;

import javax.validation.constraints.*;

public class AnswerUpdateDto {

    @NotBlank
    @Size(max = 1000)
    private String text;

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }
}
