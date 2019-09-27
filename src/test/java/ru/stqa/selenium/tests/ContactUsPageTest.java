package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.ContactUsPageHelper;
import ru.stqa.selenium.pages.MainPageHelper;
import ru.stqa.selenium.util.DataProviders;

public class ContactUsPageTest extends TestBase{

    private MainPageHelper mainPage;
    private ContactUsPageHelper contactUsPage;

    @BeforeMethod
    public void initPageObjects() {

        mainPage = PageFactory.initElements(driver, MainPageHelper.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPageHelper.class);
    }

    @Test
    public void testCheckingTitle(){
        log.startTestCase("testCheckingTitle started");
        mainPage.waitUntilPageIsLoaded().openPageContactUs();
        contactUsPage.waitUntilPageIsLoaded();
        Assert.assertTrue(contactUsPage.checkingTitle());
        log.endTestCase("testCheckingTitle finished");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "wrongDataContactUsMessage")
    public void testNegativeContactUsMessage(String name, String mail, String messageText, String subject){
        log.startTestCase("testNegativeContactUsMessage started");
        mainPage.waitUntilPageIsLoaded().openPageContactUs();
        contactUsPage.waitUntilPageIsLoaded().sendMessage(name,mail,messageText,subject).waitUntilPageIsLoaded().closeChat();
        Assert.assertFalse(contactUsPage.checkingNameField()
                            &&contactUsPage.checkingEmailField()
                            &&contactUsPage.checkingSubjectField()
                            &&contactUsPage.checkingMessageField());
        log.endTestCase("testNegativeContactUsMessage finished");
    }

}
