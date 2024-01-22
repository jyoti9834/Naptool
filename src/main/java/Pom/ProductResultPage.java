package pom;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductResultPage {
	@FindBy (xpath = "//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath = "//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	
	public ProductResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfProducts() {
		return products.size();
	}
	
	public void clickOnQuickView(WebDriver driver, int product) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(product));
		actions.perform();
		quickView.get(product).click();
	}

	public String getProductName(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickOnProduct(int i) {
		// TODO Auto-generated method stub
		
	}

	public void switchPage(WebDriver driver, String productTitle) {
		// TODO Auto-generated method stub
		
	}

	public double getPrice(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
