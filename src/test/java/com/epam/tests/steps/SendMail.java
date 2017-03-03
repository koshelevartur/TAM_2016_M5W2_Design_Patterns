package com.epam.tests.steps;

import com.epam.pages.drafts.DraftsPage;
import com.epam.pages.sent.SentPage;
import com.epam.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Artur_Koshelev.
 */
public class SendMail extends BaseTest {
    @DataProvider(name = "Email subject")
    private Object[][] emailSubject() {
        return new Object[][] {
                {getTestData().getEmailSubject()}
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Sending email from draft...");
    }

    @Parameters({"subject"})
    @Test(dependsOnMethods = "com.epam.tests.steps.CreateDraft.createDraft", dataProvider = "Email subject")
    public void sendEmail(String subject) {
        Assert.assertTrue(new DraftsPage(getDriver()).sendDraft(subject).openSentMailPage().isEmailSent(subject), "Email not sent!");
        System.out.println("Email successfully sent.");
    }

    @Parameters({"subject"})
    @Test(dependsOnMethods = "sendEmail", dataProvider = "Email subject")
    public void verifyDraftDeleted(String subject) {
        Assert.assertFalse(new SentPage(getDriver()).openDraftsPage().isDraftPresent(subject), "Draft not deleted!");
        System.out.println("Draft successfully deleted.");
    }
}
