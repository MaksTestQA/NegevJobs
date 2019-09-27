package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPageHelper extends PageBase{
    public ContactUsPageHelper(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='crisp-101bp3x']")
    WebElement messageIcon;

    @FindBy(xpath = "//h3[@class='orange-title no-md-margin-top no-xs-margin-top']")
    WebElement title;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "message")
    WebElement messageField;

    @FindBy(id = "subject")
    WebElement subjectField;

    @FindBy(id = "submit")
    WebElement sendMessageButton;

    @FindBy(xpath = "//span[@class='crisp-bz13r8 crisp-i1yn7v']")
    WebElement closeChatPopUa;

    public ContactUsPageHelper waitUntilPageIsLoaded() {
        log.info("---Contact us page : waiting for page to load");
        waitUntilElementIsClickableByElem(messageIcon, 20);
        return this;
    }

    public boolean checkingTitle() {
        log.info("---Contact us page : title check ");
        return title.getText().equals("צור קשר");
    }

    public ContactUsPageHelper sendMessage(String name, String mail, String message, String subject){
        log.info("---Contact us page : Send message");
        enterTextToField(nameField, name);
        log.info("---Contact us page : name is entered");
        enterTextToField(emailField, mail);
        log.info("---Contact us page : email is entered");
        enterTextToField(messageField, message);
        Select select = new Select(subjectField);
        select.selectByVisibleText(subject);
        log.info("---Contact us page : subject is entered");
        sendMessageButton.click();
        log.info("---Contact us page : sending message");
        return this;
    }


    public boolean checkingSubjectField() {

        log.info("---Contact us page : checking subject field");
        return subjectField.getAttribute("aria-invalid").equals("true");//return true if entered data is wrong

    }
    public boolean checkingEmailField() {

        log.info("---Contact us page : checking email field");
        return emailField.getAttribute("aria-invalid").equals("true");//return true if entered data is wrong
    }
    public boolean checkingNameField() {

        log.info("---Contact us page : checking name field");
        return nameField.getAttribute("aria-invalid").equals("true");//return true if entered data is wrong
    }

    public boolean checkingMessageField() {

        log.info("---Contact us page : checking message field");
        return messageField.getAttribute("aria-invalid").equals("true");//return true if entered data is wrong
    }

    public ContactUsPageHelper closeChat(){
        closeChatPopUa.click();
        log.info("---Contact us page : chat window was closed");
        return this;
    }
}
