package test;
import static org.testng.Assert.assertEquals;
import pojo.*;
import pom.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.NaptoolHomePage;
import pom.OrderSummary;
import pom.ProductDescriptionPage;
import pom.ProductQuickViewPage;
import pom.ProductResultPage;


public class AddToCartTest extends BaseTest{
	ProductResultPage productResultPage;
	ProductQuickViewPage productQuickViewPage;
	CartPage cartPage;

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

	@Test
	public void verifyIfUserIsAbleToAddMultipleProductToCart()
	{
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.clickOnSearch();
		 
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 0);
		
		productQuickViewPage = new ProductQuickViewPage(driver);
		productQuickViewPage.clickOnClickHereToBuy();
		
	    cartPage = new CartPage(driver);
	    cartPage.clickOnContinueShopping();
		
		productResultPage = new ProductResultPage(driver);
		productResultPage.clickOnQuickView(driver, 1);
		
		
		productQuickViewPage.clickOnClickHereToBuy();
		cartPage=new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProdutsPresentInCart(driver),2);
		
		
	}
	
	@Test
	public void verifyIfUserAbleToRemoveProductFromCart()
	{
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.clickOnSearch();
		
		ProductResultPage productresultpage = new ProductResultPage(driver);
		productresultpage.clickOnQuickView(driver, 0);
		
		ProductQuickViewPage productquickviewpage = new ProductQuickViewPage(driver);
		productquickviewpage.clickOnClickHereToBuy();
		
		CartPage cartpage = new CartPage(driver);
		Assert.assertEquals(cartpage.getNumberOfProdutsPresentInCart(driver),1);
		cartpage.clickOnRemove(driver);
		
		
	}
	
	@Test
	public void verifyIfUserAbleToAddToCartUsingProductDescription()
	{
		NaptoolHomePage naptoolhomepage  = new NaptoolHomePage(driver);
		naptoolhomepage.enterProductName("Mobiles");
		naptoolhomepage.clickOnSearch();
		
		ProductResultPage productresultpage = new ProductResultPage(driver);
		String productTitle=productresultpage.getProductName(0);
		productresultpage.clickOnProduct(0);
		productresultpage.switchPage(driver,productTitle);
		
		ProductDescriptionPage productDescriptionPage = new ProductDescriptionPage(driver);
		productDescriptionPage.clickOnClickHereToBuy();
		
	}
	//9 
	@Test
	public void VerifyProdutsDetailsDisplayedInProductSearchResultIsSimilarToDetailsDisplayedInQuickViewTab()
	{
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterProductName("mobile");
		naptoolHomePage.clickOnSearch();
		
		productResultPage = new ProductResultPage(driver);
		String expectedProductName=productResultPage.getProductName(0);
	    double expectedPrice=productResultPage.getPrice(0);
		
	    productResultPage.clickOnQuickView(driver, 1);
	    
	    ProductQuickViewPage productQuickViewPage = new ProductQuickViewPage(driver);
	    Assert.assertEquals(productQuickViewPage.getProductPrice(),expectedPrice );
	   // Assert.assertEquals(productQuickViewPage.getProductName(1),expectedProductName);
	
		
	}
}
	
	