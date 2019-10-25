package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Sample page
 */
public class OlgaHomePageBaseHelper extends PageBase {

  @FindBy(xpath = "//a[@class='bold']")
  WebElement registrationLink;



  @FindBy (xpath = "//h3[@class='page-header orange-title']")
  WebElement homePageTitle;

  @FindBy(xpath = "//div[@class='box']//div[1]//ul[1]//li[1]//a[1]")
  WebElement hitechLink;
  
  @FindBy(xpath = "//a[contains(text(),'QA')]")
  WebElement qaLink;

  @FindBy(className = "container w-auto no-md-padding no-xs-padding")
  List<WebElement> ads;

  @FindBy(xpath = "//label[1]")
  List<WebElement> textsLabel1;

  @FindBy(xpath = "//label[2]")
  List<WebElement> textsLabel2;

  @FindBy(xpath = "//label[3]")
  List<WebElement> textsLabel3;

  @FindBy(xpath = "//span[@class='breadcrumb-nolink']")
  WebElement breadcrumb;

  @FindBy(xpath = "//button[@name='submit']")
  WebElement searchButton;

  @FindBy(xpath = "//i[@class='fa fa-chevron-circle-down']")
  List<WebElement> circleDownButtons;

  @FindBy(xpath = "//a[@id='send-me-emails-button']")
  WebElement sendMeMailButton;

  @CacheLookup
  public WebElement header;

  public OlgaHomePageBaseHelper(WebDriver webDriver) {
        super(webDriver);
    }


  public void WaitUntilTitleIsLoaded() {
    waitUntilElementVisible(homePageTitle, 30);
  }

    public void clickRegistrationLink() {
      registrationLink.click();
  }



    public void hitechLinkClick(){hitechLink.click();}

    public void qaLinckClick() {qaLink.click();}

    public void waitUntilListIsLoaded() {waitUntilAllElementsVisible(searchButton, 30); }


    public void openAllAds() throws InterruptedException {
      for (WebElement we: circleDownButtons){
          we.click();
          Thread.sleep(1000);
      }
    }

    public int countFieldsInAds() {
        int count = 0;
        if (textsLabel2.size() == circleDownButtons.size()) count++;
        if (textsLabel3.size() == circleDownButtons.size()) count++;
        return count;
    }


    public void clickOnSendMeMailButton() {
      sendMeMailButton.click();
    }
}
