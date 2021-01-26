package com.kowalix.ui.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class UICase1 extends TestBase {

    @Test
    public void checkOffersLocations() {

        app.getJobOffersPage().goToJobOffersPage();
        app.getJobOffersPage().provideCategory("Software Engineering");
        app.getJobOffersPage().provideLocation("Krakow");

        int numberOfElements = app.getJobOffersPage().countJobsNumber();
        assertTrue("There are no elements", numberOfElements > 0);

        boolean is_Poland_State_Krakow = app.getJobOffersPage().checkAllOffersFromKrakow();
        Assert.assertTrue(is_Poland_State_Krakow, "Not all offers are from Poland and Krakow");

    }

}
