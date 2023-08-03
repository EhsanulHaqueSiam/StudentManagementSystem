package main.java.com.studentmanagementsystem.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The `ConfigLoader` class is a utility that loads configuration properties from a file.
 * It follows the Singleton pattern to ensure only one instance of `ConfigLoader` is created.
 *
 * <p>Configuration properties are loaded from a properties file, providing a convenient way
 * to manage application-specific settings and parameters.
 *
 * <p>The Singleton pattern ensures that there is only one instance of `ConfigLoader` throughout
 * the application's lifecycle, promoting efficient resource utilization and centralization of
 * configuration data.
 */
public class ConfigLoader {

  // Singleton instance
  private static ConfigLoader instance;

  // Properties to store configuration values
  private Properties properties;

  /**
   * Private constructor to prevent direct instantiation.
   * The properties file is loaded during object creation.
   *
   * <p>This constructor initializes the `properties` instance variable by loading
   * configuration data from a properties file. Any IOException that occurs during
   * the loading process is caught and printed, ensuring graceful handling of errors.
   */
  private ConfigLoader() {
    try {
      // Load properties file
      InputStream input = new FileInputStream("src/main/resources/config.properties");
      properties = new Properties();
      properties.load(input);
    } catch (IOException ex) {
      // Print the exception stack trace, but the application continues functioning
      ex.printStackTrace();
    }
  }

  /**
   * Gets the singleton instance of `ConfigLoader`.
   *
   * @return The singleton instance of `ConfigLoader`.
   *
   * <p>This method implements the Singleton pattern by ensuring that only a single instance
   * of `ConfigLoader` is created and returned throughout the application's lifecycle. If no
   * instance exists, it creates one; otherwise, it returns the existing instance.
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
   * @return The value of the configuration property, or null if the key is not found.
   *
   * <p>This method retrieves the value of a configuration property using the provided key.
   * It allows other parts of the application to easily access configuration settings by
   * providing the corresponding key.
   */
  public String getProperty(String key) {
    return properties.getProperty(key);
  }
}
