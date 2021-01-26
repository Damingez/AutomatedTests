package com.kowalix.ui.tests;

import com.kowalix.ui.manage.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UICase2 extends TestBase {

    @Test
    public void checkIfOffersAreSorted() {

        app.getJobOffersPage().goToJobOffersPage();
        app.getJobOffersPage().provideCategory("Software Engineering");
        app.getJobOffersPage().provideLocation("Krakow");
        app.getJobOffersPage().chooseSorting("Job Title");

        List<String> jobTitles = app.getJobOffersPage().getClearedJobsNames();

        List<String> sorted = new ArrayList<>(jobTitles);
        Collections.sort(sorted, Collections.reverseOrder());

        Assert.assertEquals(sorted, jobTitles, "Lists are not equal");

    }

}
