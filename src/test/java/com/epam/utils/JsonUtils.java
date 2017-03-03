package com.epam.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Artur_Koshelev.
 */
public class JsonUtils {
    public static String getJsonString(String fileName) throws IOException {
        String jsonString = "";
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((line = in.readLine()) != null) {
                jsonString = jsonString + line;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return jsonString;
    }
}
