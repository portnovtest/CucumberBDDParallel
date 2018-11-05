package com.w2a.cucumber.parallel.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseSteps {

    private WebDriver driver;
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setWebDriver(WebDriver driver) {
        dr.set(driver);
    }

    protected WebDriverWait wait;

    protected void startWebDriver(String browser){
        if (browser.equals("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")){
            driver = new ChromeDriver();
        }

        setWebDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(getDriver(),10);
    }

    protected void navigate(String url){
        getDriver().navigate().to(url);
    }

    protected void stopWebDriver(){
        getDriver().quit();
    }
}
