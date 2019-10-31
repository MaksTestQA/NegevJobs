package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.pages.OlgaHomePageHelper;


public class OlgaHightechVacanciesViewingTests extends TestBase {

  private OlgaHomePageHelper homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, OlgaHomePageHelper.class);
  }

  @Test
  public void hightechVacanciesViewingPositiveTest() throws InterruptedException {
      log.startTestCase("hightechVacanciesViewingPositiveTest");
      homepage.WaitUntilTitleIsLoaded();
      homepage.hitechLinkClick();
      homepage.waitUntilListIsLoaded();
      homepage.qaLinckClick();
      homepage.waitUntilListIsLoaded();
      homepage.openAllAds();
      Assert.assertEquals(homepage.countFieldsInAds(), 2, "Count of the ads is wrong!");
      log.endTestCase("hightechVacanciesViewingPositiveTest");






  }
}
