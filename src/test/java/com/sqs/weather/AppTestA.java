package com.sqs.weather;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.print.attribute.standard.DateTimeAtProcessing;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Unit test for simple App.
 */
public class AppTestA
{
    /**
     * Rigorous Test :-)
     */

    static WebDriver driver;


    @Before
    public void testSetup() throws InterruptedException {
        System.out.println("In testSetup ");
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        String baseUrl =  "http://weather.news24.com/";
        //String expectedTitle = "weather.new24.com";
        driver.get(baseUrl);
        driver.getTitle();
        //String actualTitle = driver.getTitle();
        //System.out.println("Actual Title is: " + actualTitle);
        //Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(2000);
    }

    @BeforeClass
    public static void browserSetup()
    {

    }


    @Test
    public void shouldNavigateCity() throws InterruptedException {

        Weather24ForecastObject naviPage;
        naviPage = new Weather24ForecastObject(driver);

        naviPage.navigationPath("East London");
    }

    @Test
    public void shouldGetTempCity() throws InterruptedException {

        Weather24ForecastObject naviPage;
        naviPage = new Weather24ForecastObject(driver);
        naviPage.navigationPath("East London");

        Weather24ForecastObject TempPage;
        TempPage = new Weather24ForecastObject(driver);
        TempPage.MaxTemp();


    }


    @After
    public void tearDown()
    {
        //driver.close();
    }


}
