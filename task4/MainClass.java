package com.codesoft.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		// Example usage
		List<QuizQuestion> quizQuestions = new ArrayList<>();
		quizQuestions.add(new QuizQuestion("Who invented Java Programming?",
				Arrays.asList("Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"), 1));
		quizQuestions.add(new QuizQuestion("Which component is used to compile, debug and execute the java programs?",
				Arrays.asList("JRE", " JIT", "JDK", "JVM"), 2));
		quizQuestions.add(new QuizQuestion("What is the extension of java code files?",
				Arrays.asList(".js", ".txt", ".class", ".java"), 3));

		Quiz quiz = new Quiz(quizQuestions);
		quiz.startQuiz();
	}
}
