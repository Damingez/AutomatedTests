package com.kowalix.ui.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobOffersPage extends Page {

    private WebDriverWait wait;

    @FindBy(id = "location")
    private WebElement locationInput;
    @FindBy(id = "category")
    private WebElement categoryInput;
    @FindBy(css = "div[aria-labelledby=header-location]")
    private List<WebElement> locationCells;
    @FindBy(css = "div.list-group-item")
    private List<WebElement> jobRows;


    public JobOffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void goToJobOffersPage() {
        driver.navigate().to("https://akamaicareers.inflightcloud.com/");
    }

    public void provideLocation(String location) {
        locationInput.sendKeys(location);
        wait.until(ExpectedConditions.attributeContains(locationInput, "aria-expanded", "1"));
        locationInput.sendKeys(Keys.ENTER);
    }

    public void provideCategory(String categoryName) {
        categoryInput.sendKeys(categoryName);
        wait.until(ExpectedConditions.attributeContains(categoryInput, "aria-expanded", "1"));
        categoryInput.sendKeys(Keys.ENTER);
    }

    public boolean checkAllOffersFromKrakow() {
        boolean is_Poland_State_Krakow = true;

        for (int i = 0; i < locationCells.size(); i++) {
            String location = locationCells.get(i).getText().trim();
            if (!location.equals("Poland Poland_State Krakow")) {
                is_Poland_State_Krakow = false;
                System.out.println(location);
            }
        }
        return is_Poland_State_Krakow;
    }

    public int countJobsNumber() {
        return jobRows.size();
    }
}
