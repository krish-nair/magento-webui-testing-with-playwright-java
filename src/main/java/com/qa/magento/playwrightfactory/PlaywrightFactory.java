package com.qa.magento.playwrightfactory;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;
    public Page launchBrowser(Properties prop){
        String browserName = prop.getProperty("browser").trim();

        playwright = Playwright.create();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double width = (int)dimension.getWidth();
        double height = (int)dimension.getHeight();

        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            default:
                System.out.println("Please check the browser name is correct");
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        page = browserContext.newPage();
        page.navigate(prop.getProperty("url"));

        return page;
    }

    /**
     * Initialize properties
     */
    public Properties initProperties() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
