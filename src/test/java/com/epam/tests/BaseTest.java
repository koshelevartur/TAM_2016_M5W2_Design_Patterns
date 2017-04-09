package com.epam.tests;

import com.epam.config.TestData;
import com.epam.utils.CustomDriverDecorator;
import com.epam.webdriver.DriverType;
import com.epam.webdriver.WebDriverSingleton;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

/**
 * Created by Artur_Koshelev.
 */
public class BaseTest {
    private static InheritableThreadLocal<TestData> testData = new InheritableThreadLocal<>();
    static {
        testData.set(new TestData());
    }

    @BeforeTest(alwaysRun = true)
    @Parameters({"os","browser"})
    public void startBrowser(@Optional ("Windows") String os,
                             @Optional ("Chrome") DriverType browser) throws MalformedURLException {
        DesiredCapabilities capabilities = browser.getCapabilities();
        if (os.equalsIgnoreCase("Windows")) {
            capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        }
        if(os.equalsIgnoreCase("Linux")) {
            capabilities.setCapability(CapabilityType.PLATFORM,Platform.LINUX);
        }
        WebDriverSingleton.getDriverInstance(capabilities);
        getDriver().get(TestData.LOGIN_PAGE);
    }

    protected WebDriver getDriver() {
        return new CustomDriverDecorator(WebDriverSingleton.getDriver());
    }

    protected TestData getTestData() {
        return testData.get();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        getDriver().close();
    }
}
