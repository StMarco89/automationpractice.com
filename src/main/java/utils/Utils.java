package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utils klasa sadrzi helper funkcije koje se koriste na vise mesta u page klasama. 
 * Na ovaj nacin su delovi koje se ponavljaju izvuceni na jedno mesto.
 * Sve metode su staticke, tako da se mogu pozivati bez instanciranja same klase. 
 * 
 *
 */
public class Utils {

	/**
	 * 
	 * This function will take screenshot
	 * 
	 * @param webdriver
	 * @param fileWithPath
	 * @throws Exception
	 * 
	 */

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	/**
	 * 
	 * This function will check element presence
	 * 
	 * @param webdriver
	 * @param selector
	 * 
	 */
	public static boolean isPresent(WebDriver webdriver, By selector) {
		// try to find element by specified selector
		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			// if element not exist return false
			return false;
		}
		return true;
	}
	
	/**
	 * Metoda ceka da element sa prosledjenim selektorom postan klikabilan (displayed and enabled)
	 * @param driver - web driver
	 * @param selector - selektor elementa koji cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element
	 */
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	
	/**
	 * Metoda ceka da se element sa prosledjenim selektorom pojavi u DOM stablu
	 * @param driver - web driver
	 * @param selector - selektor elementa cije prisustvo cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element
	 */
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
	
	/**
	 * Metoda ceka da naslov stranice postane jednak prosledjenom stringu
	 * @param driver
	 * @param title - naslov koji cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 */
	public static void waitForTitle(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}

}
