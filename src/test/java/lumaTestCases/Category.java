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
			Assert.assertTrue(driver.findElement(By.xpath(womenCategoryValidation)).isDisplayed(), "Women Category not found");
			driver.findElement(By.xpath(menCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(menCategoryValidation)).isDisplayed(), "Men Category not found");
			driver.findElement(By.xpath(gearCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(gearCategoryValidation)).isDisplayed(), "Gear Category not found");
			driver.findElement(By.xpath(trainingCategory)).click();;
			Assert.assertTrue(driver.findElement(By.xpath(trainingCategoryValidation)).isDisplayed(), "Training Category not found");
			
		}
	
	    @Test
	    public void Category002_verifyWomenTopsCategoryAvailability() {
	    	base.testHoverElement(womenCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenCategoryTops)).isDisplayed(), "Women Category not found");
	    	base.testHoverElement(womenCategoryTops);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenJacketSubCat)).isDisplayed(), "Women Jacket Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(womenHoodiesSubCat)).isDisplayed(), "Women Hoodie Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(womenTeesSubCat)).isDisplayed(), "Women Tees Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(womenBrasSubCat)).isDisplayed(), "Women Bra Category not found");
	    }
	    @Test
	    public void Category003_verifyWomenBottomsCategoryAvailability() {
	    	base.testHoverElement(womenCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenCategoryBottoms)).isDisplayed(), "Women Bottoms Category not found");
	    	base.testHoverElement(womenCategoryBottoms);
	    	Assert.assertTrue(driver.findElement(By.xpath(womenPantsSubCategory)).isDisplayed(), "Women Pants Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(womenShortsSubCat)).isDisplayed(), "Women Shorts Category not found");
	    	
	    }
	    
	    @Test
	    public void Category004_verifyMenTopsCategoryAvailability() {
	    	base.testHoverElement(menCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(menCategoryTops)).isDisplayed(), "Men Category not found");
	    	base.testHoverElement(menCategoryTops);
	    	Assert.assertTrue(driver.findElement(By.xpath(menJacketSubCat)).isDisplayed(), "Jacket not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(menHoodiesSubCat)).isDisplayed(), "Hoodie not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(menTeesSubCat)).isDisplayed(), "Tees not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(menTanksSubCat)).isDisplayed(), "Tanks not found");
	    }
	    @Test
	    public void Category005_verifyMenBottomsCategoryAvailability() {
	    	base.testHoverElement(menCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(menCategoryBottoms)).isDisplayed(), "Men Category not found");
	    	base.testHoverElement(menCategoryBottoms);
	    	Assert.assertTrue(driver.findElement(By.xpath(menPantsSubCategory)).isDisplayed(), "Men Pants Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(menShortsSubCat)).isDisplayed(), "Men Shorts Category not found");
	    	
	    }
	    @Test
	    public void Category006_verifyGearCategoryAvailability() {
	    	base.testHoverElement(gearCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(gearCategoryBags)).isDisplayed(), "Gear Category not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(gearCategoryFitnessEquipment)).isDisplayed(), "Gear's Fitness Equipment not found");
	    	Assert.assertTrue(driver.findElement(By.xpath(gearCategoryWatches)).isDisplayed(), "Gear Watches not found");
	    	
	    }
	    @Test
	    public void Category007_verifyTrainingAvailability() {
	    	base.testHoverElement(trainingCategory);
	    	Assert.assertTrue(driver.findElement(By.xpath(learningsTrainingVideo)).isDisplayed(), "Training Download Video not found");

	    	
	    }
	
}