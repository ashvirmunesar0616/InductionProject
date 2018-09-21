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
public class AppTest
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
        String baseUrl =  "http://www.weathersa.co.za/";
        String expectedTitle = "Forecast";
        driver.get(baseUrl);
        driver.getTitle();
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title is: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(2000);
    }

    @BeforeClass
    public static void browserSetup()
    {

    }


   @Test
    public void shouldSearchCity() throws InterruptedException {

       weatherForecastObject searchPage;
       searchPage = new weatherForecastObject(driver);

       searchPage.selectWeather("East London");

    }

    @Test
    public void shouldSearchTempCity() throws InterruptedException {

        shouldSearchCity();

        weatherForecastObject tempPage;
        tempPage = new weatherForecastObject(driver);


        String wsa[];
        wsa = tempPage.populateWeather();

        for (int i = 0; i <= 7; i++) {

            System.out.println(i + ", " + wsa[i]);
        }

//TODO: weather24 array for compare
       /* Weather24ForecastObject weatherPage;
        weatherPage = new Weather24ForecastObject(driver);

        String w24[];
        w24 = weatherPage.MaxTemp();

        for (int j = 0; j <= 7; j++) {

            System.out.println(j + ", " + w24[j]);
        }
*/
//TODO: Compare
        /*
        //compare
for (int i = 0; i <= 7; i++) {

        if (wsa[i].equals(w24[i])) {

            System.out.println("For " + wsa[i] + " and " + w24[i] +" The temperature is the same!");
        }
        else {
            System.out.println("For " + wsa[i] + " and " + w24[i] +"The temperature is not the same!");

        }

        }*/

    }


    @After
    public void tearDown()
    {
        //driver.close();
    }


}
