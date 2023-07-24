package lumaTestCases;

public class LocatorPages{
		 
	 //Login Page Loctaors 
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
	 protected static String requiredFirstName = "firstname-error";
	 protected static String requiredLastName = "lastname-error";
	 protected static String requiredEmail = "email_address-error";
	 protected static String requiredPassword = "password-error";
	 protected static String requiredConfirmPassword = "password-confirmation-error";
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
	  protected static String womenCategoryValidation = "//*[@id='page-title-heading']";
	  protected static String womenCategoryTops = "(//a[@id='ui-id-9']/span[text()='Tops'])";
	  protected static String womenJacketSubCat	= "(//a[@class='ui-corner-all']/span[text()='Jackets'])[1]";
	  protected static String womenHoodiesSubCat = "(//a[@class='ui-corner-all']/span[text()='Hoodies & Sweatshirts'])[1]";
	  protected static String womenTeesSubCat = "(//a[@class='ui-corner-all']/span[text()='Tees'])[1]";
	  protected static String womenBrasSubCat = "(//a[@class='ui-corner-all']/span[text()='Bras & Tanks'])[1]";
	}
	
	
	



