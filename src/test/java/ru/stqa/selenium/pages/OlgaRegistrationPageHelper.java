package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OlgaRegistrationPageHelper extends PageBase {
    private static final String FIRSTNAME = "Olga";
    private static final String LASTNAME = "Tester";
    private static final String EMAIL = "olyatester@yandex.ru";
    private static final String PASSWORD = "qwe123123";
    private static final String FUNCTION = "Tester";
    private static final String MOBILE = "0539281111";
    private static final String CITY = "Tel Aviv";


    @FindBy (xpath = "//h3[@class='orange-title no-md-margin-top no-xs-margin-top']")
    WebElement registrationTitle;

    @FindBy (xpath = "//h3[@class='orange-title no-md-margin-top no-xs-margin-top']//font//font")
    WebElement questionTitle;

    @FindBy(xpath = "//div[@class='col-md-6 col-xs-12']//a[@class='btn btn-primary no-icon btn-lg btn-block text-center font-24'][contains(text(),'?')]")
    WebElement searchWorkButton;

    @FindBy (xpath = "//input[@id='first_name']")
    WebElement firstNameField;

    @FindBy (xpath = "//input[@id='last_name']")
    WebElement lastNameField;

    @FindBy (xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy (xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy (xpath = "//input[@id='repassword']")
    WebElement repasswordField;

    @FindBy(xpath = "//input[@id='function']")
    WebElement functionField;

    @FindBy (xpath = "//input[@id='mobile_1']")
    WebElement mobileField;

    @FindBy(xpath = "//select[@id='primary-cat']")
    WebElement primaryCatFilter;

    @FindBy (xpath = "//div[@class='row cat-selects']//a[@class='btn btn-success add-tax-btn btn-block']")
    WebElement catSelectButton;

    @FindBy(xpath = "//select[@name='primary_locale']")
    WebElement primaryLocFilter;

    @FindBy(xpath = "//div[@class='row locale-selects']//a[@class='btn btn-success add-tax-btn btn-block']")
    WebElement locSelectButton;

    @FindBy (xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy (xpath = "//select[@id='hearing_type']")
    WebElement hearingType;

    @FindBy (xpath = "//input[@id='terms']")
    WebElement termsCheckBox;

    @FindBy (xpath = "//input[@id='emsub']")
    WebElement submitButton;

    @FindBy (xpath = "//h3[@class='orange-title no-md-margin-top no-xs-margin-top']")
    WebElement registrationThanksTitle;

    @FindBy(xpath = "//li[contains(text(),',')]")
    WebElement registrationWrongMessage;

    public OlgaRegistrationPageHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitUntilRegistrationPageIsLoaded() {
        log.info("---Registration page : waitUntilRegistrationPageIsLoaded");
        waitUntilElementVisible(registrationTitle, 50);
    }

    public void isTitleRight() {
        log.info("---Registration page : isTitleRight");
        Assert.assertEquals(registrationTitle.getText(), "הרשמה למערכת");
    }

    public void waitUntilPageWithQuestionIsLoaded() {
        log.info("---Registration page : waitUntilPageWithQuestionIsLoaded");
        waitUntilElementVisible(questionTitle, 50);
    }

    public void clickSearchWorkButton() {
        log.info("---Registration page : clickSearchWorkButton");
        searchWorkButton.click();
    }

    public void enterRegistrationData() throws InterruptedException {
        log.info("---Registration page : enterRegistrationData");
        enterTextToField(firstNameField, FIRSTNAME);
        enterTextToField(lastNameField, LASTNAME);
        enterTextToField(emailField, EMAIL);
        enterTextToField(passwordField, PASSWORD);
        enterTextToField(repasswordField, PASSWORD);
        enterTextToField(functionField, FUNCTION);
        enterTextToField(mobileField, MOBILE);
        chooseFilter(primaryCatFilter, "65");
//        catSelectButton.click();
        Thread.sleep(1000);
        chooseFilter(primaryLocFilter, "24");
//        locSelectButton.click();
        Thread.sleep(1000);
        enterTextToField(cityField, CITY);
        chooseFilter(hearingType, "WEBSITE");
        Thread.sleep(1000);
        checkIn(termsCheckBox);
        submitButton.click();
        Thread.sleep(1000);

    }

    public void enterRegistrationData(
            String firstname, String lastname, String email, String password,
            String repassoword, String function, String mobile) throws InterruptedException {
        log.info("---Registration page : enterRegistrationData");
        enterTextToField(firstNameField, firstname);
        enterTextToField(lastNameField, lastname);
        enterTextToField(emailField, email);
        enterTextToField(passwordField, password);
        enterTextToField(repasswordField, repassoword);
        enterTextToField(functionField, function);
        enterTextToField(mobileField, mobile);
        chooseFilter(primaryCatFilter, "65");
        Thread.sleep(1000);
        chooseFilter(primaryLocFilter, "24");
        Thread.sleep(1000);
        enterTextToField(cityField, CITY);
        chooseFilter(hearingType, "WEBSITE");
        Thread.sleep(1000);
        checkIn(termsCheckBox);
        submitButton.click();
        Thread.sleep(1000);

    }

    public boolean isRegistrationRight() {
        log.info("---Registration page : isRegistrationRight");
        return registrationThanksTitle.isDisplayed();
    }

    public boolean isEmailWrongMessageDisplayed() {
        log.info("---Registration page : isEmailWrongMessageDisplayed");
        return registrationWrongMessage.isDisplayed(); }
}
