package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageLoggedInHelper extends PageBase{
    public MainPageLoggedInHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/Dashboard']")
    WebElement profileName;

    @FindBy(xpath = "//ul[@class='nav navbar-nav seeker-dashboard']/li")
    List<WebElement> navigationButtons;

    public MainPageLoggedInHelper waitUntilPageIsLoaded() {
        waitUntilAllElementsAreVisibleByListElem(navigationButtons,30);
        log.info("---MainPageLoggedIn page : waiting for page to load");
        return this;
    }

    public boolean checkingProfile(String firstName, String lastName){

        waitUntilElementContainsTextByElem(profileName,20,"maksym");
        log.info("---MainPageLoggedIn page : profile check");
        return (profileName.getText().contains(firstName) && profileName.getText().contains(lastName));
    }
}
