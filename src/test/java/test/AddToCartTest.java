package test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pojo.*;
import Pom.*;



public class AddToCartTest extends BaseTest{
	@BeforeMethod
	public void openApplication() {
		driver = LaunchBrowser.chrome();
	}
	
	@Test
	public void verifyIfUserIsAbleToAddProductToCartUsingQuickViewOption() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productQuickViewPage =new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
		CartPage cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver), 1);
		
	}
}


