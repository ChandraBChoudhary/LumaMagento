package com.LumaMagento.Base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Waits extends Base{
	
	
	public Waits() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void waitFor15seconds() throws InterruptedException {
		Thread.sleep(15000);
	}
	public static void waitFor10seconds() throws InterruptedException {
		Thread.sleep(10000);
	}
	public static void waitFor5seconds() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static void waitFor4seconds() throws InterruptedException {
		Thread.sleep(4000);
	}
	public static void waitFor3seconds() throws InterruptedException {
		Thread.sleep(3000);
	}
	public static void waitFor2seconds() throws InterruptedException {
		Thread.sleep(2000);
	}
	public static void waitFor1seconds() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	
	
	public static WebElement xpath(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element;
	
	}
	public static WebElement id(String locator) {
		WebElement element = driver.findElement(By.id(locator));
		return element;
	
	}
	public static WebElement name(String locator) {
		WebElement element = driver.findElement(By.name(locator));
		return element;
	
	}
	public static WebElement linkText(String locator) {
		WebElement element = driver.findElement(By.linkText(locator));
		return element;
	}
	
//	public static WebElement selectValue(String locator) {
//		WebElement element = driver.findElement(By.xpath(locator));
//		return element;
//		
//	}
//	public static void linkText(String locator) {
//		driver.findElement(By.linkText(locator));
//	
//	}
}
