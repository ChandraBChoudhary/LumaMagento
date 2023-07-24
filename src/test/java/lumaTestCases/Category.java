package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;

public class Category extends Base{
	
	Base base = new Base();
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	@BeforeMethod
	public void launchTheURL() throws IOException, InterruptedException {
		driver = base.launchTheBrowserAndApplication(testData.getProperty("browser"));
		base.loginToApplication();
	}
	
		@Test
		public void Category001_NavigateToWomenCategory() {
			driver.findElement(By.xpath(womenCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(womenCategoryValidation)).isDisplayed());
		}
	
	    @Test
	    public void Category002_verifyAllWomenCategoryAvailability() {
	    	base.testHoverElement(womenCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenCategoryTops)).isDisplayed());
	    	base.testHoverElement(womenCategoryTops);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenJacketSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenHoodiesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenTeesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenBrasSubCat)).isDisplayed());
	    }

	
}