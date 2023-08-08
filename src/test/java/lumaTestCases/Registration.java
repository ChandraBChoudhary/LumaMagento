package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.TestMethods;
import com.LumaMagento.Base.Waits;

public class Registration extends Base{
	
	public Registration() throws IOException {
		
		super();
		
		// TODO Auto-generated constructor stub
	}

	Base base = new Base();
	WebDriver driver;
	

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		Waits.waitFor5seconds();
		
	}
	
	@Test(priority = 7)
	public void Regsiter001_registerUser() throws InterruptedException, IOException {
		base.addTimestampToEmail();
//		base.readConfigFile();
		System.out.println("Email being printed from property file : " + prop.getProperty("newUserEmailAddress"));
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(emailTxtBx, prop.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("password"));
		TestMethods.enterInputData_ID(confirmPwdfield, testData.getProperty("password"));
		TestMethods.xpathClick(createAccBtn);
		Waits.waitFor2seconds();
		TestMethods.elementIsDisplayed(LocatorPages.registrationSucessValidation);
	}
	
	@Test(priority = 1)
	public void Register002_createAccountwithoutdata() throws InterruptedException, IOException {
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.xpathClick(createAccBtn);
		Waits.waitFor2seconds();
		TestMethods.elementIsDisplayed(LocatorPages.requiredFirstName);
		TestMethods.elementIsDisplayed(LocatorPages.requiredLastName);
		TestMethods.elementIsDisplayed(LocatorPages.requiredEmail);
		TestMethods.elementIsDisplayed(LocatorPages.requiredPassword);
		TestMethods.elementIsDisplayed(LocatorPages.requiredConfirmPassword);
		
	}
	
	@Test(priority = 2)
	public void Register003_registerExistingUser() throws InterruptedException, IOException {
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(emailTxtBx, testData.getProperty("emailAddress"));
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("password"));
		TestMethods.enterInputData_ID(confirmPwdfield, testData.getProperty("password"));
		TestMethods.xpathClick(createAccBtn);
		Waits.waitFor2seconds();
		TestMethods.elementIsDisplayed(LocatorPages.captchaError);
	}
	
//	@Test(priority = 3)
//	public void Regsiter004_registerUserWithNewsLetterSignUp() throws Throwable {
//		base.addTimestampToEmail();
//		TestMethods.linkTextClick(createAccLink);
//		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
//		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
//		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
//		Waits.waitFor5seconds();
//		TestMethods.IDClick(newletterSignUpCheckbox);
//		TestMethods.enterInputData_Name(emailTxtBx, prop.getProperty("newUserLastName"));
//		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("password"));
//		TestMethods.enterInputData_ID(confirmPwdfield, prop.getProperty("password"));
//		TestMethods.xpathClick(createAccBtn);
//		Waits.waitFor2seconds();
////		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.registrationSucessValidation)).isDisplayed());
////		Assert.assertTrue(driver.findElement(By.cssSelector(LocatorPages.validationNewsLetterSignUp)).isDisplayed());
//	}
//	
	
	@Test(priority = 3)
	public void Register005_validateStrongPassword() {
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("password"));
		TestMethods.elementIsDisplayed(LocatorPages.strongPassword);		
	}
	
	@Test(priority = 4)
	public void Register006_validateWeakPasswordAndRegister() throws Throwable {
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);	
		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(emailTxtBx, prop.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("weakPass"));
		TestMethods.elementIsDisplayed(LocatorPages.weakPassword);
		TestMethods.enterInputData_ID(confirmPwdfield, testData.getProperty("weakPass"));
	}
	
	@Test(priority = 5)
	public void Register007_validatePasswordCritera() throws IOException {
		//base.addTimestampToEmail();
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(emailTxtBx, prop.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("missingCriteria"));
		TestMethods.elementIsDisplayed(LocatorPages.missingPassCriteria);
		TestMethods.enterInputData_ID(confirmPwdfield, testData.getProperty("missingCriteria"));
		TestMethods.xpathClick(createAccBtn);
		TestMethods.elementIsDisplayed(LocatorPages.missingPassCriteria);
	}
	
	@Test(priority = 6)
	public void Register008_confirmPasswordDoesNotMatchPassword() throws IOException {
		//base.addTimestampToEmail();
		TestMethods.linkTextClick(createAccLink);
		TestMethods.elementIsDisplayed(LocatorPages.createAccTitle);
		TestMethods.enterInputData_ID(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_ID(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(emailTxtBx, prop.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(regPwdField, testData.getProperty("password"));
		TestMethods.enterInputData_ID(confirmPwdfield, testData.getProperty("missingCriteria"));
		TestMethods.xpathClick(createAccBtn);
		TestMethods.elementIsDisplayed(LocatorPages.passwordDoNotMatch);
	}
}
