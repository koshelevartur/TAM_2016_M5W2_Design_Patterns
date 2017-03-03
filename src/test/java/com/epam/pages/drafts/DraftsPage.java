package com.epam.pages.drafts;

import com.epam.pages.AbstractPage;
import com.epam.pages.sent.SentPage;
import org.openqa.selenium.NoSuchElementException;
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
public class DraftsPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'oL aDm az9')]/span")
    private WebElement toTextArea;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectTextArea;
    @FindBy(xpath = "//div[contains(@class,'Am Al editable LW-avf')]")
    private WebElement bodyTextArea;
    @FindBy(xpath = "//img[contains(@class, 'Ha')]")
    private WebElement closeButton;
    @FindBy(xpath = "//div[contains(@class,'T-I J-J5-Ji aoO T-I-atl L3')]")
    private WebElement sendButton;
    @FindBy(xpath = "//a[contains(@href,'#sent')]")
    private WebElement sentPageButton;
    @FindBys(@FindBy(xpath = "//td[contains(@class,'xY a4W')]/div[contains(@class,'xS')]/div[contains(@class,'xT')]/div[contains(@class,'y6')]/span[not(contains(@class,'y2'))]"))
    private List<WebElement> drafts;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void waitForPageLoading() {
        new WebDriverWait(driver, 10).pollingEvery(100, TimeUnit.MILLISECONDS).until(ExpectedConditions.urlContains("#drafts"));
    }

    private WebElement findDraft(String subject) {
        for (WebElement draft : drafts) {
            if (draft.getText().equals(subject) && draft.isDisplayed()) {
                return draft;
            }
        }
        return null;
    }

    public boolean isDraftPresent(String subject) {
        return findDraft(subject) != null;
    }

    public boolean isDraftCorrect(String to, String subject, String body) {
        WebElement draft = findDraft(subject);
        if (draft != null) {
            //highligtElement(driver,draft);
            try {
                draft.click();
                return toTextArea.getText().equals(to) &&
                        subjectTextArea.getAttribute("value").equals(subject) &&
                        bodyTextArea.getText().equals(body);
            } catch (NoSuchElementException e) {
                return false;
            } finally {
                closeButton.click();
            }
        } else {
            return false;
        }
    }

    public DraftsPage sendDraft(String subject) {
        WebElement draft = findDraft(subject);
        if (draft != null) {
            draft.click();
            sendButton.click();
        }
        return new DraftsPage(driver);
    }

    public SentPage openSentMailPage() {
        sentPageButton.click();
        return new SentPage(driver);
    }
}
