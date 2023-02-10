package com.thinkitive.excelbased.helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManger {
    private static WebDriver driver = null;
    public static WebDriver getDriver(){
        return driver;
    }
    public static  void initDriver(){
        terminateTest();
        System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void terminateTest() {
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }
}
