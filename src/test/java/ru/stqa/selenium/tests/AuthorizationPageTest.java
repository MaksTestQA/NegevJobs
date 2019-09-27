package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.AuthorizationPageHelper;
import ru.stqa.selenium.pages.MainPageHelper;
import ru.stqa.selenium.util.DataProviders;

public class AuthorizationPageTest extends TestBase {

    private MainPageHelper mainPage;
    private AuthorizationPageHelper authorizationPage;

    @BeforeMethod
    public void initPageObjects() {

        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        authorizationPage = PageFactory.initElements(driver, AuthorizationPageHelper.class);
    }

    @Test
    public void testMainPageTitle() {
        log.startTestCase("testMainPageTitle started");
        mainPage.waitUntilPageIsLoaded().openAuthorizationPage();
        authorizationPage.waitUntilPageIsLoaded();
        Assert.assertTrue(authorizationPage.checkingTitle());
        log.endTestCase("testMainPageTitle finished");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative")
    public void testNegativeAuthorization(String login , String password){
        log.startTestCase("testNegativeAuthorization started");
        mainPage.waitUntilPageIsLoaded().openAuthorizationPage();
        authorizationPage.waitUntilPageIsLoaded().loginToTheSystem(login,password);
        Assert.assertFalse(authorizationPage.wrongAuthorizationMessage());
        log.endTestCase("testNegativeAuthorization finished");
    }
}
