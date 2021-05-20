package com.co.belcorp.hooks;

import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class Browser implements DriverSource {

    @Override
    public WebDriver newDriver() {
        DesiredCapabilities options = new DesiredCapabilities();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        options.setCapability("browserName", "Chrome");
        options.setCapability("platform", "Windows 8.1");
        options.setCapability("version", "87.0");
        options.setCapability("resolutionl", "1024x768");
        options.setCapability("name", "First Test");
        options.setCapability("build", "Sample Test");
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
