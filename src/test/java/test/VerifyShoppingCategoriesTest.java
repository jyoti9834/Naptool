package test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pojo.LaunchBrowser;
import Pom.NaptoolHomePage;

@Listeners(test.Listeners.class)


public class VerifyShoppingCategoriesTest extends BaseTest {

	@Parameters ({"browser"})
	@BeforeMethod
	public void openApplication(String browser) {
		driver = LaunchBrowser.browser(browser);
	}
	
	@Test
	public void verifyIfUserIsAbleToAccessShoppingCategories() {
		NaptoolHomePage naptoolHomePage = new NaptoolHomePage(driver);
		naptoolHomePage.clickOnShoppingCategories();
		naptoolHomePage.selectShoppingCategories(driver, 3);
		String currentTitle =driver.getTitle();
		AssertJUnit.assertTrue(currentTitle.contains("Mobile Handsets"));
		AssertJUnit.assertEquals(naptoolHomePage.getCategoryHeading(), "Mobiles : Mobile Handsets");	
	}
	
	@AfterMethod
	public void postTest() {
		driver.close();
	}
	

	
}