package com.epam.webdriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Created by Artur_Koshelev.
 */
public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {

    }

    public static WebDriver getDriverInstance(Capabilities capabilities) {
        if (driver == null) {
            driver = WebDriverPool.DEFAULT.getDriver(capabilities);
        }
        return driver;
    }
}
