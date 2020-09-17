package com.rockpaperscissors.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerateRandomNumber {
	
	public int generateRandomNumberFrom3() {
		Random random = new Random();

		return random.nextInt(3);
	}
}
