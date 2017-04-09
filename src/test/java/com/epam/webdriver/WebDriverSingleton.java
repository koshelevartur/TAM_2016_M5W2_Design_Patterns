package com.epam.webdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Koshelev.
 */
public class WebDriverSingleton {
    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;

    private WebDriverSingleton() {

    }

    public static void getDriverInstance(Capabilities capabilities) {
        if (driver == null) {
            driver.set(WebDriverPool.DEFAULT.getDriver(capabilities));
            driver.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}