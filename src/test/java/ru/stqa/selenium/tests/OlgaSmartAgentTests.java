package ru.stqa.selenium.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageHelper;
import ru.stqa.selenium.pages.OlgaSmartAgentPageHelper;


public class OlgaSmartAgentTests extends TestBase {
    private OlgaHomePageHelper homepage;
    private OlgaSmartAgentPageHelper smartAgentPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, OlgaHomePageHelper.class);
        smartAgentPage = PageFactory.initElements(driver, OlgaSmartAgentPageHelper.class);
    }


    @Test
    public void smartAgentPositiveTest() throws InterruptedException {
        log.startTestCase("smartAgentPositiveTest");
        homepage.clickOnSendMeMailButton();
        smartAgentPage.waitUntilpageIsLoaded();
        smartAgentPage.enterDataRight();
        int count = 0;
        if (smartAgentPage.isMainCatOnListSelectedRight()) {count++;}
        if (smartAgentPage.isLocaleCatOnListSelectedRight()) {count++;}
        if (smartAgentPage.isTagOnListSelectedRight()) {count++;}

        Assert.assertEquals(count, 3, "There is no all categories selected right!");
//        smartAgentPage.putEmailRight();
//        smartAgentPage.clickOnAddMoreAgentsButton();
//        smartAgentPage.waitSaveButtonIsDisplayed();
//        smartAgentPage.clickOnSubmitAgentsButton();
        log.endTestCase("smartAgentPositiveTest");
    }

    @Test
    public void smartAgentNegativeWithOutDataTest() throws InterruptedException {
        log.startTestCase("smartAgentNegativeWithOutDataTest");
        homepage.clickOnSendMeMailButton();
        smartAgentPage.waitUntilpageIsLoaded();
        smartAgentPage.clickOnSaveSmartAgentButton();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("בחירת הסוכן שלך כללית מידי יש להגדיר סוכן הכולל לפחות אזור ותפקיד אחד"), "Wrong message is not displayed!");
        log.endTestCase("smartAgentNegativeWithOutDataTest");
    }
}