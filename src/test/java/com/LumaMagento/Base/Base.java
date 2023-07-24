package com.LumaMagento.Base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.io.OutputStream;
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
	public WebDriver driver ;
	public Properties prop = new Properties();
	public Properties testData = new Properties();
	File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
	File testDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\LumaMagento\\TestData\\testData.properties");


public Base() {
		
	

//		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
		try {
			FileInputStream inputFile = new FileInputStream(propFile);
			prop.load(inputFile);
			inputFile.close();
		} 
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//testData = new Properties();
//		File testDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\LumaMagento\\TestData\\testData.properties");
		
		try {
			FileInputStream testFile = new FileInputStream(testDataFile);
			testData.load(testFile);
			testFile.close();
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
		
			public void addTimestampToEmail() throws IOException {

				Date date =new Date();
				String timestamp = date.toString().replace(" ","").replace(":","");
			    Random random = new Random();
		         //Generate a random integer between 1 and 10
		        int random_number = random.nextInt(100)+1;
			    String NewEmail = "Chan+" + random_number + timestamp + random_number+ "@yopmail.com";
			    System.out.println(NewEmail);
			     
			    
			    //Writing to properties file
			        prop.setProperty("newUserEmailAddress", NewEmail);
			        String filePath = "C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\src\\main\\java\\com\\LumaMagento\\config\\config.properties";
			        //Saving properties to a file
			        OutputStream output = new FileOutputStream(filePath);
				        prop.store(output, "Email updated in properties file successfully");
				        output.close();
				       //Refreshing the config.properties file
				        try (FileInputStream input = new FileInputStream(filePath)) {
				            prop.load(input);
				            output.close();
				       // Now you have the updated data in the 'properties' object
				     
				        } catch (IOException e) {
				            e.printStackTrace();
				            System.out.println("Failed to read properties.");
				        }	
			        
			}	  

	
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
	driver.findElement(By.linkText(LocatorPages.SignInLink)).click();
    driver.findElement(By.id(LocatorPages.emailTxtBx)).sendKeys(prop.getProperty("newUserEmailAddress"));
    driver.findElement(By.name(LocatorPages.passwordField)).sendKeys(testData.getProperty("password"));
    driver.findElement(By.xpath(LocatorPages.signInButton)).click();
    Waits.waitFor2seconds();
}

public void testHoverElement(String elementToHever) {
    // Find the element you want to hover over
    WebElement ElementToHover = driver.findElement(By.xpath(elementToHever)); 
    
    // Create an instance of the Actions class and perform the hover action
    Actions actions = new Actions(driver);
    actions.moveToElement(ElementToHover).build().perform();

    // You can add additional actions after the hover if needed, like clicking on a sub-element that appears on hover.
    // Example: actions.click(subElement).build().perform();
}

}
