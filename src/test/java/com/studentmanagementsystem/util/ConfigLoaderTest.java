package test.java.com.studentmanagementsystem.util;

import main.java.com.studentmanagementsystem.util.ConfigLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Properties;

public class ConfigLoaderTest {
  private ConfigLoader configLoader;
  private Properties properties;

  @Before
  public void setUp() {
    configLoader = ConfigLoader.getInstance();
    properties = configLoader.getProperties();
  }

  @Test
  public void testConfigLoader() {
    Assert.assertNotNull(properties);

    String url = properties.getProperty("db.url");
    Assert.assertEquals("jdbc:mysql://localhost:3306/student_management_system", url);

    String username = properties.getProperty("db.username");
    Assert.assertEquals("root", username);

    String password = properties.getProperty("db.password");
    Assert.assertEquals("password", password);
  }
}
