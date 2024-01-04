package com.codesoft.task1;
//Task 1
import java.util.Random;
import java.util.Scanner;

public class guessTheGeneratedumber {

	public static void main(String[] args) {
		int userScore = 0;
		int numberOfAttempts = 0;
		Random num = new Random();
		Scanner sc = new Scanner(System.in);
		int guessNum;
		int Randomnumber;
		System.out.println(" Enter the guess number");

		do {
			guessNum = sc.nextInt();

			if ((guessNum <= 5)) {
				numberOfAttempts++;
				
			}

			Randomnumber = num.nextInt(5) + 1;
			System.out.println(" Enter the Random number");
			System.out.println(Randomnumber);
			if (guessNum == Randomnumber) {
				userScore++;
				System.out.println("guess Number is correct");

			} else {
				System.out.println("guess Number is incorrect : enter number again");

			}

		} while (guessNum != Randomnumber);
		System.out.println(" we found the guessNum == Randomnumber ");
		System.out.println("number of attempts: "+numberOfAttempts);
		System.out.println("user score: "+userScore);

	}
}
