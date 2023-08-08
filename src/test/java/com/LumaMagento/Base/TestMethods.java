package com.LumaMagento.Base;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import lumaTestCases.LocatorPages;

public class TestMethods extends Base{
	public TestMethods() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Base base new Base();

	public static void navigateToParticularCategoryInWomen(String Category, String subCategory, String ItemType) throws Throwable{
		testHoverElement(Category);
		testHoverElement(subCategory);
		Waits.waitFor5seconds();
		driver.findElement(By.xpath(ItemType)).click();
	}
	
	public static void enterInputData_linkText(String locator, String textToEnter) {
		WebElement ele = Waits.linkText(locator);
		System.out.println("Element to be located -" + ele);
		ele.sendKeys(textToEnter);	
	
	}
	public static void enterInputData_Xpath(String locator, String textToEnter) {
		WebElement ele = Waits.xpath(locator);
		System.out.println("Element to be located -" + ele);
		ele.sendKeys(textToEnter);	
	
	}
	public static void enterInputData_ID(String locator, String textToEnter) {
		WebElement ele = Waits.id(locator);
		System.out.println("Element to be located -" + ele);
		ele.sendKeys(textToEnter);	
	
	}
	public static void enterInputData_Name(String locator, String textToEnter) {
		WebElement ele = Waits.name(locator);
		System.out.println("Element to be located -" + ele);
		ele.sendKeys(textToEnter);	
	
	}
	
	public static void xpathClick(String locator) {
		WebElement ele = Waits.xpath(locator);
		ele.click();	
	
	}
	public static void linkTextClick(String locator) {
		WebElement ele = Waits.linkText(locator);
		ele.click();	
	
	}
	public static void elementIsDisplayed(String locator) {
		Assert.assertTrue(driver.findElement(By.xpath(locator)).isDisplayed(), locator + " not found");
	}
//	

	public static void IDClick(String locator) {
		WebElement ele = Waits.id(locator);
		ele.click();
		
	}
}
