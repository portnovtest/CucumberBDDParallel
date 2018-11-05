package com.w2a.cucumber.parallel.google;

import com.aventstack.extentreports.Status;
import com.w2a.cucumber.parallel.extent.ExtentManager;
import com.w2a.cucumber.parallel.extent.ExtentTestManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSteps extends BaseSteps {

    protected Scenario scenario;
    static String scenarioName;
    static int x = 0;

    @Before
    public void before(Scenario scenario){

        x +=1;
        this.scenario = scenario;
        scenarioName = scenario.getName();
        ExtentTestManager.startTest("Scenario No : " + x + " : " +scenario.getName());
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started: - " + scenario.getName());
    }

    @After
    public void after(Scenario scenario){

        if (scenario.isFailed()){
            ExtentTestManager.logFail("Scenario Failed");
            ExtentTestManager.addScreenShotsOnFailure();
        } else {
            ExtentTestManager.logPass("Scenario Passed");
        }
        ExtentManager.getReporter().flush();
        stopWebDriver();
    }


    @Given("^launch browser '(.*?)'$")
    public void launch_browser_firefox(String browserName) throws Throwable {

        ExtentTestManager.logInfo("Launching Browser : " + browserName);
        startWebDriver(browserName);

    }

    @When("^user navigates to '(.*?)'$")
    public void user_navigates_to_http_google_com(String url) throws Throwable {

        ExtentTestManager.logInfo("Navigating to the URL : " + url);
        navigate(url);
    }

    @Then("^user enters search term '(.*?)'$")
    public void user_enters_search_term_Way_Automation_Selenium(String searchText) throws Throwable {

        ExtentTestManager.logInfo("Entering the value in Search box : " + searchText);
        getDriver().findElement(By.name("q")).sendKeys(searchText);
    }

    @And("^clicks on search button$")
    public void clicks_on_search_button() throws Throwable {
        ExtentTestManager.logInfo("Clicking search button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK"))).click();



    }
}
