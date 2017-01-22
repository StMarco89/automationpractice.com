package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class Homepage {
	
	private WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSignInBtn() {
		//return driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
		return Utils.waitToBeClickable(driver, By.xpath("//a[contains(text(), \"Sign in\")]"), 30);
	}
	
	public WebElement getHomePageSlider() {
		return Utils.waitForElementPresence(driver, By.id("homepage-slider"), 30);
	}
	
	public WebElement getContainerPopular() {
		return Utils.waitForElementPresence(driver, By.id("homefeatured"), 30);
	}
	
	public WebElement getFooterBaners() {
		return Utils.waitForElementPresence(driver, By.id("htmlcontent_home"), 30);
	}	
}
