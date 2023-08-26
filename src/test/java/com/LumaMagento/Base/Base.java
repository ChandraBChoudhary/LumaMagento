package com.LumaMagento.Base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.io.OutputStream;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lumaTestCases.LocatorPages;
import net.sourceforge.tess4j.*;

public class Base extends LocatorPages{
	public static WebDriver driver ;
	public static Properties prop = new Properties();
	public static Properties testData = new Properties();
	
	protected ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

	public Base() throws IOException {
			File testDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\LumaMagento\\TestData\\testData.properties");		
			FileInputStream testFile = new FileInputStream(testDataFile);
			testData.load(testFile);
			testFile.close();
			File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
			FileInputStream inputFile = new FileInputStream(propFile);
			prop.load(inputFile);
			inputFile.close();		
			
}
	public void addTimestampToEmail() throws IOException {

				Date date =new Date();
				String timestamp = date.toString().replace(" ","").replace(":","");
			    Random random = new Random();
		        //Generate a random integer between 1 and 10
		        int random_number = random.nextInt(100)+1;
			    String NewEmail = "Chan+" + random_number + timestamp + random_number+ "@yopmail.com";
			    System.out.println(NewEmail);
			     
			    Properties prop1 = new Properties();
			    //Writing to properties file
			    prop1.setProperty("newUserEmailAddress", NewEmail);
			    File filePath = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
			    //Saving properties to a file
			    OutputStream output = new FileOutputStream(filePath);
			    prop1.store(output, "Email updated in properties file successfully");
				output.close();
				//Refreshing the config.properties file
				        
			        
			}	
			
	
	public static WebDriver launchTheBrowserAndApplication(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("chrome")){
			
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize(); 
		driver.get(testData.getProperty("app"));
		return driver;
		
	}
	

	public void readCaptcha() throws IOException, Exception { 

	    WebElement imageElement = driver.findElement(By.xpath("//*[@id='captcha-container-user_login']/div/img"));

	    File src = imageElement.getScreenshotAs(OutputType.FILE);
	    String path = "C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\Captcha Images\\captcha.png";
	    FileHandler.copy(src, new File(path));
	    Thread.sleep(5000);

	    // Enhance the CAPTCHA image
	    BufferedImage enhancedImage = enhanceImage(ImageIO.read(new File(path)));

	    // Save the enhanced image
	    String enhancedImagePath = "C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\Captcha Images\\enhanced_captcha.png";
	    ImageIO.write(enhancedImage, "png", new File(enhancedImagePath));

	    Tesseract img = new Tesseract();
	    img.setDatapath("C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\tessdata");
	    img.setLanguage("eng");

	    String str = img.doOCR(new File(enhancedImagePath));
	    System.out.println("Image read successfully");
	    System.out.println(str);
	    driver.findElement(By.xpath("(//*[@id='captcha_user_login'])[1]")).sendKeys(str);
	}

	private BufferedImage enhanceImage(BufferedImage image) {
	    // Apply image enhancement techniques
	    // Replace this with your custom image enhancement logic
	    // Example: resizing the image to double its original size
	    int newWidth = image.getWidth() * 2;
	    int newHeight = image.getHeight() * 2;
	    BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
	    resizedImage.createGraphics().drawImage(image, 0, 0, newWidth, newHeight, null);
	    return resizedImage;
	}

		
	public void loginToApplication() throws InterruptedException {
		TestMethods.linkTextClick(LocatorPages.SignInLink);
		TestMethods.enterInputData_ID(LocatorPages.emailTxtBx, prop.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(LocatorPages.passwordField, testData.getProperty("password"));
		TestMethods.xpathClick(LocatorPages.signInButton);
	    Waits.waitFor3seconds();
	//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	//    
	
	}
	
	public static void testHoverElement(String elementToHever) {
	    // Find the element you want to hover over
	    WebElement ElementToHover = driver.findElement(By.xpath(elementToHever)); 
	    
	    // Create an instance of the Actions class and perform the hover action
	    Actions actions = new Actions(driver);
	    actions.moveToElement(ElementToHover).build().perform();
	
	    // You can add additional actions after the hover if needed, like clicking on a sub-element that appears on hover.
	    // Example: actions.click(subElement).build().perform();
	}
	
	public static String validationOfCategory(String locator) {
		String validationOfCategoryXpath = "(//*[@class='base'][text()='" + locator  + "'])";
		return validationOfCategoryXpath;
	}
	
	public static void sizeXpath(String size) {
		String xpathOfSize = "//*[@class='swatch-option text'][text() = '"+ size+ "']";
		TestMethods.xpathClick(xpathOfSize);
	}
	public static void colorOfProduct(String color) {
		String proColor = "//*[@aria-label='"+color+"']";
		TestMethods.xpathClick(proColor);
		
	}
	
	public static void goToCart() {
		TestMethods.xpathClick(cart);
	}
	public static void verifyProductAddedToCart(String product, String index) {
		String proInCart = product + index;
		System.out.println(proInCart);
		TestMethods.elementIsDisplayed(proInCart);
	}
	public static void proceedToCheckOutFromTop() throws InterruptedException {
		TestMethods.xpathClick(proceedToCheckoutButtonInTopCart);
		Waits.waitFor5seconds();
		TestMethods.elementIsDisplayed(validateShippingAddress);
	}
	
	public void proceedToCheckOut() throws InterruptedException {
		TestMethods.xpathClick(proceedToCheckoutButtonInTopCart);
		Waits.waitFor3seconds();
		TestMethods.elementIsDisplayed(validateShippingAddress);
	}
	public static void enterShippingDetails() throws InterruptedException {
		TestMethods.enterInputData_Xpath(shippingEmail, testData.getProperty("newUserEmailAddress"));
		TestMethods.enterInputData_Name(fisrtNameField, testData.getProperty("newUserFirstName"));
		TestMethods.enterInputData_Name(lastNameField, testData.getProperty("newUserLastName"));
		TestMethods.enterInputData_Name(shippingCompany, testData.getProperty("company"));
		TestMethods.enterInputData_Xpath(shippingAdd1, testData.getProperty("address1"));
		TestMethods.enterInputData_Xpath(shippingAdd2, testData.getProperty("address2"));
		TestMethods.enterInputData_Xpath(shippingAdd3, testData.getProperty("address3"));
		TestMethods.enterInputData_Xpath(shippingCity, testData.getProperty("city"));
		//select country and state from drop down
		TestMethods.xpathClick(shippingCountry);
		TestMethods.selectOptionFromDropDown(shippingCountry, testData.getProperty("country"));
		Waits.waitFor3seconds();
		TestMethods.xpathClick(shippingStateOrProvince);
		TestMethods.selectOptionFromDropDown(shippingStateOrProvince, testData.getProperty("state"));
		TestMethods.enterInputData_Xpath(shippingZipcode, testData.getProperty("PostalCode"));
		TestMethods.enterInputData_Xpath(shippingTelephone, testData.getProperty("PhoneNumber"));
		
		
		
		
	}
	public static void SelectProduct(String product, String Size, String Color) throws InterruptedException {
		String productLocator = "(//img[contains(@alt,'" + product+"')])";
		TestMethods.xpathClick(productLocator);
		Waits.waitFor1seconds();
		Base.sizeXpath(Size);
		Base.colorOfProduct(Color);
		Waits.waitFor2seconds();
		
	}
	public static void addToCart(String locatorOfProductToVerify, String index) throws InterruptedException {
		String productLocator = "(//img[contains(@alt,'" + locatorOfProductToVerify+"')])";
		TestMethods.xpathClick(addToCart);
		Waits.waitFor5seconds();
		TestMethods.elementIsDisplayed(validateAddToCart);
		Base.goToCart();
		Waits.waitFor4seconds();
		Base.verifyProductAddedToCart(productLocator, index);
		//Proceed to checkout
		Base.proceedToCheckOutFromTop();
		Waits.waitFor5seconds();
}

}
