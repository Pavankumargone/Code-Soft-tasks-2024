package com.codesoft.task4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
	private List<QuizQuestion> questions;
	private int currentQuestionIndex;
	private int userScore;
	private static final int QUESTION_TIME_LIMIT = 10; // Time limit for each question in seconds

	public Quiz(List<QuizQuestion> questions) {
		this.questions = questions;
		this.currentQuestionIndex = 0;
		this.userScore = 0;
	}

	public void displayQuestion() {
		QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
		System.out.println("Question: " + currentQuestion.getQuestion());

		List<String> options = currentQuestion.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println((i + 1) + ". " + options.get(i));
		}
	}

	public void startQuiz() {
		Scanner scanner = new Scanner(System.in);

		for (QuizQuestion question : questions) {
			displayQuestion();
			System.out.print("Your choice (1-" + question.getOptions().size() + "): ");

			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					System.out.println("\nTime's up! Moving to the next question.");
					timer.cancel();
					nextQuestion();
				}
			};

			timer.schedule(task, QUESTION_TIME_LIMIT * 100000); // Convert seconds to milliseconds

			try {
				int userChoice = scanner.nextInt();
				timer.cancel(); // Cancel the timer as the user has submitted an answer
				checkAnswer(userChoice - 1, question.getCorrectOptionIndex());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Skipping to the next question.");
				timer.cancel();
			}

			nextQuestion();
		}

		displayResult();
	}

	private void nextQuestion() {
		currentQuestionIndex++;
		if (currentQuestionIndex < questions.size()) {
			System.out.println("\nMoving to the next question...\n");
		}
	}

	private void checkAnswer(int userChoice, int correctOptionIndex) {
		if (userChoice == correctOptionIndex) {
			System.out.println("Correct!\n");
			userScore++;
		} else {
			System.out.println("Incorrect. The correct answer was option " + (correctOptionIndex + 1) + ".\n");
		}
	}

	private void displayResult() {
		System.out.println("Quiz completed!");
		System.out.println("Your final score: " + userScore + "/" + questions.size());
	}
}