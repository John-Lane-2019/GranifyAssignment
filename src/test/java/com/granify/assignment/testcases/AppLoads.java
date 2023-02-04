package com.granify.assignment.testcases;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AppLoads {
	
	WebDriver driver;
	String url;
	
	@Before
	public void setUp() {
		this.driver = new ChromeDriver();
		this.url = "https://www.theonlinecalculator.com/";
		driver.get(url);
	}
	
	
	@Test
	public void verifyAppLoads() {
		
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		boolean titleIsVisible = wait.until(ExpectedConditions.titleIs(driver.getTitle()));
		
		Assert.assertTrue(titleIsVisible);
				
	}
	
	
	@After
	public void closeBrowser() {
		
		driver.close();
		
	}

}
