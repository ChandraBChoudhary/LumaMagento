package lumaTestCases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.*;

public class Login extends Base{
	//POM_methods brow = new POM_methods();
	Base base = new Base();
	WebDriver driver;
	
	public Login() throws IOException {
		//super();
	}
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		
	}
	
	@Test(priority = 1)
	public void Login001_LoginWithValidCredentials() throws IOException, Exception {
		//base.readConfigFile();
		base.loginToApplication();
		TestMethods.elementIsDisplayed(LocatorPages.userName);
	    TestMethods.xpathClick(LocatorPages.profiledrpdwn);
	    TestMethods.linkTextClick(LocatorPages.signOutBtn);
        
	}
	@Test(priority = 2)
	public void Login002_LoginWithInvalidCredentials() throws IOException, Exception {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_ID(LocatorPages.emailTxtBx, testData.getProperty("incorrectEmail"));
		TestMethods.enterInputData_Name(LocatorPages.passwordField, testData.getProperty("invalidPass"));
		TestMethods.xpathClick(LocatorPages.signInButton);
        Waits.waitFor3seconds();
        TestMethods.elementIsDisplayed(LocatorPages.captchaError);
       
	}
	
	@Test(priority = 3)
	public void Login003_valiDEmail_InvalidPass() throws Throwable {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_ID(LocatorPages.emailTxtBx, testData.getProperty("emailAddress"));
		TestMethods.enterInputData_Name(LocatorPages.passwordField, testData.getProperty("invalidPass"));
		TestMethods.xpathClick(LocatorPages.signInButton);
        Waits.waitFor3seconds();
        TestMethods.elementIsDisplayed(LocatorPages.captchaError);

	}
	
	@Test(priority = 4)
	public void Login004_invaliDEmail_validPassword() throws InterruptedException {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_ID(LocatorPages.emailTxtBx, testData.getProperty("invalidEmail"));
		TestMethods.enterInputData_Name(LocatorPages.passwordField, testData.getProperty("password"));
		TestMethods.xpathClick(LocatorPages.signInButton);
        Waits.waitFor3seconds();
        TestMethods.elementIsDisplayed(LocatorPages.emailValidationError);
	}
	
	@Test(priority = 5)
	public void Login005_loginWithoutEmailAndPAssword() throws InterruptedException {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.xpathClick(LocatorPages.signInButton);
		Waits.waitFor1seconds();
		TestMethods.elementIsDisplayed(LocatorPages.emailValidationError);
		TestMethods.elementIsDisplayed(LocatorPages.pwdValidationError);
	}
	
	@Test(priority = 6)
	public void Login006_loginWithOnlyEmail() {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_ID(LocatorPages.emailTxtBx, testData.getProperty("invalidEmail"));
		TestMethods.xpathClick(LocatorPages.signInButton);
		TestMethods.elementIsDisplayed(LocatorPages.pwdValidationError);
	}
	
	@Test(priority = 7)
	public void Login007_loginWithOnlyPassword(){
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_Name(LocatorPages.passwordField, testData.getProperty("password"));
		TestMethods.xpathClick(LocatorPages.signInButton);
		TestMethods.elementIsDisplayed(LocatorPages.emailValidationError);
	}

}
