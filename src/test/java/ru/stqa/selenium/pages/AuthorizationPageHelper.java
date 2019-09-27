package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPageHelper extends PageBase {


    public AuthorizationPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='box']//h3[@class='orange-title no-md-margin-top no-xs-margin-top']")
    WebElement authorizationPageTitle;

    @FindBy(className = "box")
    WebElement authorizationBox;

    @FindBy(xpath = "//input[@placeholder='מייל']")
    WebElement loginField;

    @FindBy(xpath = "//input[@placeholder='הזן סיסמא']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-block orange loading-button'][@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//span[@class='login-error']")
    WebElement messageWrongAuthorization;

    public boolean checkingTitle() {
        log.info("---Authorization page : title check ");
        return authorizationPageTitle.getText().equals("התחבר לחשבון קיים");
    }

    public AuthorizationPageHelper waitUntilPageIsLoaded() {
        log.info("---Authorization page : waiting for page to load ");
        waitUntilElementIsVisibleByElem(authorizationBox,20);
        return this;
    }


    public void loginToTheSystem(String login, String password) {
        log.info("---Authorization page : login to the system");
        enterTextToField(loginField,login);
        log.info("---Authorization page : login was entered");
        enterTextToField(passwordField,password);
        log.info("---Authorization page : password was entered");
        submitButton.click();
    }

    public boolean wrongAuthorizationMessage() {
        log.info("---Authorization page : receiving an incorrect log in message.");
        return messageWrongAuthorization.getText().equals("שם משתמש או סיסמה שגויים, נא נסה שוב ");
    }
}
