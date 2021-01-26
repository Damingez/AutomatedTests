package com.kowalix.ui.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class UICase1 extends TestBase {

    @Test
    public void checkOffersLocations(){

        driver.navigate().to("https://akamaicareers.inflightcloud.com/");

       WebElement categoryInput = driver.findElement(By.id("category"));
       categoryInput.sendKeys("Software Engineering");
         new WebDriverWait(driver, 20).until(ExpectedConditions.attributeContains(categoryInput, "aria-expanded", "1"));
        categoryInput.sendKeys(Keys.ENTER);

       WebElement locationInput = driver.findElement(By.id("location"));
       locationInput.sendKeys("Krakow");
        new WebDriverWait(driver, 20).until(ExpectedConditions.attributeContains(locationInput, "aria-expanded", "1"));
        locationInput.sendKeys(Keys.ENTER);

        int numberOfElements = driver.findElements(By.cssSelector("div.list-group-item")).size();
        assertTrue("There are no elements", numberOfElements > 0);
        List<WebElement> rows = driver.findElements(By.cssSelector("div[aria-labelledby=header-location]"));
        boolean is_Poland_State_Krakow = true;

        // zamienic na stream filter i find any
        for (int i = 0; i < rows.size(); i++) {
          String location = rows.get(i).getText().trim();
          if (!location.equals("Poland Poland_State Krakow") ){
              is_Poland_State_Krakow = false;
              System.out.println(location);
          }
        }

        Assert.assertTrue( is_Poland_State_Krakow, "Not all offers are from Poland and Krakow");



    }

}
