package com.w2a.cucumber.parallel.google.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/com.w2a.cucumber.parallel.google.features/search-many.feature",
        glue = "com.w2a.cucumber.parallel.google"
)
public class SearchManyFeature {

    @Test
    public void runCukes(){

        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
