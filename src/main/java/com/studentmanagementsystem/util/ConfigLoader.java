package com.sm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static ConfigLoader instance;
    private Properties properties;

    // Private constructor to prevent direct instantiation
    private ConfigLoader() {
        try {
            // Load properties file
            InputStream input = new FileInputStream("src/resources/config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Singleton pattern to ensure only one instance of ConfigLoader
    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    // Method to get property by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
