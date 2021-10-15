package com.orangehrm.page.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CommonActionOnPages extends BaseSikulix{

    private static final Logger LOGGER = Logger.getLogger(CommonActionOnPages.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    private WebDriver driver;

    //Explicit wait.
    private WebDriverWait webDriverExplicitWait;

    public CommonActionOnPages(WebDriver driver) {
        super();
        try {
            if(driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Configure the explicit wait.
    private void webDriverExplicitWaitConfiguration(WebDriver driver, int seconds){
        try{
            webDriverExplicitWait = new WebDriverWait(driver, seconds);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Configure the implicit wait.
    private void webDriverImplicitwait(WebDriver driver, int seconds){
        try{
            this.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Functions
    protected void clear(By by){
        driver.findElement(by).clear();
    }
    protected boolean displayed(By by){
        return driver.findElement(by).isDisplayed();
    }
    protected String text(By locator){
        return driver.findElement(locator).getText();
    }
    protected void type(By by, String... value){
        driver.findElement(by).sendKeys(value);
    }
    protected void clickOn(By by){
        driver.findElement(by).click();
    }
    protected void doSubmit(By by){
        driver.findElement(by).click();
    }

    public void withExplicitWaitTypeInto(By locator, CharSequence... keysToSend){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }
    public void withExplicitWaitClear(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).clear();
    }
    public void withExplicitWaitClear(WebElement webElement){
        webDriverExplicitWait.until(elementToBeClickable(webElement)).clear();
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void withExplicitWaitClickOn(By locator){
        webDriverExplicitWait.until(presenceOfElementLocated(locator)).click();
    }

    public List<WebElement> javascriptExecutorWithReturnCollection(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (List<WebElement>)jse.executeScript(script);
    }
    public WebElement javascriptExecutorWithReturn(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        return (WebElement)jse.executeScript(script);
    }

    public void javascriptExecutor(String script){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script);
    }

    public void javascriptExecutor(String script, WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script,element);
    }

    public void javascriptExecutor(String script, By element){
        WebElement webElement = driver.findElement(element);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(script,webElement);
    }
}
