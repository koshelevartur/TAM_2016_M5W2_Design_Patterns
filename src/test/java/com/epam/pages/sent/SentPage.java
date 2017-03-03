package com.epam.pages.sent;

import com.epam.pages.AbstractPage;
import com.epam.pages.drafts.DraftsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Koshelev.
 */
public class SentPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@href,'#drafts')]")
    private WebElement draftsPageButton;
    @FindBys(@FindBy(xpath = "//td[contains(@class,'xY a4W')]/div[contains(@class,'xS')]/div[contains(@class,'xT')]/div[contains(@class,'y6')]/span[not(contains(@class,'y2'))]"))
    private List<WebElement> emails;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoading() {
        new WebDriverWait(driver, 10).pollingEvery(100, TimeUnit.MILLISECONDS).until(ExpectedConditions.urlContains("#sent"));
    }

    private WebElement findEmail(String subject) {
        for (WebElement email : emails) {
            if (email.getText().equals(subject) && email.isDisplayed()) {
                //highligtElement(driver,email);
                return email;
            }
        }
        return null;
    }

    public boolean isEmailSent(String subject) {
        return findEmail(subject) != null;
    }

    public DraftsPage openDraftsPage() {
        draftsPageButton.click();
        return new DraftsPage(driver);
    }
}
