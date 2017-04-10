package com.epam.config;

import com.epam.business_objects.RandomUserCreator;
import com.epam.business_objects.UserCreator;
import org.testng.internal.collections.Pair;

import java.util.UUID;

/**
 * Created by Artur_Koshelev.
 */
public class TestData {
    public static final String LOGIN_PAGE  = "https://gmail.com";
    private Pair<String,String> userCredentials;
    private String targetEmailAddress;
    private String emailSubject;
    private String emailBody;

    public TestData() {
        UserCreator userCreator = new RandomUserCreator();
        //UserCreator userCreator = new FirstUserCreator();
        userCredentials = userCreator.FactoryMethod();
        targetEmailAddress = "tam2016m4w3@yandex.ru";
        emailSubject = UUID.randomUUID().toString();
        emailBody = "WebDriver Test Body";
        printTestData();
    }

    public String getLogin() {
        return userCredentials.first();
    }

    public String getPassword() {
        return userCredentials.second();
    }

    public String getTargetEmailAddress() {
        return targetEmailAddress;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    private void printTestData() {
        System.out.println("Current test data:");
        System.out.println("Login: " + userCredentials.first());
        System.out.println("Password: " + userCredentials.second());
        System.out.println("Email subj: " + emailSubject);
        System.out.println();
    }
}