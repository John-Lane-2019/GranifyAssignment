package com.granify.assignment.testcases;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.granify.assignment.services.*;

import junit.framework.Assert;

@SuppressWarnings("deprecation") // tests wouldn't run on my device using the latest version of JUnit
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

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromZeroToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int sum = firstValue + secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("add")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedSum = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(sum, Integer.parseInt(displayedSum));

	}

	@Test
	public void verifyTwoSingleDigitIntegersSubtractedCorrecly() {
		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromZeroToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int difference = firstValue - secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("subtract")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedDifference = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(difference, Integer.parseInt(displayedDifference));
	}

	@Test
	public void verifyTwoSingleDigitIntegersMultipliedCorrectly() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromZeroToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int product = firstValue * secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("multiply")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedProduct = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(product, Integer.parseInt(displayedProduct));

	}

	@Test
	public void verifyTwoSingleDigitIntegersDivideCorrectly() {
		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		BigDecimal a = new BigDecimal(firstValue);
		BigDecimal b = new BigDecimal(secondValue);
		BigDecimal quotient = a.divide(b, 10, RoundingMode.HALF_UP);

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("divide")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedQuotient = driver.findElement(By.id("display")).getAttribute("value");

		BigDecimal x = new BigDecimal(displayedQuotient);
		BigDecimal y = new BigDecimal(quotient.toString());
		BigDecimal result = x.divide(y);

		Assert.assertEquals("1", result.toString());

	}

	@Test
	public void verifyDividingByZeroCausesErrorMessage() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("divide")).click();
		driver.findElement(By.name(numberKeys[0])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedError = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals("Not a Number", displayedError);

	}

	@Test
	public void verifyAddingTwoNegativeIntegersProducesNegativeSum() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int sum = (firstValue * -1) + (secondValue * -1);

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("add")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("calculate")).click();

		String displayedSum = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(sum, Integer.parseInt(displayedSum));

	}

	@Test
	public void verifyAddingNegativeToPositiveProducesSumWithSignOfLargerNumber() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int sum = (firstValue * -1) + secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("add")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedSum = driver.findElement(By.id("display")).getAttribute("value");
		
		Assert.assertEquals(sum, Integer.parseInt(displayedSum));

	}

	@Test
	public void verifySubtractingTwoNegativeIntegersProducesAPositiveNegativeOrZero() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int difference = (firstValue * -1) - (secondValue * -1);

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("subtract")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("calculate")).click();

		String displayedDifference = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(difference, Integer.parseInt(displayedDifference));
		Assert.assertTrue(difference >= 0 || difference < 0);

	}

	@Test
	public void verifyMultiplyingNegativeIntegerByPositiveIntegerRendersNegativeProduct() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int product = (firstValue * -1) * secondValue;

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("multiply")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("calculate")).click();

		String displayedProduct = driver.findElement(By.id("display")).getAttribute("value");

		Assert.assertEquals(product, Integer.parseInt(displayedProduct));
		Assert.assertTrue(product < 0);

	}

	@Test
	public void verifyMultiplyingTwoNegativeIntegersRendersPositiveProduct() {

		int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

		int firstValue = twoRandomNumbers[0];
		int secondValue = twoRandomNumbers[1];

		int product = (firstValue * -1) * (secondValue *-1);

		driver.findElement(By.name(numberKeys[firstValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("multiply")).click();
		driver.findElement(By.name(numberKeys[secondValue])).click();
		driver.findElement(By.name("negateButton")).click();
		driver.findElement(By.name("calculate")).click();
					
		String displayedProduct = driver.findElement(By.id("display")).getAttribute("value");
					
		Assert.assertEquals(product, Integer.parseInt(displayedProduct));
		Assert.assertTrue(product > 0);
	}
	
	    @Test
		public void verifyDividingPositiveByNegativeRendersNegativeQuotient() {

			int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

			int firstValue = twoRandomNumbers[0];
			int secondValue = twoRandomNumbers[1];
			
			BigDecimal x = new BigDecimal(firstValue);
			BigDecimal y = new BigDecimal(secondValue * -1);
			BigDecimal quotient = x.divide(y, 10, RoundingMode.HALF_UP);

			driver.findElement(By.name(numberKeys[firstValue])).click();
			driver.findElement(By.name("divide")).click();
			driver.findElement(By.name(numberKeys[secondValue])).click();
			driver.findElement(By.name("negateButton")).click();
			driver.findElement(By.name("calculate")).click();
			
			String displayedQuotient = driver.findElement(By.id("display")).getAttribute("value");
						
			BigDecimal a = new BigDecimal(displayedQuotient);
			BigDecimal b = new BigDecimal(quotient.toString());
			BigDecimal result = a.divide(b);
			
			Assert.assertEquals("1", result.toString());
			
	}
		
		@Test
		public void verifyDividingNegativeByNegativeRendersPositiveQuotient() {

			int[] twoRandomNumbers = RandomNumberGenerator.generateTwoPositiveIntegersFromOneToNine();

			int firstValue = twoRandomNumbers[0];
			int secondValue = twoRandomNumbers[1];
			
			BigDecimal x = new BigDecimal(firstValue * -1);
			BigDecimal y = new BigDecimal(secondValue * -1);
			BigDecimal quotient = x.divide(y, 10, RoundingMode.HALF_UP);

			driver.findElement(By.name(numberKeys[firstValue])).click();
			driver.findElement(By.name("negateButton")).click();
			driver.findElement(By.name("divide")).click();
			driver.findElement(By.name(numberKeys[secondValue])).click();
			driver.findElement(By.name("negateButton")).click();
			driver.findElement(By.name("calculate")).click();
			
			String displayedQuotient = driver.findElement(By.id("display")).getAttribute("value");
						
			BigDecimal a = new BigDecimal(displayedQuotient);
			BigDecimal b = new BigDecimal(quotient.toString());
			BigDecimal result = a.divide(b);
			
			Assert.assertEquals("1", result.toString());
			
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
