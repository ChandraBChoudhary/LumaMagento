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
import com.LumaMagento.Base.Waits;

public class Category extends Base{
	
	public Category() throws IOException {
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
		public void Category001_NavigateToWomenCategory() {
			driver.findElement(By.xpath(womenCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(womenCategoryValidation)).isDisplayed());
			driver.findElement(By.xpath(menCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(menCategoryValidation)).isDisplayed());
			
		}
	
	    @Test
	    public void Category002_verifyWomenTopsCategoryAvailability() {
	    	base.testHoverElement(womenCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenCategoryTops)).isDisplayed());
	    	base.testHoverElement(womenCategoryTops);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenJacketSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenHoodiesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenTeesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenBrasSubCat)).isDisplayed());
	    }
	    @Test
	    public void Category003_verifyWomenBottomsCategoryAvailability() {
	    	base.testHoverElement(womenCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenCategoryBottoms)).isDisplayed());
	    	base.testHoverElement(womenCategoryBottoms);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenPantsSubCategory)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(womenShortsSubCat)).isDisplayed());
	    	
	    }
	    
	    @Test
	    public void Category002_verifyMenTopsCategoryAvailability() {
	    	base.testHoverElement(menCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(menCategoryTops)).isDisplayed());
	    	base.testHoverElement(menCategoryTops);
	    	Assert.assertTrue(driver.findElement(By.xpath(menJacketSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(menHoodiesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(menTeesSubCat)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(menTanksSubCat)).isDisplayed());
	    }
	    @Test
	    public void Category004_verifyMenBottomsCategoryAvailability() {
	    	base.testHoverElement(menCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(menCategoryBottoms)).isDisplayed());
	    	base.testHoverElement(menCategoryBottoms);
	    	Assert.assertTrue(driver.findElement(By.xpath(menPantsSubCategory)).isDisplayed());
	    	Assert.assertTrue(driver.findElement(By.xpath(menShortsSubCat)).isDisplayed());
	    	
	    }
	
}