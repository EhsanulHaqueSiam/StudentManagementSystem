package main.java.com.studentmanagementsystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * The `ConfigLoader` class is a utility that loads configuration properties
 * from a file using Java NIO.
 * It follows the Singleton pattern to ensure only one instance of
 * `ConfigLoader` is created.
 */
public class ConfigLoader {

  private static volatile ConfigLoader instance;

  private Properties properties;

  /**
   * Private constructor to prevent direct instantiation.
   * The properties file is loaded during object creation.
   *
   * @param propertiesFilePath The path to the properties file.
   */
  private ConfigLoader(String propertiesFilePath) {
    properties = new Properties();
    Path path = Paths.get(propertiesFilePath);
    try {
      loadPropertiesFromFile(path);
    } catch (IOException ex) {
      // Graceful error handling
      ex.printStackTrace();
    }
  }

  /**
   * Loads properties from a file into the properties object.
   *
   * @param filePath The path to the properties file.
   * @throws IOException if an I/O error occurs while reading the file.
   */
  private void loadPropertiesFromFile(Path filePath) throws IOException {
    properties.clear(); // Clear existing properties
    try (InputStream input = Files.newInputStream(filePath)) {
      properties.load(input);
    }
  }

  /**
   * Gets the singleton instance of `ConfigLoader`.
   *
   * @param propertiesFilePath The path to the properties file.
   * @return The singleton instance of `ConfigLoader`.
   */
  public static ConfigLoader getInstance(String propertiesFilePath) {
    if (instance == null) {
      synchronized (ConfigLoader.class) {
        if (instance == null) {
          instance = new ConfigLoader(propertiesFilePath);
        }
      }
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
