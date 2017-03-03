package com.epam.pages.signin;

import com.epam.pages.AbstractPage;
import com.epam.pages.main.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Artur_Koshelev.
 */
public class SignInPage extends AbstractPage {
    @FindBy(id = "Email")
    private WebElement inputEmailField;
    @FindBy(id = "Passwd")
    private WebElement inputPasswordField;
    @FindBy(id = "next")
    private WebElement nextButton;
    @FindBy(id = "signIn")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginToGMail(String emailAddress, String password) {
        inputEmailField.sendKeys(emailAddress);
        nextButton.click();
        inputPasswordField.sendKeys(password);
        signInButton.click();
        return new MainPage(driver);
    }

    public boolean logoutIsCorrect() {
        try {
            return signInButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
