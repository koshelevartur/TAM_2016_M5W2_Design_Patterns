package com.epam.capabilities;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Artur_Koshelev.
 */
public class IECapCreator extends CapCreator {
    @Override
    public DesiredCapabilities FactoryMethod() {
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IE);
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        return capabilities;
    }
}
