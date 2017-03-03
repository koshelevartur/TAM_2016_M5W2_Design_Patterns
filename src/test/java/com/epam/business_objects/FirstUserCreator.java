package com.epam.business_objects;

import com.epam.utils.JsonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.internal.collections.Pair;

/**
 * Created by Artur_Koshelev on 02.03.2017.
 */
public class FirstUserCreator extends UserCreator {
    @Override
    public Pair<String, String> FactoryMethod() {
        try {
            JSONArray users = new JSONObject(JsonUtils.getJsonString(userCredentialsFile)).getJSONArray("users");
            testUserId = 0;
            login = users.getJSONObject(testUserId).getString("login");
            password = users.getJSONObject(testUserId).getString("password");
        } catch (Exception e) {
            System.out.println("Incorrect users data!");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return Pair.create(login, password);
    }
}
