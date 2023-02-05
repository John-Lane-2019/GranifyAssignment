package com.granify.assignment.testcases;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.granify.assignment.services.*;

import junit.framework.Assert;

@SuppressWarnings("deprecation")//tests wouldn't run on my device using the latest version of JUnit
public class ArithmeticFunctions {

	private static WebDriver driver = new ChromeDriver();;
	private static String url;
	private String[] numberKeys = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	@BeforeClass
	public static void setUp() {
		url = "https://www.theonlinecalculator.com/";
		driver.get(url);
	}

	
	@Test
	public void verifyTwoSingleDigitIntegersAddedCorrectly() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegers();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int sum = firstValue + secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("add")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		System.out.println("FIRST VALUE: " + firstValue);
		System.out.println("SECOND VALUE: " + secondValue);
		System.out.println("SUM: " + sum);

		String displayedSum = driver.findElement(By.id("display")).getAttribute("value");

		System.out.println("DISPLAYED SUM: " + displayedSum);

		Assert.assertEquals(sum, Integer.parseInt(displayedSum));

	}

	
	@Test
	public void verifyTwoSingleDigitIntegersSubtractedCorrecly() {
		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegers();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int difference = firstValue - secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("subtract")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		System.out.println("FIRST VALUE: " + firstValue);
		System.out.println("SECOND VALUE: " + secondValue);
		System.out.println("DIFFERENCE: " + difference);

		String displayedDifference = driver.findElement(By.id("display")).getAttribute("value");

		System.out.println("DISPLAYED DIFFERENCE: " + displayedDifference);

		Assert.assertEquals(difference, Integer.parseInt(displayedDifference));

	}
	
	
	@Test
	public void verifyTwoSingleDigitIntegersMultipliedCorrectly() {
		
		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegers();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int product = firstValue * secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("multiply")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		System.out.println("FIRST VALUE: " + firstValue);
		System.out.println("SECOND VALUE: " + secondValue);
		System.out.println("PRODUCT: " + product);

		String displayedProduct = driver.findElement(By.id("display")).getAttribute("value");

		System.out.println("DISPLAYED DIFFERENCE: " + displayedProduct);

		Assert.assertEquals(product, Integer.parseInt(displayedProduct));
		
		
	}

	@After
	public void clearGUI() {
		driver.findElement(By.name("clearButton")).click();

	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
	
	

}
