package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageBaseHelper;
import ru.stqa.selenium.pages.OlgaRegistrationPageBaseHelper;
import ru.stqa.selenium.util.OlgaDataProviders;

public class OlgaRegistrationTests extends TestBase {
    private OlgaHomePageBaseHelper homePage;
    private OlgaRegistrationPageBaseHelper registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, OlgaHomePageBaseHelper.class);
        registrationPage = PageFactory.initElements(driver, OlgaRegistrationPageBaseHelper.class);
    }

    @Test
    public void RegistrationPositive() throws InterruptedException {
        homePage.clickRegistrationLink();
        Thread.sleep(1000);
        registrationPage.clickSearchWorkButton();
        registrationPage.waitUntilRegistrationPageIsLoaded();
        registrationPage.isTitleRight();
        registrationPage.enterRegistrationData();
        Assert.assertTrue(registrationPage.isRegistrationRight());
    }

    @Test (dataProviderClass = OlgaDataProviders.class, dataProvider = "registrationNegative")
    public void RegistrationNegativeEmail(String firstname, String lastname, String email, String password,
                                          String repassword, String function, String mobile) throws InterruptedException {
        homePage.clickRegistrationLink();
        Thread.sleep(1000);
        registrationPage.clickSearchWorkButton();
        registrationPage.waitUntilRegistrationPageIsLoaded();
        registrationPage.isTitleRight();
        registrationPage.enterRegistrationData(firstname, lastname, email, password, password, function, mobile);
        Assert.assertTrue(registrationPage.isEmailWrongMessageDisplayed());
    }
}
