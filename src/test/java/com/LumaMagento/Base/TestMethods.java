package com.LumaMagento.Base;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		try {
			driver.findElement(By.xpath(ItemType)).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static void selectOptionFromDropDown(String dropDown, String value) {
		WebElement ele = Waits.xpath(dropDown);
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
	public static void scrollToView(String shippingNextButton) {
		Actions actions = new Actions(driver);
		WebElement elementToScroll = Waits.xpath(shippingNextButton);
        // Perform a click-and-hold followed by releasing the UP arrow key
        actions.scrollToElement(elementToScroll).clickAndHold().sendKeys(org.openqa.selenium.Keys.ARROW_UP).release().perform();
	}
}
