package com.epam.tests.steps;

import com.epam.config.TestData;
import com.epam.pages.signin.SignInPage;
import com.epam.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Artur_Koshelev.
 */
public class Login extends BaseTest {
    @DataProvider(name = "Authorization data")
    private Object[][] authorizationData() {
        return new Object[][] {
                {getTestData().getLogin(), getTestData().getPassword()}
        };
    }

    @BeforeClass
    public void openGmail() {
        getDriver().get(TestData.LOGIN_PAGE);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Logging in...");
    }

    @Parameters({"login","password"})
    @Test(dataProvider = "Authorization data")
    public void login(String login, String password) {
        Assert.assertTrue(new SignInPage(getDriver()).loginToGMail(login, password).loginIsCorrect(login), "Login error!");
        System.out.println("Login was completed correctly.");
    }
}