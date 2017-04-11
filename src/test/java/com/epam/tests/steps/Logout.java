package com.epam.tests.steps;

import com.epam.driver.DriverProvider;
import com.epam.pages.main.MainPage;
import com.epam.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Artur_Koshelev.
 */
public class Logout extends BaseTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Logging off...");
    }

    @Test(dependsOnMethods = "com.epam.tests.steps.Login.login", priority = 1)
    public void logout() {
        Assert.assertTrue(new MainPage(DriverProvider.getDriver()).logout().logoutIsCorrect(), "Logout error!");
        System.out.println("Logout was completed correctly.");
    }
}
