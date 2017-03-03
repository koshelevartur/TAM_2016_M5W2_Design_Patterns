package com.epam.tests;

import com.epam.config.TestData;
import com.epam.utils.CustomDriverDecorator;
import com.epam.webdriver.WebDriverSingleton;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Koshelev.
 */
public class BaseTest {
    private static final String HUB_URL = "http://EPRUIZHW0273T1:4444/wd/hub";
    private static WebDriver driver;
    private static InheritableThreadLocal<TestData> testData = new InheritableThreadLocal<>();
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;

    @BeforeTest
    @Parameters({"os","browser"})
    public void startBrowser(String os, String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (os.equalsIgnoreCase("Windows")) {
            capabilities.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
        }
        if(os.equalsIgnoreCase("Linux")) {
            capabilities.setCapability(CapabilityType.PLATFORM,Platform.LINUX);
        }
        if(browser.equalsIgnoreCase("Chrome")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        }
        if(browser.equalsIgnoreCase("Firefox")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
        }
        if(browser.equalsIgnoreCase("Internet Explorer")) {
            capabilities.setCapability(CapabilityType.BROWSER_NAME,BrowserType.IE);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        }
        testData.set(new TestData());

        driver = WebDriverSingleton.getDriverInstance(capabilities);
        driver = new CustomDriverDecorator(driver);

        getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
        testData.get().printTestData();
        getDriver().get(TestData.LOGIN_PAGE);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected TestData getTestData() {
        return testData.get();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        getDriver().close();
    }
}
