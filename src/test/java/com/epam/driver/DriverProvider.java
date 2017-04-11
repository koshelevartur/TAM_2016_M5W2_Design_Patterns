package com.epam.driver;

import com.epam.utils.CustomDriverDecorator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Koshelev.
 */
public class DriverProvider {
    private static final int IMPLICIT_WAIT_TIMEOUT = 5;
    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();

    private DriverProvider() {
    }

    public static void createDriver(String os, DriverType browser) {
        if (driver.get() == null) {
            System.out.println("Creating new driver for " + browser + " on " + os);

            DesiredCapabilities capabilities = browser.getCapCreator().FactoryMethod();
            capabilities.setCapability(CapabilityType.PLATFORM, Platform.valueOf(os));

            driver.set(WebDriverPool.DEFAULT.getDriver(capabilities));
            driver.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public static WebDriver getDriver() {
        return new CustomDriverDecorator(driver.get());
    }
}