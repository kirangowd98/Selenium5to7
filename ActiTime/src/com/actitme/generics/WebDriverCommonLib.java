package com.actitme.generics;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDriverCommonLib extends BaseClass {
	/**
	 *implicit wait used to wait for page to load in GUI
	 */
public void waitForPageToLoad()  {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
/**
 * custom wait for element presesnt in GUI
 * @param element
 * @throws InterruptedException 
 */
public void waitForElementInGUI(WebElement element) throws InterruptedException {
	int count=0;
	while(count<=20) {
		try {
			element.isEnabled();
		}
	catch(Exception e) {
		Thread.sleep(1000);
		count++;
	}
	}
}
/**
 * explicit wait for element present in GUI
 * @param element
 */
public void waitForElement(WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
 * select the value from the drop down using text
 * @param element
 * @param text
 */
public void select(WebElement element, String text) {
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * select the value using index 
 * @param element
 * @param index
 */
public void select(WebElement element, int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
}

