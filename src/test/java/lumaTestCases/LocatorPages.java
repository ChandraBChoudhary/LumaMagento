package lumaTestCases;

import org.openqa.selenium.By;

import com.LumaMagento.Base.Waits;

public class LocatorPages{
		 
	 //Login Page Locators 
	 protected static String SignInLink = "Sign In"; //Landing page header link 
	 protected static String emailTxtBx = "email" ;
	 protected static String passwordField = "login[password]";
	 protected static String signInButton = "//*[text()='Sign In']";
	 protected static String emailValidationError = "//*[@id='email-error']";
	 protected static String pwdValidationError = "//*[@id=\"pass-error\"]";
	 protected static String captchaError = "//*[@class ='message-error error message']"	 ;
	 
	 //Forgot Password 
	 protected static String forgotPwd = "(//span[text() = 'Forgot Your Password?'])[1]";
	 
	 
	 //Registration Page Locators 
	 protected static String createAccLink = "Create an Account"; //Landing Page Header Link
	 protected static String welcomeText = "(//*[text()='Default welcome msg!'])[1]";
	 protected static String createAccTitle = "//*[span = 'Create New Customer Account']";
	 protected static String fisrtNameField = "firstname";
	 protected static String lastNameField = "lastname";
	 protected static String regPwdField = "password";
	 protected static String confirmPwdfield = "password-confirmation";
	 protected static String createAccBtn = "//*[@class= 'action submit primary']";
	 protected static String registrationSucessValidation = "//*[@class='message-success success message']";
	 protected static String requiredFirstName = "//*[@id = 'firstname-error']";
	 protected static String requiredLastName = "//*[@id = 'lastname-error']";
	 protected static String requiredEmail = "//*[@id = 'email_address-error']";
	 protected static String requiredPassword = "//*[@id = 'password-error']";
	 protected static String requiredConfirmPassword = "//*[@id = 'password-confirmation-error']";
	 protected static String newletterSignUpCheckbox = "is_subscribed";
	 protected static String validationNewsLetterSignUp = "div[class='box box-newsletter'] p";
	 protected static String strongPassword = "(//span[@id='password-strength-meter-label'][text()='Very Strong'])";
	 protected static String weakPassword = "(//span[@id='password-strength-meter-label'][text()='Weak'])";
	 protected static String missingPassCriteria = "//* [contains(text(), 'Minimum of different classes')]";
	 protected static String passwordDoNotMatch = "//* [contains(text(), 'Please enter the same value again.')]";
	 
	 //Application Landing Page 
	 protected static String userName = "//*[text()='Welcome, Chandra B!'][1]";
	 protected static String profiledrpdwn = "//*[@class = 'action switch']";
	 protected static String signOutBtn = "Sign Out";
	 
	 //Searching Product
	 protected static String searchTxtBx = "//*[@id = 'search']";
	 protected static String searchIcon = "//*[@title='Search']";
	 protected static String searchResultValidation = "(//span[@class='base'][contains(text(), 'Search results')])";
	  protected static String invalidSearchResultValidation = "(//*[contains(text(), 'no results')])";
	 
	  
	  //Women Category Navigation
	  protected static String womenCategory = "//*[@id='ui-id-4']";
	  protected static String womenCategoryValidation = "(//*[@class='base'][text()='Women'])";
	  protected static String womenCategoryTops = "(//a[@id='ui-id-9']/span[text()='Tops'])";
	  protected static String womenJacketSubCat	= "(//a[@class='ui-corner-all']/span[text()='Jackets'])[1]";
	  protected static String womenHoodiesSubCat = "(//a[@class='ui-corner-all']/span[text()='Hoodies & Sweatshirts'])[1]";
	  protected static String womenTeesSubCat = "(//a[@class='ui-corner-all']/span[text()='Tees'])[1]";
	  protected static String womenBrasSubCat = "(//a[@class='ui-corner-all']/span[text()='Bras & Tanks'])[1]";
	  protected static String womenCategoryBottoms = "(//a[@class='ui-corner-all']/span[text()='Bottoms'])";
	  protected static String womenPantsSubCategory = "(//a[@class='ui-corner-all']/span[text()='Pants'])[1]";
	  protected static String womenShortsSubCat = "(//a[@class='ui-corner-all']/span[text()='Shorts'])[1]";
	  
	  //Men Category 
	  protected static String menCategory = "//*[@id='ui-id-5']";
	  protected static String menCategoryValidation = "(//*[@class='base'][text()='Men'])";
	  protected static String menCategoryTops = "(//a[@id='ui-id-17']/span[text()='Tops'])";
	  protected static String menJacketSubCat	= "(//a[@class='ui-corner-all']/span[text()='Jackets'])[2]";
	  protected static String menHoodiesSubCat = "(//a[@class='ui-corner-all']/span[text()='Hoodies & Sweatshirts'])[2]";
	  protected static String menTeesSubCat = "(//a[@class='ui-corner-all']/span[text()='Tees'])[2]";
	  protected static String menTanksSubCat = "(//a[@class='ui-corner-all']/span[text()='Tanks'])";
	  protected static String menCategoryBottoms = "(//a[@id='ui-id-18']/span[text()='Bottoms'])";
	  protected static String menPantsSubCategory = "(//a[@class='ui-corner-all']/span[text()='Pants'])[2]";
	  protected static String menShortsSubCat = "(//a[@class='ui-corner-all']/span[text()='Shorts'])[2]";
	  
	  //Gear Category
	  protected static String gearCategory = "//*[@id='ui-id-6']";
	  protected static String gearCategoryValidation = "(//*[@class='base'][text()='Gear'])";
	  protected static String gearCategoryBags = "(//a[@class='ui-corner-all']/span[text()='Bags'])";
	  protected static String gearCategoryFitnessEquipment = "(//a[@class='ui-corner-all']/span[text()='Fitness Equipment'])";
	  protected static String gearCategoryWatches = "(//a[@class='ui-corner-all']/span[text()='Watches'])";
	  
	  //Training
	  protected static String trainingCategory = "//*[@id='ui-id-7']";
	  protected static String trainingCategoryValidation = "(//*[@class='base'][text()='Training'])";
	  protected static String learningsTrainingVideo = "(//a[@class='ui-corner-all']/span[text()='Video Download'])";
	  
	  //Purchase women jackets 
	  protected static String olivia14thZipLightJacket = "(//img[@alt='Olivia 1/4 Zip Light Jacket'])";
	  
	  //Add to Cart
	  protected static String addToCart = "//button[@id='product-addtocart-button']";
	  protected static String validateAddToCart = "(//*[contains(text(), 'You added')])";
	  protected static String cart = "//a[@class='action showcart']";
	  
	  //Proceed to checkout
	  protected static String proceedToCheckoutButtonInTopCart = "//button[@title = 'Proceed to Checkout'][1]";
	  protected static String proceedToCheckoutButtonInCart = "//button[@title = 'Proceed to Checkout'][1]";
	  protected static String validateShippingAddress = "//*[@class='step-title'][text()='Shipping Address']";
	  
	  //Shipping Address and screen
	  
	  protected static String shippingEmail = "(//*[@class='input-text'][@id='customer-email'])[1]";
	  protected static String shippingCompany = "company";
	  protected static String shippingAdd1 = "//*[@name='street[0]']";
	  protected static String shippingAdd2 = "//*[@name='street[1]']";
	  protected static String shippingAdd3 = "//*[@name='street[2]']";
	  protected static String shippingCity = "//*[@name='city']";
	  protected static String shippingStateOrProvince = "//*[@name='region_id']";
	  protected static String shippingCountry = "//*[@name='country_id']" ;
	  protected static String shippingZipcode = "//*[@name='postcode']";
	  protected static String shippingTelephone = "//*[@name='telephone']";
	  protected static String shippingTableRate = "//*[text() ='Table Rate']";
	  protected static String shippingFixedRate = "//*[text() ='Fixed']";
	  protected static String shippingNextButton = "//*[@class='button action continue primary']";
	  
	  //Payment methods
	  protected static String paymentMethod = "//*[@class='step-title'][text() = 'Payment Method']";
	  protected static String placeOrderButton = "//*[@title = 'Place Order']";
	  protected static String placedOrderSuccessMessage = "//*[text() = 'Thank you for your purchase!']";
	}
	
	
	



