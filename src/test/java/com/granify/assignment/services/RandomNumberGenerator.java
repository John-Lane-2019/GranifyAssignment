package com.granify.assignment.services;

public class RandomNumberGenerator {

	public RandomNumberGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public static int[] generateTwoPositiveIntegers() {
		
		int max = 9;
		int min = 0;
		
		double x = Math.random()*(max - min + 1)+ min; 
		double y = Math.random()*(max - min + 1)+ min;
		
		int[] twoPositiveIntegers = new int[2];
		
		twoPositiveIntegers[0] = (int) x;
		twoPositiveIntegers[1] = (int) y;
		
		
		return twoPositiveIntegers;
		
	} 

}
