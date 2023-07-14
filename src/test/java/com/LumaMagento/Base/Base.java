package com.LumaMagento.Base;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.openqa.selenium.io.FileHandler;
import net.sourceforge.tess4j.*;

public class Base {
	WebDriver driver ;
	public Properties prop = new Properties();
	public Properties testData;
	

public Base() {
		
		
	
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\LumaMagento\\config\\config.properties");
		try {
			FileInputStream inputFile = new FileInputStream(propFile);
			prop.load(inputFile);
			inputFile.close();
		} 
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		testData = new Properties();
		File testDataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\LumaMagento\\TestData\\testData.properties");
		
		try {
			FileInputStream testFile = new FileInputStream(testDataFile);
			testData.load(testFile);
			testFile.close();
		}
		catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// Generating email address
//		Random random = new Random();
//		int random_number = random.nextInt(100);
//	    String newEmail = "chand199809+" + random_number + "@yopmail.com";
//	    System.out.println(newEmail);
//
//	    try {
//	        Properties properties = new Properties();
//	        properties.setProperty("newUserEmailAddress", newEmail);
//
//	        String filePath = "C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\src\\main\\java\\com\\LumaMagento\\config\\config.properties";
//	        OutputStream output = new FileOutputStream(filePath);
//
//	        // Save the properties to the output stream
//	        properties.store(output, "Email updated in properties file successfully");
//	        output.close();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        System.out.println("Failed to update email");
//	    }

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
	
	public void addTimestampToEmail() throws IOException {
	    //Date date = new Date();
	    //String timestamp = date.toString();
	//replace(" ", "_").replace(":", "_");
	    Random random = new Random();
        
        // Generate a random integer between 1 and 10
        int random_number = random.nextInt(100);
	    String newEmail = "chand199809+" + random_number + "@yopmail.com";
	    System.out.println(newEmail);

	    
	        Properties properties = new Properties();
	        properties.setProperty("newUserEmailAddress", newEmail);

	        String filePath = "C:\\Users\\chandrabl\\Desktop\\Personal\\MCA Project Work\\LumaMagento\\src\\main\\java\\com\\LumaMagento\\config\\config.properties";
	        OutputStream output = new FileOutputStream(filePath);

	        // Save the properties to the output stream
	        properties.store(output, "Email updated in properties file successfully");
	        //output.close();
	  

	}
	
	
}
