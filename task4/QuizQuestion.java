package com.codesoft.task4;

import java.util.List;

public class QuizQuestion {
	private String question;
	private List<String> options;
	private int correctOptionIndex;

	public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
		this.question = question;
		this.options = options;
		this.correctOptionIndex = correctOptionIndex;
	}

	public String getQuestion() {
		return question;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getCorrectOptionIndex() {
		return correctOptionIndex;
	}
}
