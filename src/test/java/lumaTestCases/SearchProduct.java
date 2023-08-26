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

public class SearchProduct extends Base{
	
	Base base = new Base();
	public WebDriver driver;
	
	public SearchProduct() throws IOException {
		//super();
	}

	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		//base.loginToApplication();
	}
	
	@Test
	public void Search001_SearchByProduct() throws IOException, InterruptedException {
        Waits.waitFor2seconds();
        TestMethods.enterInputData_Xpath(searchTxtBx, testData.getProperty("searchProduct"));
		TestMethods.xpathClick(searchIcon);
		TestMethods.elementIsDisplayed(searchResultValidation);
	
	}
	
	@Test
	public void Search002_InvalidSearchProduct() throws IOException, InterruptedException {
		 Waits.waitFor2seconds();
         TestMethods.enterInputData_Xpath(searchTxtBx, testData.getProperty("searchInvalidProduct"));
		 TestMethods.xpathClick(searchIcon);
		 TestMethods.elementIsDisplayed(invalidSearchResultValidation);
		
	}
	
	
}