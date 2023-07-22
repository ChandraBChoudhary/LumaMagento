package lumaTestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.Waits;

public class SearchProduct extends Base{
	
	Base base = new Base();
	
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

	}
	
	@Test
	public void Search001_SearchByProduct() throws IOException, InterruptedException {
		//base.addTimestampToEmail();
		base.loginToApplication();
        Waits.waitFor2seconds();
		driver.findElement(By.xpath(LocatorPages.searchTxtBx)).sendKeys(testData.getProperty("searchProduct"));
		driver.findElement(By.xpath(LocatorPages.searchIcon)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.searchResultValidation)).isDisplayed());
		
	}
	
	@Test
	public void Search002_InvalidSearchProduct() throws IOException, InterruptedException {
		//base.addTimestampToEmail();
		base.loginToApplication();
        Waits.waitFor2seconds();
		driver.findElement(By.xpath(LocatorPages.searchTxtBx)).sendKeys(testData.getProperty("searchInvalidProduct"));
		driver.findElement(By.xpath(LocatorPages.searchIcon)).click();
		Assert.assertTrue(driver.findElement(By.xpath(LocatorPages.invalidSearchResultValidation)).isDisplayed());
		
	}
	
	
}
