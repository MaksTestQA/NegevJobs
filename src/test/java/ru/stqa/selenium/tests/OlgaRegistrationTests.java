package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageHelper;
import ru.stqa.selenium.pages.OlgaRegistrationPageHelper;
import ru.stqa.selenium.util.OlgaDataProviders;

public class OlgaRegistrationTests extends TestBase {
    private OlgaHomePageHelper homePage;
    private OlgaRegistrationPageHelper registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        homePage = PageFactory.initElements(driver, OlgaHomePageHelper.class);
        registrationPage = PageFactory.initElements(driver, OlgaRegistrationPageHelper.class);
    }

//    @Test
//    public void registrationPositiveTest() throws InterruptedException {
//        log.startTestCase("registrationPositiveTest");
//        homePage.clickRegistrationLink();
//        Thread.sleep(1000);
//        registrationPage.clickSearchWorkButton();
//        registrationPage.waitUntilRegistrationPageIsLoaded();
//        registrationPage.isTitleRight();
//        registrationPage.enterRegistrationData();
//        Assert.assertTrue(registrationPage.isRegistrationRight(), "Registration is wrong!");
//        log.endTestCase("registrationPositiveTest");
//    }

    @Test (dataProviderClass = OlgaDataProviders.class, dataProvider = "registrationNegative")
    public void registrationNegativeEmailTest(String firstname, String lastname, String email, String password,
                                              String repassword, String function, String mobile) throws InterruptedException {
        log.startTestCase("registrationNegativeEmailTest");
        homePage.clickRegistrationLink();
        Thread.sleep(1000);
        registrationPage.clickSearchWorkButton();
        registrationPage.waitUntilRegistrationPageIsLoaded();
        registrationPage.isTitleRight();
        registrationPage.enterRegistrationData(firstname, lastname, email, password, password, function, mobile);
        Assert.assertTrue(registrationPage.isEmailWrongMessageDisplayed(), "Wrong message is not displayed!");
        log.endTestCase("registrationNegativeEmailTest");
    }
}
