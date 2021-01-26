package com.kowalix.ui.manage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public Application app;

    @BeforeMethod
    public void setUp() {
        app = new Application();
        app.getDriver().manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        app.getDriver().quit();
    }


}
