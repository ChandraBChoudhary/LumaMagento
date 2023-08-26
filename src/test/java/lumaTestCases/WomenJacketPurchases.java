package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.TestMethods;
import com.LumaMagento.Base.Waits;
import com.LumaMagento.Base.purchasesMethod;

public class WomenJacketPurchases extends Base{

	public WomenJacketPurchases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Base base = new Base();
	public WebDriver driver;
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		//base.loginToApplication();
		Waits.waitFor4seconds();
	}
	
	
	@Test(priority = 1)
	public void purchaseWomensOliviaBlueJacket() throws Throwable{
		
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, testData.getProperty("olivia"),
				testData.getProperty("size"),testData.getProperty("blue"));
		
	}
	@Test(priority = 2)
	public void purchaseWomensOliviaBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("olivia"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 3)
	public void purchaseWomensJunoBlueJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("juno"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 4)
	public void purchaseWomensJunoGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("juno"), testData.getProperty("size"), testData.getProperty("green"));
		
	}
	
	@Test(priority = 5)
	public void purchaseWomensDanceOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("danceJacket"), testData.getProperty("size"), testData.getProperty("orange"));
		
	}
	@Test(priority = 6)
	public void purchaseWomensDanceBlueJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("danceJacket"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 7)
	public void purchaseWomensNadiaShellBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("nadiaElements"), testData.getProperty("size"), testData.getProperty("black"));
		
	}
	@Test(priority = 8)
	public void purchaseWomensNadiaShellOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("nadiaElements"), testData.getProperty("size"), testData.getProperty("orange"));	
	}
	
	@Test(priority = 9)
	public void purchaseWomensJadeBlueJacket() throws Throwable{
		
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, testData.getProperty("jade"),
				testData.getProperty("size"),testData.getProperty("blue"));
		
	}
	@Test(priority = 10)
	public void purchaseWomensJadeGrayJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("jade"), testData.getProperty("size"), testData.getProperty("gray"));
		
	}
	@Test(priority = 11)
	public void purchaseWomensAdrienneOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("adrienne"), testData.getProperty("size"), testData.getProperty("orange"));
		
	}
	@Test(priority = 12)
	public void purchaseWomensAdrienneGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("adrienne"), testData.getProperty("size"), testData.getProperty("purp"));
		
	}
	
	@Test(priority = 13)
	public void purchaseWomensInezOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("inez"), testData.getProperty("size"), testData.getProperty("orange"));
		
	}
	@Test(priority = 14)
	public void purchaseWomensInezRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("inez"), testData.getProperty("size"), testData.getProperty("red"));
		
	}
	@Test(priority = 15)
	public void purchaseWomensIngridWhiteJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("ingrid"), testData.getProperty("size"), testData.getProperty("white"));
		
	}
	@Test(priority = 16)
	public void purchaseWomensIngridOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("ingrid"), testData.getProperty("size"), testData.getProperty("orange"));	
	}
	@Test(priority = 17)
	public void purchaseWomensRionaBrownJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("riona"), testData.getProperty("size"), testData.getProperty("brown"));
		
	}
	@Test(priority = 18)
	public void purchaseWomensRionaRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("riona"), testData.getProperty("size"), testData.getProperty("red"));	
	}
	@Test(priority = 19)
	public void purchaseWomensAugustaBlueJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("augusta"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 20)
	public void purchaseWomensAugustaRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("augusta"), testData.getProperty("size"), testData.getProperty("red"));	
	}
	@Test(priority = 21)
	public void purchaseWomensJosieBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("josie"), testData.getProperty("size"), testData.getProperty("black"));
		
	}
	@Test(priority = 22)
	public void purchaseWomensJosieGrayJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("josie"), testData.getProperty("size"), testData.getProperty("gray"));	
	}
	@Test(priority = 23)
	public void purchaseWomensStellarYellowJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("stellar"), testData.getProperty("size"), testData.getProperty("yellow"));
		
	}
	@Test(priority = 24)
	public void purchaseWomensJosieRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",womenCategory, womenCategoryTops, womenJacketSubCat, 
				testData.getProperty("stellar"), testData.getProperty("size"), testData.getProperty("red"));	
	}
}
