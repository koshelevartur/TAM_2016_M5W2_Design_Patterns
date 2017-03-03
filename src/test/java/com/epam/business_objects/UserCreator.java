package com.epam.business_objects;

import org.testng.internal.collections.Pair;

/**
 * Created by Artur_Koshelev.
 */
public abstract class UserCreator {
    //protected Pair<String,String> userCredentials;
    protected String login;
    protected String password;
    protected int testUserId;
    protected String userCredentialsFile = "src/test/resources/users/Users.json";

    public abstract Pair<String,String> FactoryMethod();
}

