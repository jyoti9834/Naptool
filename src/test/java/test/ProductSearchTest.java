package test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pojo.LaunchBrowser;
import Pom.NaptoolHomePage;
import Pom.ProductResultPage;


public class ProductSearchTest extends BaseTest{

	@Parameters ({"browser"})
	@BeforeMethod
	public void openApplication(String browser) {
		driver = LaunchBrowser.browser(browser);
	}
	
	@Test
	public void verifyIfProdutsAreDisplayedOnValidSearch() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("Mobiles");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProducts()>0);
		
	}
	
	@Test
	public void verifyIfProdutsAreNotDisplayedOnInvalidSearch() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.enterInSearchTab("iphone");
		naptoolHomePage.clickOnSearch();
		
		ProductResultPage productResultPage =new ProductResultPage(driver);
		Assert.assertTrue(productResultPage.getNumberOfProducts()==0);
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}

	
}