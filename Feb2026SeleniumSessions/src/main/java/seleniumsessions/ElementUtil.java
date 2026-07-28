package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver=driver;

	}

	public By getBy(String locatorType,String locatorValue) {

		By locator=null;
		switch(locatorType.toLowerCase()) {

		case "id":
			locator=By.id(locatorValue);
			break;

		case "name":
			locator=By.name(locatorValue);
			break;


		case "className":
			locator=By.className(locatorValue);
			break;

		case "xpath":
			locator=By.xpath(locatorValue);
			break;

		case "cssSelector":
			locator=By.cssSelector(locatorValue);
			break;

		case "linkText":
			locator=By.linkText(locatorValue);
			break;

		case "partialLinkText":
			locator=By.partialLinkText(locatorValue);
			break;

		case "tagName":
			locator=By.tagName(locatorValue);
			break;


		default:
			break;

		}
		return locator;
	}


	public WebElement getElement(By locator) {
		return driver.findElement(locator); 
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);

	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}


	public String doGetText(By locator){
		return getElement(locator).getText(); 
	}

	public boolean isElementPresent(By locator) {
		if(getElements(locator).size()>0) {
			return true;

		}
		return false;
	}

	public List<String> getLinksTextList(By locator) {
		List<WebElement> eleLists=getElements(locator);
		List<String> eleTextList=new ArrayList<String>();
		for(WebElement e:eleLists) {
			String text=e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);

			}
		}

		return eleTextList;
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();

	}

	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

	public List<String> getElementAttributeList(By locator,String attrName) {
		List<WebElement> attributeList=getElements(locator);
		List<String> eleAttrList=new ArrayList<String>();

		for(WebElement w:attributeList) {
			String attrVal=w.getAttribute(attrName);
			System.out.println(attrVal);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}


	//************************Drop Down Utils************************//
	public void doSelectByVisibleText(By locator,String text) {
		Select select=new Select(getElement(locator));
		select.selectByVisibleText(text);

	}

	public void doSelectByValue(By locator,String text) {
		Select select=new Select(getElement(locator));
		select.selectByValue(text);;
	}

	public void doSelectByIndex(By locator,int index) {
		Select select=new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public List<String> doGetDropDownOptions(By locator) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionsList=select.getOptions();
		List<String> optionsValList=new ArrayList<String>();
		System.out.println(optionsList.size());

		for(WebElement e:optionsList) {
			String text =e.getText();
			optionsValList.add(text);
		}
		return optionsValList;

	}

	public void doSelectDropDownValue(By locator, String value) {
		Select select=new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
		for(WebElement e:optionList) {
			if(e.getText().equals(value))
			{
				e.click();
				break;
			}


		}
	}

	//************************Actions Utils****************************************

	public void selectSubMenu(By parentMenu, By childMenu) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		getElement(childMenu).click();



	}

	public void selectSubMenu(By parentMenu, By childMenu, By subChildMenu) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);


		getElement(subChildMenu).click();

	}

	public void selectSubMenu(By parentMenu, By childMenu1, By subChildMenu2, By subChildMenu3) throws InterruptedException {

		Actions action=new Actions(driver);

		action.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);

		action.moveToElement(getElement(subChildMenu3)).perform();
		Thread.sleep(2000);

		getElement(subChildMenu3).click();



	}

	public void doContextClick(By locator) {
		Actions action=new Actions(driver);
		action.contextClick(getElement(locator)).perform();
	}

	public List<String> getRightClickOptionsList(By rightClick, By rightClickOptions) {
		List<String> rightClickItems=new ArrayList<String>();
		doContextClick(rightClick);

		List<WebElement> itemsList=
				getElements(rightClickOptions);

		System.out.println(itemsList.size());

		for(WebElement e:itemsList) {
			String text=e.getText();
			//System.out.println(text);
			rightClickItems.add(text);
		}

		return rightClickItems;
	}

	public  int getRightClickOptionsCount(By rightClick,By rightClickOptions) {
		return getRightClickOptionsList(rightClick,rightClickOptions).size();
	}

	public void selectRightClickMenu(By rightClick, By rightClickOptions,String option) {
		doContextClick(rightClick);

		List<WebElement> itemsList=
				getElements(rightClickOptions);

		System.out.println(itemsList.size());

		for(WebElement e:itemsList) {
			String text=e.getText();
			//System.out.println(text);
			if(text.equals(option)) {
				e.click();
				break;
			}
		}
	}
	
	/*
	 * Clicks in the middle of the given element. Equivalent to: Actions.moveToElement(onElement).click()
	 */
	
	public void doActionsClick(By locator) {
		Actions act=new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	/*
	 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend). 
	 */
	public void doActionsSendKeys(By locator,String value) {
		Actions act=new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	
}













