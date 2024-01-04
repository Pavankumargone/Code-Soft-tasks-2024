package com.codesoft.task1;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {
		Random num= new Random();
		int number=num.nextInt(100);
		System.out.println(" Enter the Random number between 0 to 100");
		System.out.println(number);
	}

}
