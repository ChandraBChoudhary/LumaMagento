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
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
        driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("password"));
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
//        //Captcha is displayed after 1st sign in click 
//        driver.findElement(By.id("email")).sendKeys(testData.getProperty("emailAddress"));
//        driver.findElement(By.name("login[password]")).sendKeys(testData.getProperty("password"));
//        base.readCaptcha();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.userName)).isDisplayed());
        driver.findElement(By.xpath(LocatorPages.profiledrpdwn)).click();
        driver.findElement(By.linkText(LocatorPages.signOutBtn)).click();
        
	}
	@Test(priority = 2)
	public void Login002_LoginWithInvalidCredentials() throws IOException, Exception {
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("incorrectEmail"));
        driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("invalidPass"));
//        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
//      //Captcha is displayed after 1st sign in click 
//        driver.findElement(By.id("email")).sendKeys(testData.getProperty("incorrectEmail"));
//        driver.findElement(By.name("login[password]")).sendKeys(testData.getProperty("invalidPass"));
//      //base.readCaptcha();
//        Waits.waitFor15seconds();
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Waits.waitFor3seconds();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.captchaError)).isDisplayed());
       
	}
	
	@Test(priority = 3)
	public void Login003_valiDEmail_InvalidPass() throws Throwable {
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("emailAddress"));
        driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("invalidPass"));
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.captchaError)).isDisplayed());
	}
	
	@Test(priority = 4)
	public void Login004_invaliDEmail_validPassword() throws InterruptedException {
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("invalidEmail"));
        driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("password"));
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.emailValidationError)).isDisplayed());
	}
	
	@Test(priority = 5)
	public void Login005_loginWithoutEmailAndPAssword() {
		
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.emailValidationError)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.pwdValidationError)).isDisplayed());
	}
	
	@Test(priority = 6)
	public void Login006_loginWithOnlyEmail() {
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(testData.getProperty("invalidEmail"));
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.pwdValidationError)).isDisplayed());
	}
	
	@Test(priority = 7)
	public void Login007_loginWithOnlyPassword(){
		driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
        driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("password"));
        driver.findElement(By.xpath(LocatorPages.signInButton)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.emailValidationError)).isDisplayed());
	}

}
