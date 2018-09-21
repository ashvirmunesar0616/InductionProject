package com.sqs.weather;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class weatherForecastObject {


    WebDriver driver;

    /*
    private By dropDownButtonLocator = By.xpath("//*[@id=\"citysearch_chzn\"]/a/span");//
    private By ELButtonLocator = By.xpath("//*[@id=\"citysearch_chzn\"]/a/<span>East London</span>");//
    */

    //used
    private By cityLocator =  By.xpath("//*[@id=\"mod-search-searchword\"]");
    private By favouriteButtonLocator = By.xpath("//*[@id=\"settofavorite\"]");

    private By bodyTextLocator = By.tagName("body");
    private String weatherrsaHeader = "Detailed forecast for City of Tshwane 5 represented by Pretoria";
    private String selectionSuccessful = "Detailed forecast for Buffalo City represented by East London";

    private By Day1Max = By.xpath("//*[@id=\"tabs\"]/ul/li[2]/a/div/div[2]/span[1]");
    private By Day1Min = By.xpath("//*[@id=\"tabs\"]/ul/li[2]/a/div/div[2]/span[2]");

    private By Day2Max = By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a/div/div[2]/span[1]");
    private By Day2Min = By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a/div/div[2]/span[2]");

    private By Day3Max = By.xpath("//*[@id=\"tabs\"]/ul/li[4]/a/div/div[2]/span[1]");
    private By Day3Min = By.xpath("//*[@id=\"tabs\"]/ul/li[4]/a/div/div[2]/span[2]");

    private By Day4Max = By.xpath("//*[@id=\"tabs\"]/ul/li[5]/a/div/div[2]/span[1]");
    private By Day4Min = By.xpath("//*[@id=\"tabs\"]/ul/li[5]/a/div/div[2]/span[2]");

    public weatherForecastObject(WebDriver driver) {

        this.driver = driver;

    }
/*
    public void clickDropDown(WebDriver driver) {

        this.driver.findElement(dropDownButtonLocator).click();


    }

    public void clickEast(WebDriver driver) {

        this.driver.findElement(ELButtonLocator).click();


    }
*/
    public void clickFavourite(WebDriver driver) {

        this.driver.findElement(favouriteButtonLocator).click();

    }


    public void assertSearchHeader(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(weatherrsaHeader));
    }

    public void assertSearchSuccessful(){
        String bodyText = driver.findElement(bodyTextLocator).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(selectionSuccessful));
    }


    public void selectWeather(String city) throws InterruptedException {

        assertSearchHeader();

        driver.findElement(cityLocator).sendKeys(city);
        Thread.sleep(1000);
        driver.findElement(cityLocator).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        clickFavourite(driver);
        Thread.sleep(10000);
        assertSearchSuccessful();

    }

    public String[] populateWeather(){

        String weatherRsaValues[] = new String[8];

        //Day1
        driver.findElement(Day1Max).getText();
        System.out.println("Day1 Max: " + driver.findElement(Day1Max).getText());
        weatherRsaValues[0] = driver.findElement(Day1Max).getText();

        driver.findElement(Day1Min).getText();
        System.out.println("Day1 Min: " + driver.findElement(Day1Min).getText());
        weatherRsaValues[4] = driver.findElement(Day1Min).getText();

        //Day2
        driver.findElement(Day2Max).getText();
        System.out.println("Day2 Max: " + driver.findElement(Day2Max).getText());
        weatherRsaValues[1] = driver.findElement(Day2Max).getText();

        driver.findElement(Day2Min).getText();
        System.out.println("Day2 Min: " + driver.findElement(Day2Min).getText());
        weatherRsaValues[5] = driver.findElement(Day2Min).getText();

        //Day3
        driver.findElement(Day3Max).getText();
        System.out.println("Day3 Max: " + driver.findElement(Day3Max).getText());
        weatherRsaValues[2] = driver.findElement(Day3Max).getText();

        driver.findElement(Day3Min).getText();
        System.out.println("Day3 Min: " + driver.findElement(Day3Min).getText());
        weatherRsaValues[6] = driver.findElement(Day3Min).getText();

        //Day4
        driver.findElement(Day4Max).getText();
        System.out.println("Day4 Max: " + driver.findElement(Day4Max).getText());
        weatherRsaValues[3] = driver.findElement(Day4Max).getText();

        driver.findElement(Day4Min).getText();
        System.out.println("Day4 Min: " + driver.findElement(Day4Min).getText());
        weatherRsaValues[7] = driver.findElement(Day4Min).getText();

        return weatherRsaValues;
    }

}
