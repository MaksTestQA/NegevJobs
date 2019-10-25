package ru.stqa.selenium.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageBaseHelper;
import ru.stqa.selenium.pages.OlgaSmartAgentPageBaseHelper;


public class OlgaSmartAgentTests extends TestBase {
    private OlgaHomePageBaseHelper homepage;
    private OlgaSmartAgentPageBaseHelper smartAgentPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, OlgaHomePageBaseHelper.class);
        smartAgentPage = PageFactory.initElements(driver, OlgaSmartAgentPageBaseHelper.class);
    }


    @Test
    public void SmartAgentTestPositive() throws InterruptedException {
        homepage.clickOnSendMeMailButton();
        smartAgentPage.waitUntilpageIsLoaded();
        smartAgentPage.enterDataRight();
        int count = 0;
        if (smartAgentPage.isMainCatOnListSelectedRight()) {count++;}
        if (smartAgentPage.isLocaleCatOnListSelectedRight()) {count++;}
        if (smartAgentPage.isTagOnListSelectedRight()) {count++;}

        Assert.assertEquals(count, 3);
//        smartAgentPage.putEmailRight();
//        smartAgentPage.clickOnAddMoreAgentsButton();
//        smartAgentPage.waitSaveButtonIsDisplayed();
//        smartAgentPage.clickOnSubmitAgentsButton();
    }

    @Test
    public void SmartAgentTestNegativeWithOutData() throws InterruptedException {
        homepage.clickOnSendMeMailButton();
        smartAgentPage.waitUntilpageIsLoaded();
        smartAgentPage.clickOnSaveSmartAgentButton();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("בחירת הסוכן שלך כללית מידי יש להגדיר סוכן הכולל לפחות אזור ותפקיד אחד"));

    }
}