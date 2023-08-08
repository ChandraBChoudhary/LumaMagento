package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.TestMethods;
import com.LumaMagento.Base.Waits;

public class Purchases extends Base{

	public Purchases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Base base = new Base();
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		base.loginToApplication();
		Waits.waitFor4seconds();
	}
	
	@Test
	public void purchaseWomensJacket() throws Throwable{
		
		String catValidationLocator = base.validationOfCategory("Jackets");
		TestMethods.navigateToParticularCategoryInWomen(womenCategory, womenCategoryTops, womenJacketSubCat);
		TestMethods.elementIsDisplayed(catValidationLocator);
		
		//select the product
	}


}
