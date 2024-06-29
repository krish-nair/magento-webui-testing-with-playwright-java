package com.qa.magento.tests;

import com.qa.magento.basetest.BaseTest;
import org.testng.Assert;

public class HomePageTest extends BaseTest {
    public void verifyTitle(){
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(actualTitle, );
    }
}
