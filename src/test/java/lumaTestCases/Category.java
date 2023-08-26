package lumaTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.LumaMagento.Base.Base;
import com.LumaMagento.Base.TestMethods;
import com.LumaMagento.Base.Waits;

public class Category extends Base{
	
	public Category() throws IOException {
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
	
		@Test
		public void Category001_NavigateToWomenCategory() {
			TestMethods.xpathClick(womenCategory);
			TestMethods.elementIsDisplayed(womenCategoryValidation);
			TestMethods.xpathClick(menCategory);
			TestMethods.elementIsDisplayed(menCategoryValidation);
			TestMethods.xpathClick(gearCategory);
			TestMethods.elementIsDisplayed(gearCategoryValidation);
			TestMethods.xpathClick(trainingCategory);
			TestMethods.elementIsDisplayed(trainingCategoryValidation);
			
		}
	
	    @Test
	    public void Category002_verifyWomenTopsCategoryAvailability() {
	    	Base.testHoverElement(womenCategory);
	    	TestMethods.elementIsDisplayed(womenCategoryTops);
	    	Base.testHoverElement(womenCategoryTops);
	    	TestMethods.elementIsDisplayed(womenJacketSubCat);
	    	TestMethods.elementIsDisplayed(womenHoodiesSubCat);
	    	TestMethods.elementIsDisplayed(womenTeesSubCat);
	    	TestMethods.elementIsDisplayed(womenBrasSubCat);
	    }
	    @Test
	    public void Category003_verifyWomenBottomsCategoryAvailability() {
	    	Base.testHoverElement(womenCategory);
	    	TestMethods.elementIsDisplayed(womenCategoryBottoms);
	    	Base.testHoverElement(womenCategoryBottoms);
	    	TestMethods.elementIsDisplayed(womenPantsSubCategory);
	    	TestMethods.elementIsDisplayed(womenShortsSubCat);
	    	
	    }
	    
	    @Test
	    public void Category004_verifyMenTopsCategoryAvailability() {
	    	Base.testHoverElement(menCategory);
	    	TestMethods.elementIsDisplayed(menCategoryTops);
	    	Base.testHoverElement(menCategoryTops);
	    	TestMethods.elementIsDisplayed(menJacketSubCat);
	    	TestMethods.elementIsDisplayed(menHoodiesSubCat);
	    	TestMethods.elementIsDisplayed(menTeesSubCat);
	    	TestMethods.elementIsDisplayed(menTanksSubCat);
	    }
	    @Test
	    public void Category005_verifyMenBottomsCategoryAvailability() {
	    	Base.testHoverElement(menCategory);
	    	TestMethods.elementIsDisplayed(menCategoryBottoms);
	    	Base.testHoverElement(menCategoryBottoms);
	    	TestMethods.elementIsDisplayed(menPantsSubCategory);
	    	TestMethods.elementIsDisplayed(menShortsSubCat);	
	    }
	    @Test
	    public void Category006_verifyGearCategoryAvailability() {
	    	Base.testHoverElement(gearCategory);
	    	TestMethods.elementIsDisplayed(gearCategoryBags);
	    	TestMethods.elementIsDisplayed(gearCategoryFitnessEquipment);
	    	TestMethods.elementIsDisplayed(gearCategoryWatches);
	    }
	    @Test
	    public void Category007_verifyTrainingAvailability() {
	    	Base.testHoverElement(trainingCategory);
	    	TestMethods.elementIsDisplayed(learningsTrainingVideo);	    	
	    }
	
}