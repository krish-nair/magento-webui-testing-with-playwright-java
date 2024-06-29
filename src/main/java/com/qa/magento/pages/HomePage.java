package com.qa.magento.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    private final String createAnAccountLink = "//a[text()='Create an Account']";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getTitle(){
        return page.title();
    }
    public void ClickCreateAnAccountLink(){
        page.click(createAnAccountLink);
    }
}
