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

import lumaTestCases.LocatorPages;
import net.sourceforge.tess4j.*;

public class Base extends LocatorPages{
	public static WebDriver driver ;
	public static Properties prop = new Properties();
	public Properties testData = new Properties();
	


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

//	public void readConfigFile() throws IOException {
//		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
//		FileInputStream inputFile = new FileInputStream(propFile);
//		prop.load(inputFile);
//		//inputFile.close();
//	}
	
		
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
			
//			public void writeToPropertiesFile(String newEmail) throws IOException {
//				Properties prop1 = new Properties();
//			    //Writing to properties file
//			    prop1.setProperty("newUserEmailAddress", newEmail);
//			        
//			        //Saving properties to a file
//			        OutputStream output = new FileOutputStream(filePath);
//			        prop1.store(output, "Email updated in properties file successfully");
//				        output.close();
//			}
//			
//			public void clearDataFromPropertiesFile() {
//				prop.remove("newUserEmailAddress");
//				try (FileInputStream input = new FileInputStream(filePath)) {
//		            prop.load(input);
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//
//		        // Remove the data you want from the properties object
//		        prop.remove("newUserEmailAddress");
//
//		        try (OutputStream output = new FileOutputStream(filePath)) {
//		            prop.store(output, null);
//		            System.out.println("Data cleared from config file");
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//			}

	
	public WebDriver launchTheBrowserAndApplication(String browserName) {
		
		
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
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    TestMethods.elementIsDisplayed(LocatorPages.userName);
    TestMethods.xpathClick(LocatorPages.profiledrpdwn);
    TestMethods.linkTextClick(LocatorPages.signOutBtn);

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

public String validationOfCategory(String locator) {
	String validationOfCategoryXpath = "(//*[@class='base'][text()='" + locator  + "'])";
	return validationOfCategoryXpath;
}

}
