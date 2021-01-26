package com.kowalix.ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @FindBy(id = "sortbySelect")
    private WebElement sortBySelect;
    @FindBy(id = "keywordLocation")
    private WebElement keywordInput;


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

    public void chooseSorting(String sortBy){
        Select options = new Select(sortBySelect);
        options.selectByVisibleText(sortBy);
    }

    public List<String> getClearedJobsNames(){
        List<WebElement> jobTitleWebElements = driver.findElements(By.cssSelector("div[aria-labelledby=header-titler]:first-child"));

        List<String> jobTitles = jobTitleWebElements
                .stream()
                .map(element -> element.getText()
                        .substring(0, element.getText().indexOf("\n")))
                .collect(Collectors.toCollection(ArrayList::new));

        return jobTitles;
    }

    public void filterByKeyword(String keyword){
        keywordInput.sendKeys("This job does offer does not exist");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(keywordInput, "aria-expanded"));
        keywordInput.sendKeys(Keys.ENTER);
    }

}
