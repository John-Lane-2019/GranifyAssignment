package com.granify.assignment.testcases;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.granify.assignment.services.*;


public class ArithmeticFunctions {
	
	WebDriver driver;
	String url;
	
	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
		this.url = "https://www.theonlinecalculator.com/";
		driver.get(url);
	}
	
	@Test
	public void verifyTwoSingleDigitIntegersAddedCorrectly() {
		
		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegers();
		
		System.out.println(Arrays.toString(twoRandomNumbers));
		
	}

}
