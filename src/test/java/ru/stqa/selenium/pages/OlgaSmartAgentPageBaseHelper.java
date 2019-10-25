package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OlgaSmartAgentPageBaseHelper extends PageBase {

    private static final String EMAILRIGHT = "olyatester@yandex.ru";

    @FindBy (xpath = "//label[@class='control-label no-md-padding']")
    WebElement titleRequestMailPage;

    @FindBy(xpath = "//select[@id='primary-cat']" )
    WebElement mainCat;

    @FindBy(id = "second-level-cat")
    WebElement secondCat;

    @FindBy(id = "third-level-cat")
    WebElement thirdCat;

    @FindBy(xpath = "//div[@class='row cat-selects']//a[@class='btn btn-success add-tax-btn btn-block']")
    WebElement catSelects;

    @FindBy(xpath = "//select[@name='primary_locale']")
    WebElement mainLocale;

    @FindBy(id = "second-level-locale")
    WebElement secondLocale;

    @FindBy(xpath = "//div[@class='row locale-selects']//a[@class='btn btn-success add-tax-btn btn-block']")
    WebElement localeSelects;

    @FindBy(id = "main-level-tag")
    WebElement mainTag;

    @FindBy(xpath = "//div[@class='row tag-selects']//a[@class='btn btn-success add-tax-btn btn-block']")
    WebElement tagSelects;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailWindow;

    @FindBy (xpath = "//button[@id='add-more-agents']")
    WebElement addMoreAgents;


    @FindBy(xpath = "//button[@id='save-smart-agent']//font//font")
    WebElement saveButton;

    @FindBy(xpath = "//td[@class='cat-selected']")
    WebElement category;

    @FindBy(xpath = "//td[@class='locale-selected']")
    WebElement localeSelected;

    @FindBy(xpath = "//td[@class='tag-selected']")
    WebElement tagSelected;

    @FindBy (xpath = "//button[@id='submit-smart-agents']")
    WebElement submitAgentsButton;

    @FindBy(xpath = "//select[@class='form-control success']")
    List<WebElement> selectors;

    @FindBy(xpath = "//button[@id='save-smart-agent']")
    WebElement saveSmartAgentButton;


    public OlgaSmartAgentPageBaseHelper(WebDriver webDriver) {
        super(webDriver);
    }



    public void waitUntilpageIsLoaded() {
        waitUntilElementVisible(titleRequestMailPage, 50);

    }


    public void putEmailRight() {
        enterTextToField(emailWindow, EMAILRIGHT);

    }

    public void clickOnAddMoreAgentsButton() {
        addMoreAgents.click();
    }



    public void enterDataRight() throws InterruptedException {
        String highTech = "65";
        String beerShevaRaion = "24";
        long timeWait = 3000;

        chooseFilter(mainCat, highTech);
        Thread.sleep(timeWait);

        List<WebElement> allOptionsSecondCat = secondCat.findElements(By.tagName("option"));
        allOptionsSecondCat.get(3).click();
        Thread.sleep(timeWait);

        List<WebElement> allOptionsThirdCat = thirdCat.findElements(By.tagName("option"));
        allOptionsThirdCat.get(1).click();
        Thread.sleep(timeWait);

        catSelects.click();
        Thread.sleep(timeWait);

        chooseFilter(mainLocale, beerShevaRaion);
        Thread.sleep(timeWait);

        List<WebElement> allOptionsSecondLocale = secondLocale.findElements(By.tagName("option"));
        allOptionsSecondLocale.get(1).click();
        Thread.sleep(timeWait);

        localeSelects.click();
        Thread.sleep(timeWait);
        List<WebElement> allOptionsMainTag = mainTag.findElements(By.tagName("option"));
        allOptionsMainTag.get(1).click();
        Thread.sleep(timeWait);

        tagSelects.click();
        Thread.sleep(timeWait);
    }

    public boolean isMainCatOnListSelectedRight() {
        List<WebElement> allOptionsThirdCat = thirdCat.findElements(By.tagName("option"));
        String firstCatText = allOptionsThirdCat.get(1).getText();
        return category.getText().trim().equalsIgnoreCase(firstCatText.trim());
    }
    public boolean isLocaleCatOnListSelectedRight() {
        List<WebElement> allOptionsSecondLocale = secondLocale.findElements(By.tagName("option"));
        String secondLocaleText = allOptionsSecondLocale.get(1).getText();
        return localeSelected.getText().trim().equalsIgnoreCase(secondLocaleText.trim());
    }

    public boolean isTagOnListSelectedRight() {
        List<WebElement> allOptionsMainTag = mainTag.findElements(By.tagName("option"));
        String mainTagText = allOptionsMainTag.get(1).getText();
        return tagSelected.getText().trim().equalsIgnoreCase(mainTagText.trim());
    }

    public void waitSaveButtonIsDisplayed() {
        waitUntilElementVisible(submitAgentsButton, 50);
    }

    public void clickOnSubmitAgentsButton() {
        submitAgentsButton.click();
    }


    public void enterDataWrong() {
    }

    public void clickOnSaveSmartAgentButton() {
        saveSmartAgentButton.click();
    }
}