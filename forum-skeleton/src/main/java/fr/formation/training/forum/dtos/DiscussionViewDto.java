package fr.formation.training.forum.dtos;

public class DiscussionViewDto {

    private final QuestionViewDto question;

    public DiscussionViewDto(QuestionViewDto question) {
	this.question = question;
    }

    public QuestionViewDto getQuestion() {
	return question;
    }
}
