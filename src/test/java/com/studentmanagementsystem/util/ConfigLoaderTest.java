package test.java.com.studentmanagementsystem.util;

import main.java.com.studentmanagementsystem.util.ConfigLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConfigLoaderTest {

  private ConfigLoader configLoader;

  @BeforeEach
  public void setUp() {
    configLoader = ConfigLoader.getInstance();
  }

  @Test
  public void testGetPropertyExistingKey() {
    String value = configLoader.getProperty("db.url");
    assertEquals("jdbc:mysql://localhost:3306/stdmng", value);
  }

  @Test
  public void testGetPropertyNonExistingKey() {
    String value = configLoader.getProperty("non.existing.key");
    assertNull(value);
  }

  @Test
  public void testSingletonPattern() {
    ConfigLoader instance1 = ConfigLoader.getInstance();
    ConfigLoader instance2 = ConfigLoader.getInstance();
    assertEquals(instance1, instance2);
  }
}
