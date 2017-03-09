package com.epam.business_objects;

import org.testng.internal.collections.Pair;

/**
 * Created by Artur_Koshelev.
 */
public abstract class UserCreator {
    String login;
    String password;
    int testUserId;
    String userCredentialsFile = "src/test/resources/users/Users.json";

    public abstract Pair<String,String> FactoryMethod();
}

