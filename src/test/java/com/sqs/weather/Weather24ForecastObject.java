package com.sqs.weather;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Weather24ForecastObject {

    WebDriver driver;

    private By dropdownCityButtonLocator = By.xpath("//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]");
    private By goButtonLocator = By.xpath("//*[@id=\"ctl00_WeatherContentHolder_btnGo\"]");
    private By ForecastTablelocator = By.xpath("//*[@id=\"ext-gen28\"]");
    private By dropdownLocator =  By.xpath("//*[@id=\"ctl00_WeatherContentHolder_ddlCity\"]");
    private By bodyTextLocator = By.tagName("body");
    private String weather24Header = "Select a Region and view the weather data.";
    private String selectionSuccessful = "7 Day Expanded Forecast";

    private By Day1Max = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[4]");
    private By Day1Min = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[4]/td[5]");

    private By Day2Max = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[4]");
    private By Day2Min = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[5]/td[5]");

    private By Day3Max = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[4]");
    private By Day3Min = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[6]/td[5]");

    private By Day4Max = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[4]");
    private By Day4Min = By.xpath("//*[@id=\"forecastContent\"]/table/tbody/tr[7]/td[5]");

    public Weather24ForecastObject(WebDriver driver) {

        this.driver = driver;

    }

    public void clickCityEvent(WebDriver driver){

        this.driver.findElement(dropdownCityButtonLocator).click();
    }

    public void clickGoEvent(WebDriver driver){

        this.driver.findElement(goButtonLocator).click();
    }

    public void click7dayEvent(WebDriver driver){

        this.driver.findElement(ForecastTablelocator).click();
    }

    public void assertSearchHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(weather24Header));
    }

    public void assertSearchSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(selectionSuccessful));
    }

    public void navigationPath( String City) throws InterruptedException {

        assertSearchHeader();
        //clickCityEvent(driver);
        driver.findElement(dropdownLocator).sendKeys(City);
        //driver.findElement(dropdownLocator).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        clickGoEvent(driver);
        Thread.sleep(2000);
        click7dayEvent(driver);
        Thread.sleep(2000);
        assertSearchSuccessful();

    }

    public String[] MaxTemp() {

        String MaxValues[] = new String[8];

        //Day1
        driver.findElement(Day1Max).getText();
        System.out.println("Day1 Max: " + driver.findElement(Day1Max).getText());
        MaxValues[0] = driver.findElement(Day1Max).getText();

        driver.findElement(Day1Min).getText();
        System.out.println("Day1 Min: " + driver.findElement(Day1Min).getText());
        MaxValues[4] = driver.findElement(Day1Min).getText();

        //Day2
        driver.findElement(Day2Max).getText();
        System.out.println("Day2 Max: " + driver.findElement(Day2Max).getText());
        MaxValues[1] = driver.findElement(Day2Max).getText();

        driver.findElement(Day2Min).getText();
        System.out.println("Day2 Min: " + driver.findElement(Day2Min).getText());
        MaxValues[5] = driver.findElement(Day2Min).getText();

        //Day3
        driver.findElement(Day3Max).getText();
        System.out.println("Day3 Max: " + driver.findElement(Day3Max).getText());
        MaxValues[2] = driver.findElement(Day3Max).getText();

        driver.findElement(Day3Min).getText();
        System.out.println("Day3 Min: " + driver.findElement(Day3Min).getText());
        MaxValues[6] = driver.findElement(Day3Min).getText();

        //Day4
        driver.findElement(Day4Max).getText();
        System.out.println("Day4 Max: " + driver.findElement(Day4Max).getText());
        MaxValues[3] = driver.findElement(Day4Max).getText();

        driver.findElement(Day4Min).getText();
        System.out.println("Day4 Min: " + driver.findElement(Day4Min).getText());
        MaxValues[7] = driver.findElement(Day4Min).getText();

        return MaxValues;
    }


}
