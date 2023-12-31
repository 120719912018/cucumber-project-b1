package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}

   // private static WebDriver driver;
    private static InheritableThreadLocal <WebDriver> driverPool = new InheritableThreadLocal<>();
  /*
    reusable method that will return the same driver instance everytime when called
     */

    /**
     * singleton pattern
     * @return driver
     * @author nsh
     */

    public static WebDriver getDriver(){
        if (driverPool.get()==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    break;

                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); // Enable headless mode
                    options.addArguments("start-maximized"); // maximize
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }


        return driverPool.get();
    }

    public static void closingDriver(){
        if(driverPool.get() != null){
            //driver.close();
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
