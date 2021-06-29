package com.co.belcorp.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class Browser implements DriverSource {


    @Before
    public void getScenarioInformation(Scenario scenario) {
        EnvironmentVariables env = WebDriverConfiguredEnvironment.getEnvironmentVariables();
        env.setProperty("build", scenario.getName());
    }

    @Override
    public WebDriver newDriver() {
        EnvironmentVariables env = WebDriverConfiguredEnvironment.getEnvironmentVariables();
        DesiredCapabilities options = new DesiredCapabilities();
        String downloadFilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\download";
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setCapability("browserName", "Chrome");
        options.setCapability("platform", "Windows 8.1");
        options.setCapability("version", "87.0");
        options.setCapability("resolutionl", "1366x768");
        options.setCapability("name", "First Test");
        options.setCapability("build", env.getProperty("build"));
        options.setCapability("network", "true");
        options.setCapability("visual", "true");
        options.setCapability("video", "true");
        options.setCapability("console", "true");
        try {
            return new RemoteWebDriver(new URL("https://elionavarrete:rwLlFCESHtobr8vm6iZ4qv4HgNln8bytli9P2L6Glx77cvqkDH@hub.lambdatest.com/wd/hub"), options);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
