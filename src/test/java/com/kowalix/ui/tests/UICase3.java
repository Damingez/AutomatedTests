package com.kowalix.ui.tests;

import com.kowalix.ui.manage.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UICase3 extends TestBase {

    @Test
    public void getNonExistingJobs() {

        app.getJobOffersPage().goToJobOffersPage();
        app.getJobOffersPage().filterByKeyword("This job does offer does not exist");
        app.getJobOffersPage().provideLocation("Krakow");

        int numberOfOffers = app.getJobOffersPage().countJobsNumber();
        Assert.assertEquals(numberOfOffers, 0, "There is at least one job offer");

    }

}
