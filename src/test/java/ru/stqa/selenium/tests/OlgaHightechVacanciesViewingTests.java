package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageBaseHelper;


public class OlgaHightechVacanciesViewingTests extends TestBase {

  private OlgaHomePageBaseHelper homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, OlgaHomePageBaseHelper.class);
  }

  @Test
  public void openQaAdsTest() throws InterruptedException {
   homepage.WaitUntilTitleIsLoaded();
   homepage.hitechLinkClick();
   homepage.waitUntilListIsLoaded();
   homepage.qaLinckClick();
   homepage.waitUntilListIsLoaded();
   homepage.openAllAds();
   Assert.assertEquals(homepage.countFieldsInAds(), 2);






  }
}
