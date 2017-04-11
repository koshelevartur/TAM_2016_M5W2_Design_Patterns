package com.epam.tests;

import com.epam.config.TestData;
import com.epam.driver.DriverProvider;
import com.epam.driver.DriverType;
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

    @BeforeTest(alwaysRun = true)
    @Parameters({"os","browser"})
    public void setUp(@Optional ("Windows") String os,
                      @Optional ("Chrome") DriverType browser) throws MalformedURLException {
        DriverProvider.createDriver(os, browser);
        testData.set(new TestData());
    }

    protected TestData getTestData() {
        return testData.get();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverProvider.getDriver().quit();
    }
}
