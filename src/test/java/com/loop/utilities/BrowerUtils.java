package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

//    public static void waitForPageToLoad(long timeOutInSeconds) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//            }
//        };
//        try {
//            LOG.info("Waiting for page to load...");
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
//            wait.until(expectation);
//        } catch (Throwable error) {
//            LOG.info(
//                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
//        }
//    }


    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (WebDriverException we) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


//    public static void waitUntilPageLoad() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
//        wait.until((d) -> {
//            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) Driver.getDriver())
//                    .executeScript("return document.readyState").equals("complete");
//            if (!isPageLoaded)
//                LOG.info("Document is loading");
//            return isPageLoaded;
//        });
//    }


//    public static void createFileWithContent(String filePath, String content) throws IOException {
//        File file = new File(filePath);
//
//        try {
//            file.createNewFile();
//            FileWriter fw = new FileWriter(file);
//            try {
//                fw.write(content);
//            } catch (Exception e) {
//                Log.debug("Error during FileWriter append. " + e.getMessage(), e.getCause());
//            } finally {
//                try {
//                    fw.close();
//                } catch (Exception e) {
//                    Log.debug("Error during FileWriter close. " + e.getMessage(), e.getCause());
//                }
//            }
//
//        } catch (IOException e) {
//            Log.debug(e.getMessage(), e.getCause());
//        }
//    }



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

    public static List<String> getElementsTest (List<WebElement> elements){
        List<String> elementsText = new ArrayList<>();
        for(WebElement element : elements){
            elementsText.add(element.getText());
        }
        return elementsText;
    }

    public static List<String> getElementsTestWithStream (List<WebElement> elements){

        return elements.stream()
                .map(x->x.getText())
                .collect(Collectors.toList());
    }
    public static List<String> getElementsTextWithStream2 (List<WebElement> elements){
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
