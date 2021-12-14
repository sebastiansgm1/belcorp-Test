package com.co.belcorp.hooks;

import static com.co.belcorp.utilities.Utils.getCurrentDateTime;

import com.co.belcorp.utilities.CsvUtilities;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser implements DriverSource {

  private static final String DEVICE_TYPE = "deviceType";
  private static final String DEVICE = "device";
  private static final String DESKTOP = "desktop";
  private static final String MOBILE = "mobile";
  private static final String BROWSER_NAME = "browserName";
  private static final String PLATFORM = "platform";
  private static final String VERSION = "version";
  private static final String RESOLUTION = "resolution";
  private static final String PLATFORM_NAME = "platformName";
  private static final String PLATFORM_VERSION = "platformVersion";
  private static final String DEVICE_NAME = "deviceName";
  private static final Logger LOGGER = LoggerFactory.getLogger(Browser.class);

  @Before
  public void getScenarioInformation(Scenario scenario) throws IOException {
    EnvironmentVariables env = WebDriverConfiguredEnvironment.getEnvironmentVariables();
    SerenityTags.create().tagScenarioWithBatchingInfo();
    Object[] tags = scenario.getSourceTagNames().toArray();
    for (Object tag : tags) {
      String strPlatform = tag.toString().trim().replace("@", "");
      if (strPlatform.contains(DEVICE)) {
        env.setProperty(DEVICE, strPlatform.replace("device=", ""));
        break;
      }
    }
    env.setProperty("build", scenario.getName());
  }

  @SneakyThrows
  @Override
  public WebDriver newDriver() {
    EnvironmentVariables env = WebDriverConfiguredEnvironment.getEnvironmentVariables();
    DesiredCapabilities options = new DesiredCapabilities();
    String downloadFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\download";
    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", downloadFilepath);
    options.setCapability("name", "Test " + getCurrentDateTime());
    options.setCapability("build", env.getProperty("build"));
    options.setCapability("network", "true");
    options.setCapability("visual", "true");
    options.setCapability("video", "true");
    options.setCapability("console", "true");
    Map<String, String> dataDevice =
        CsvUtilities.getMapTestData(DEVICE, env.getProperty(DEVICE));
    if (dataDevice.get(DEVICE_TYPE).equals(DESKTOP)) {
      options.setCapability(BROWSER_NAME, dataDevice.get(BROWSER_NAME));
      options.setCapability(PLATFORM, dataDevice.get(PLATFORM));
      options.setCapability(VERSION, dataDevice.get(VERSION));
      options.setCapability(RESOLUTION, dataDevice.get(RESOLUTION));
    } else if (dataDevice.get(DEVICE_TYPE).equals(MOBILE)) {
      options.setCapability(PLATFORM_NAME, dataDevice.get(PLATFORM_NAME));
      options.setCapability(DEVICE_NAME, dataDevice.get(DEVICE_NAME));
      options.setCapability(PLATFORM_VERSION, dataDevice.get(PLATFORM_VERSION));
    }
    try {
      return new RemoteWebDriver(new URL(
          "https://sebastiangaleano:zRA9Ejv9t3j4lwAwAsAJLLUyg4bZ6wQ7wPz8kMjbuZH4SYdIua@hub.lambdatest.com/wd/hub"),
          options);
    } catch (Exception e) {
      LOGGER.error("Error " + e);
      return null;
    }
  }

  @Override
  public boolean takesScreenshots() {
    return false;
  }
}

