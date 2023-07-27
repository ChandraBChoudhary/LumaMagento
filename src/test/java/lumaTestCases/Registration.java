package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.Waits;

public class Registration extends Base{
	
	public Registration() throws IOException {
		
		super();
		
		// TODO Auto-generated constructor stub
	}

	Base base;
	WebDriver driver;
	

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		base = new Base();
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		Waits.waitFor5seconds();
		
	}
	
	@Test(priority = 7)
	public void Regsiter001_registerUser() throws InterruptedException, IOException {
		base.addTimestampToEmail();
//		base.readConfigFile();
		System.out.println("Email being printed from property file : " + prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor2seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
		
	}
	
	@Test(priority = 1)
	public void Register002_createAccountwithoutdata() throws InterruptedException, IOException {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor2seconds();
		Assert.assertTrue(driver.findElement(By.id(LocatorPages.requiredFirstName)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(LocatorPages.requiredLastName)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(LocatorPages.requiredEmail)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(LocatorPages.requiredPassword)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id(LocatorPages.requiredConfirmPassword)).isDisplayed());
		
	}
	
	@Test(priority = 2)
	public void Register003_registerExistingUser() throws InterruptedException, IOException {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("emailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor2seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.captchaError)).isDisplayed());
		
	}
	
//	@Test(priority = 3)
//	public void Regsiter004_registerUserWithNewsLetterSignUp() throws Throwable {
//		base.addTimestampToEmail();
//		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
//		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
//		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
//		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
//		Waits.waitFor5seconds();
//		driver.findElement(By.id(LocatorPages.newletterSignUpCheckbox)).click();
//		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
//		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
//		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
//		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
//		Waits.waitFor2seconds();
////		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
////		Assert.assertTrue(driver.findElement(By.cssSelector(LocatorPages.validationNewsLetterSignUp)).isDisplayed());
//	}
	@Test(priority = 3)
	public void Register005_validateStrongPassword() {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.strongPassword)).isDisplayed());
		
	}
	@Test(priority = 4)
	public void Register006_validateWeakPasswordAndRegister() throws Throwable {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		//base.addTimestampToEmail();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("weakPass"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.weakPassword)).isDisplayed());	
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("weakPass"));

	}
	@Test(priority = 5)
	public void Register007_validatePasswordCritera() throws IOException {
		//base.addTimestampToEmail();
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("missingCriteria"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.missingPassCriteria)).isDisplayed());
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("missingCriteria"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.missingPassCriteria)).isDisplayed());

	}
	
	@Test(priority = 6)
	public void Register008_confirmPasswordDoesNotMatchPassword() throws IOException {
		//base.addTimestampToEmail();
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("missingCriteria"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.passwordDoNotMatch)).isDisplayed());

	}
}
