package com.epam.capabilities;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Artur_Koshelev.
 */
public class FirefoxCapCreator extends CapCreator {
    @Override
    public DesiredCapabilities FactoryMethod() {
        FirefoxProfile profile = new FirefoxProfile();
        // this code fixes Firefox crash on driver.close()
        profile.setPreference("browser.tabs.remote.autostart.2", false);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return capabilities;
    }
}
