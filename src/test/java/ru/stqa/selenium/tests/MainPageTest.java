package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.AuthorizationPageHelper;
import ru.stqa.selenium.pages.MainPageHelper;

public class MainPageTest extends TestBase {

  private MainPageHelper mainPage;
  private AuthorizationPageHelper authorizationPage;
//comment
  @BeforeMethod
  public void initPageObjects() {

    mainPage = PageFactory.initElements(driver, MainPageHelper.class);
    authorizationPage = PageFactory.initElements(driver, AuthorizationPageHelper.class);
  }

  @Test
  public void testCheckingTitle(){
    log.startTestCase("testCheckingTitle started");
    mainPage.waitUntilPageIsLoaded();
    Assert.assertTrue(mainPage.checkingTitle());
    log.endTestCase("testCheckingTitle finished");
  }
}
