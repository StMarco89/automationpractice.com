package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CreateAccount {
	
	private WebDriver driver;
	
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return Utils.waitForElementPresence(driver, By.id("create-account_form"), 30);
	}
	
	public WebElement getCreatAccountEmailField() {
		return Utils.waitForElementPresence(driver, By.id("email_create"), 30);
	}
	
	public WebElement getCreateAccountBtn() {
		return Utils.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public void setCreateAccountEmailField(String email) {
		WebElement element = this.getCreatAccountEmailField();
		element.clear();
		element.sendKeys(email);
	}
	
	/****** ERRORS ******/
	
	public WebElement getEmailFieldHighlightedRed() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 30);
	}
	
	public WebElement getEmailFieldHighlightedGreen() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 30);
	}
	
	public WebElement getEmailErrorMessage() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public WebElement getEmailBeenRegistered() {
		return Utils.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
	}
}
