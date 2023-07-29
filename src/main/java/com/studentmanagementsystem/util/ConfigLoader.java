package main.java.com.studentmanagementsystem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The ConfigLoader class is a utility class that loads configuration properties
 * from a file.
 * It follows the Singleton pattern to ensure only one instance of ConfigLoader
 * is created.
 */
public class ConfigLoader {

  // Singleton instance
  private static ConfigLoader instance;

  // Properties to store configuration values
  private Properties properties;

  /**
   * Private constructor to prevent direct instantiation.
   * The properties file is loaded during object creation.
   */
  private ConfigLoader() {
    try {
      // Load properties file
      InputStream input = new FileInputStream("src/main/resources/config.properties");
      properties = new Properties();
      properties.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Gets the singleton instance of ConfigLoader.
   *
   * @return The singleton instance of ConfigLoader.
   */
  public static ConfigLoader getInstance() {
    if (instance == null) {
      instance = new ConfigLoader();
    }
    return instance;
  }

  /**
   * Retrieves the value of a configuration property based on the given key.
   *
   * @param key The key to look up the property.
   * @return The value of the configuration property, or null if the key is not
   *         found.
   */
  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
