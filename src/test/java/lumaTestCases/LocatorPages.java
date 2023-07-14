package lumaTestCases;

import com.LumaMagento.Base.Base;

public class LocatorPages extends Base{
	
	
	
	 
	 //Login Page Loctaors 
	 static String SignInLink = "Sign In"; //Landing page header link 
	 static String emailTxtBx = "email" ;
	 static String passwordField = "login[password]";
	 static String signInButton = "//*[text()='Sign In']";
	 static String emailValidationError = "//*[@id='email-error']";
	 static String pwdValidationError = "//*[@id=\"pass-error\"]";
	 static String captchaError = "//*[@class ='message-error error message']"	 ;
	 
	 
	 
	 
	 //Registration Page Locators 
	 static String createAccLink = "Create an Account"; //Landing Page Header Link
	 static String welcomeText = "(//*[text()='Default welcome msg!'])[1]";
	 static String createAccTitle = "//*[span = 'Create New Customer Account']";
	 static String fisrtNameField = "firstname";
	 static String lastNameField = "lastname";
	 static String regPwdField = "password";
	 static String confirmPwdfield = "password-confirmation";
	 static String createAccBtn = "//*[@class= 'action submit primary']";
	 static String registrationSucessValidation = "//*[@class='message-success success message']";
	 static String requiredFirstName = "firstname-error";
	 static String requiredLastName = "lastname-error";
	 static String requiredEmail = "email_address-error";
	 static String requiredPassword = "password-error";
	 static String requiredConfirmPassword = "password-confirmation-error";
	 static String newletterSignUpCheckbox = "is_subscribed";
	 static String validationNewsLetterSignUp = "div[class='box box-newsletter'] p";
	 static String strongPassword = "(//span[@id='password-strength-meter-label'][text()='Very Strong'])";
	 static String weakPassword = "(//span[@id='password-strength-meter-label'][text()='Weak'])";
	 static String missingPassCriteria = "//* [contains(text(), 'Minimum of different classes')]";
	 static String passwordDoNotMatch = "//* [contains(text(), 'Please enter the same value again.')]";
	 
	 //Application Landing Page 
	 static String userName = "//*[text()='Welcome, Chandra B!'][1]";
	 static String profiledrpdwn = "//*[@class = 'action switch']";
	 static String signOutBtn = "Sign Out";
	 
		
	}
	
	
	



