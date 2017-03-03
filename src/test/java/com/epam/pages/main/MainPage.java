package com.epam.pages.main;

import com.epam.pages.AbstractPage;
import com.epam.pages.drafts.DraftsPage;
import com.epam.pages.signin.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artur_Koshelev.
 */
public class MainPage extends AbstractPage {
    @FindBy(xpath = "//a[contains(@class,'gb_b gb_eb gb_R')]")
    private WebElement headerProfileButton;
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/Logout?')]")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement newEmailButton;
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement toTextArea;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectTextArea;
    @FindBy(xpath = "//div[contains(@class,'Am Al editable LW-avf')]")
    private WebElement bodyTextArea;
    @FindBy(xpath = "//img[contains(@class, 'Ha')]")
    private WebElement closeButton;
    @FindBy(xpath = "//a[contains(@href,'#drafts')]")
    private WebElement draftsPageButton;
    @FindBy(xpath = "//span[contains(@class, 'gb_0a gb_5b')]")
    private WebElement headerButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean loginIsCorrect(String login) {
        try {
            new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains(login));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public SignInPage logout() {
        headerProfileButton.click();
        logoutButton.click();
        return new SignInPage(driver);
    }

    public MainPage createDraft(String targetEmail, String subject, String body) {
        newEmailButton.click();
        toTextArea.sendKeys(targetEmail);
        bodyTextArea.click();
        bodyTextArea.sendKeys(body);
        subjectTextArea.sendKeys(subject);
        closeButton.click();
        headerButton.click();
        return new MainPage(driver);
    }

    public DraftsPage openDraftsPage() {
        draftsPageButton.click();
        return new DraftsPage(driver);
    }
}
