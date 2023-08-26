package com.LumaMagento.Base;

import java.io.IOException;

public class purchasesMethod extends Base{
static Base base;
public purchasesMethod() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

public static void purchase(String category, String entity, String mainCat,String subCat, String prod, String size,
		String color)throws Throwable {
	String catValidationLocator = Base.validationOfCategory(category);
	TestMethods.navigateToParticularCategoryInWomen(entity, mainCat, subCat);
	TestMethods.elementIsDisplayed(catValidationLocator);
	//select the product
	Base.SelectProduct(prod, size, color);
	Base.addToCart(prod, "[1]") ;
	Base.enterShippingDetails();
	TestMethods.scrollToView(shippingNextButton);
	TestMethods.xpathClick(shippingNextButton);
	Waits.waitFor2seconds();
	TestMethods.elementIsDisplayed(paymentMethod);
	Waits.waitFor3seconds();
	TestMethods.xpathClick(placeOrderButton);
	Waits.waitFor3seconds();
	TestMethods.elementIsDisplayed(placedOrderSuccessMessage);
}

}
