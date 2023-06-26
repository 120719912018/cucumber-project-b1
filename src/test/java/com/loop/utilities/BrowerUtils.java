package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowerUtils {

    /**
     * Click any for loop
     *
     * @param nameOfPage
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element =Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author nsh
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author nsh
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author nsh
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     * @author nsh
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * wait for providing element to be visible
     * @param element
     * @param timeToWaitSec
     * @return element
     * @author nadir
     */
    public static WebElement waitForVisibility(WebElement element,int timeToWaitSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * wait for providing element to be not visible
     * @param element
     * @param timeToWait
     * @author khoshgadam
     */
    public static void waitForInvisibility(WebElement element,int timeToWait){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWait));
         wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * method that will wait until the element becames clickable
     * @param element
     * @param timeOut
     * @return
     * @author khoshgadam
     */

    public static WebElement waitForClickable (WebElement element,int timeOut){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * method perform a pause
     * @param seconds
     *
     */
    public static void justWait(int seconds) throws InterruptedException {

        try {
            Thread.sleep(seconds* 1000);
        } catch (InterruptedException exception){
            exception.printStackTrace();
            System.out.println("Exception handled");
        }

    }
    public static Scenario myScenario;
    public static void takeScreenshot(){
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd){
            wbd.getMessage();
        } catch (ClassCastException cce){
            cce.getMessage();
        }
    }
}
