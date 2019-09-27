package ru.stqa.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.selenium.util.LogLog4j;

import java.util.List;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class PageBase {

  public static Logger Log = Logger.getLogger(LogLog4j.class.getName());
  public static LogLog4j log = new LogLog4j();

  protected WebDriver driver;
  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public PageBase(WebDriver driver) {
    this.driver = driver;
  }

  public void waitUntilElementIsClickableByLoc(By locator, int time) {

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(locator));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
    public void waitUntilElementIsClickableByElem(WebElement element, int time){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElementIsVisibleByLoc(By locator, int time){

    try{
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElementIsVisibleByElem(WebElement element, int time){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilAllElementsAreVisibleByLoc(By locator, int time){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilAllElementsAreVisibleByListElem(List<WebElement>elements, int time){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElemAttributeContainsTextByLoc(By locator, int time, String attributeName, String attributeValue){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.attributeContains(locator,attributeName,attributeValue));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElemAttributeContainsTextByElem(WebElement element, int time, String attributeName, String attributeValue){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElementContainsTextByLoc(By locator, int time, String value){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElementLocated(locator, value));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void waitUntilElementContainsTextByElem(WebElement element, int time, String value){

    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.textToBePresentInElement(element, value));
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public void enterTextToField(WebElement element, String text){
    element.click();
    element.clear();
    element.sendKeys(text);
  }

}
