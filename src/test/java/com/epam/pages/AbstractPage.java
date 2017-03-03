package com.epam.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

/**
 * Created by Artur_Koshelev.
 */
public class AbstractPage {
    protected WebDriver driver;
    protected String browserName = "chrome";

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoading();
    }

    protected void waitForPageLoading() {};

    //protected void highligtElement(WebDriver driver, WebElement element) {
    //    String bg  = element.getCssValue("backgroundColor");
    //    JavascriptExecutor js = ((JavascriptExecutor) driver);
    //    js.executeScript("arguments[0].style.backgroundColor = '" + "green" + "'", element);
    //    try {
    //        Thread.sleep(1000);
    //    } catch (InterruptedException e) {
    //        e.printStackTrace();
    //    }
    //    js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    //}
}
