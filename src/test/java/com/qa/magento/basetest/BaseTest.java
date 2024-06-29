package com.qa.magento.basetest;

import com.microsoft.playwright.Page;
import com.qa.magento.pages.HomePage;
import com.qa.magento.playwrightfactory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.initProperties();
        page = pf.launchBrowser(prop);

    }


    @AfterTest
    public void tearDown(){
        page.context().browser().close();
//        page.pause();
    }
}
