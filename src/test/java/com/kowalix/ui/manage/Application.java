package com.kowalix.ui.manage;

import com.kowalix.ui.pageObjects.JobOffersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Application {

    protected  WebDriver driver;
    private final JobOffersPage jobOffersPage;

    public Application(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dako\\Documents\\driver_for_practise\\chromedriver.exe");
        driver = new ChromeDriver();
        jobOffersPage = new JobOffersPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public JobOffersPage getJobOffersPage(){
        return jobOffersPage;
    }


}
