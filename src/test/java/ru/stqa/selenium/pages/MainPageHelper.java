package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class MainPageHelper extends PageBase {

  public MainPageHelper(WebDriver webDriver) {
    super(webDriver);
  }


  @FindBy(xpath = "//div[@id='header-top-social']//a[1]")
  WebElement loginButton;

  @FindBy(className = "crisp-101bp3x")
  WebElement messageIcon;

  @FindBy(xpath = "//li[@class='contact']//a")
  WebElement contactUsButton;


  public MainPageHelper waitUntilPageIsLoaded(){

    waitUntilElementIsClickableByElem(messageIcon, 30);
    log.info("---Main page : waiting for page to load");
    return this;
  }

  public MainPageHelper openAuthorizationPage(){

    try {
      waitUntilElementIsClickableByElem(loginButton, 20);
    }catch (Exception e){
      log.warn("it needs additional time!!!");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
    loginButton.click();
    log.info("---Main page : authorization page is opened");
    return this;
  }

  public MainPageHelper openPageContactUs(){

    contactUsButton.click();
    log.info("---Main page : contact us page is opened");
    return this;
  }

    public boolean checkingTitle() {
    log.info("---Main page : title check");
    return driver.getTitle().equals("נגב ג'ובס - Negev Jobs אתר הדרושים של הדרום");
    }
}
