package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.Waits;

public class Registration extends Base{

	Base base = new Base();
	WebDriver driver;
	
	public Registration() {
		super();
	}
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException {
		
//		readPropertiesFile();
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		
	}
	@BeforeSuite
	public void generateEmailForRegistration() throws InterruptedException, IOException {
		base.addTimestampToEmail();
//		Waits.waitFor2seconds();
//		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.welcomeText)).isDisplayed());
		
	}
	
	@Test
	public void Regsiter001_registerUser() throws InterruptedException {
		
		Waits.waitFor5seconds();
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor5seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
		
	}
	
	@Test
	public void Register002_createAccountwithoutdata() throws InterruptedException {
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
	
	@Test
	public void Register003_registerExistingUser() throws InterruptedException {
		
		Waits.waitFor5seconds();
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("emailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor5seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.captchaError)).isDisplayed());
		
	}
	
	@Test
	public void Regsiter004_registerUserWithNewsLetterSignUp() throws InterruptedException {
		
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.id(LocatorPages.newletterSignUpCheckbox)).click();
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("password"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor5seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(LocatorPages.validationNewsLetterSignUp)).isDisplayed());
	}
	@Test
	public void Register005_validateStrongPassword() {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("password"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.strongPassword)).isDisplayed());
		
	}
	@Test
	public void Register006_validateWeakPasswordAndRegister() throws InterruptedException {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("weakPass"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.weakPassword)).isDisplayed());	
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("weakPass"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Waits.waitFor5seconds();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(LocatorPages.validationNewsLetterSignUp)).isDisplayed());
	}
	@Test
	public void Register007_validatePasswordCritera() {
		driver.findElement(By.linkText(LocatorPages.createAccLink)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.createAccTitle)).isDisplayed());
		driver.findElement(By.id(LocatorPages.fisrtNameField)).sendKeys(testData.getProperty("newUserFirstName"));
		driver.findElement(By.id(LocatorPages.lastNameField)).sendKeys(testData.getProperty("newUserLastName"));
		driver.findElement(By.id(LocatorPages.newletterSignUpCheckbox)).click();
		driver.findElement(By.name(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
		driver.findElement(By.name(LocatorPages.regPwdField)).sendKeys(testData.getProperty("missingCriteria"));
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.missingPassCriteria)).isDisplayed());
		driver.findElement(By.id(LocatorPages.confirmPwdfield)).sendKeys(testData.getProperty("missingCriteria"));
		driver.findElement(By.xpath(LocatorPages.createAccBtn)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.missingPassCriteria)).isDisplayed());

	}
	
	@Test
	public void Register008_confirmPasswordDoesNotMatchPassword() {
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
