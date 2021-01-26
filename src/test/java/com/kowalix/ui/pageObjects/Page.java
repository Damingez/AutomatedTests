package com.kowalix.ui.pageObjects;

import org.openqa.selenium.WebDriver;


public class Page {

    protected WebDriver driver;
  //  protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
    //    this.wait = new WebDriverWait(driver,5);
    }

}
