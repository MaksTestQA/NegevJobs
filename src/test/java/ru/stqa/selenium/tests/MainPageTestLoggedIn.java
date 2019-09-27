package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.AuthorizationPageHelper;
import ru.stqa.selenium.pages.MainPageLoggedInHelper;
import ru.stqa.selenium.pages.MainPageHelper;
import ru.stqa.selenium.util.DataProviders;

public class MainPageTestLoggedIn extends TestBase {

    private MainPageHelper mainPage;
    private AuthorizationPageHelper authorizationPage;
    private MainPageLoggedInHelper mainPageLoggedIn;

    @BeforeMethod
    public void initPageObjects() {

        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        authorizationPage = PageFactory.initElements(driver, AuthorizationPageHelper.class);
        mainPageLoggedIn = PageFactory.initElements(driver, MainPageLoggedInHelper.class);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveLogin")
    public void testPositiveLogin(String login, String password, String firstName, String lastName){
        log.startTestCase("testPositiveLogin started");
        mainPage.waitUntilPageIsLoaded().openAuthorizationPage();
        authorizationPage.waitUntilPageIsLoaded().loginToTheSystem(login,password);
        mainPageLoggedIn.waitUntilPageIsLoaded();
        Assert.assertTrue(mainPageLoggedIn.checkingProfile(firstName,lastName));
        log.endTestCase("testPositiveLogin finished");
    }
}