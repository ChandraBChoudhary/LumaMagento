package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.Waits;
import com.LumaMagento.Base.purchasesMethod;

public class menJacketPurchases extends Base{

	public menJacketPurchases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = Base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		//base.loginToApplication();
		Waits.waitFor4seconds();
	}
	
	
	@Test(priority = 1)
	public void purchaseMenProteusBlueJacket() throws Throwable{
		
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, testData.getProperty("proteus"),
				testData.getProperty("size"),testData.getProperty("blue"));
		
	}
	@Test(priority = 2)
	public void purchaseMenProteusBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("proteus"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 3)
	public void purchaseMensMontanaBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("montana"), testData.getProperty("size"), testData.getProperty("black"));
		
	}
	@Test(priority = 4)
	public void purchaseMensMontanaGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("montana"), testData.getProperty("size"), testData.getProperty("green"));
		
	}
	
	@Test(priority = 5)
	public void purchaseMensJupiterPurpleJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("jupiter"), testData.getProperty("size"), testData.getProperty("purp"));
		
	}
	@Test(priority = 6)
	public void purchaseMensJupiterBlueJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("jupiter"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 7)
	public void purchaseMensTyphonBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("typhon"), testData.getProperty("size"), testData.getProperty("black"));
		
	}
	@Test(priority = 8)
	public void purchaseMensTyphonGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("typhon"), testData.getProperty("size"), testData.getProperty("green"));	
	}
	
	@Test(priority = 9)
	public void purchaseMensMarsOrangeJacket() throws Throwable{
		
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, testData.getProperty("mars"),
				testData.getProperty("size"),testData.getProperty("orange"));
		
	}
	@Test(priority = 10)
	public void purchaseMensMarsRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("mars"), testData.getProperty("size"), testData.getProperty("red"));
		
	}
	@Test(priority = 11)
	public void purchaseMensTaurusYellowJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("taurus"), testData.getProperty("size"), testData.getProperty("yellow"));
		
	}
	@Test(priority = 12)
	public void purchaseMensTaurusWhiteJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("taurus"), testData.getProperty("size"), testData.getProperty("white"));
		
	}
	
	@Test(priority = 13)
	public void purchaseMensLandoGrayJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("lando"), testData.getProperty("size"), testData.getProperty("gray"));
		
	}
	@Test(priority = 14)
	public void purchaseMensLandoGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("lando"), testData.getProperty("size"), testData.getProperty("green"));
		
	}
	@Test(priority = 15)
	public void purchaseMensOrionBlackJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("orion"), testData.getProperty("size"), testData.getProperty("black"));
		
	}
	@Test(priority = 16)
	public void purchaseMensOrionRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("orion"), testData.getProperty("size"), testData.getProperty("red"));	
	}
	@Test(priority = 17)
	public void purchaseMensHyperionOrangeJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("hyperion"), testData.getProperty("size"), testData.getProperty("orange"));
		
	}
	@Test(priority = 18)
	public void purchaseMensKenobiPurpleJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("kenobi"), testData.getProperty("size"), testData.getProperty("purp"));	
	}
	@Test(priority = 19)
	public void purchaseMensKenobiBlueJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("kenobi"), testData.getProperty("size"), testData.getProperty("blue"));
		
	}
	@Test(priority = 20)
	public void ppurchaseMensHyperionGreenJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("hyperion"), testData.getProperty("size"), testData.getProperty("green"));	
	}
	@Test(priority = 21)
	public void purchaseMensBeaumontRedJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("beaumont"), testData.getProperty("size"), testData.getProperty("red"));
		
	}
	@Test(priority = 22)
	public void purchaseMensBeaumontYellowJacket() throws Throwable{
		purchasesMethod.purchase("Jackets",menCategory, menCategoryTops, menJacketSubCat, 
				testData.getProperty("beaumont"), testData.getProperty("size"), testData.getProperty("yellow"));	
	}
}
