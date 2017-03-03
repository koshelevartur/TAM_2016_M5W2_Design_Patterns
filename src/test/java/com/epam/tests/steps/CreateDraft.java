package com.epam.tests.steps;

import com.epam.pages.drafts.DraftsPage;
import com.epam.pages.main.MainPage;
import com.epam.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Artur_Koshelev.
 */
public class CreateDraft extends BaseTest {
    @DataProvider(name = "New email fields")
    private Object[][] newEmailFields() {
        return new Object[][] {
                {getTestData().getTargetEmailAddress(), getTestData().getEmailSubject(), getTestData().getEmailBody()}
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Creating new draft...");
    }

    @Parameters({"to", "subject", "body"})
    @Test(dependsOnMethods = {"com.epam.tests.steps.Login.login"}, dataProvider = "New email fields")
    public void createDraft(String to, String subject, String body) {
        Assert.assertTrue(new MainPage(getDriver()).createDraft(to, subject, body).openDraftsPage().isDraftPresent(subject), "Draft not created!");
        System.out.println("Draft successfully created.");
    }

    @Parameters({"to", "subject", "body"})
    @Test(dependsOnMethods = {"createDraft"}, dataProvider = "New email fields")
    public void verifyDraft(String to, String subject, String body) {
        Assert.assertTrue(new DraftsPage(getDriver()).isDraftCorrect(to, subject, body), "Draft is incorrect!");
        System.out.println("Draft is correct.");
    }
}
