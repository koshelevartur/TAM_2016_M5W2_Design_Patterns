package com.epam.webdriver;

import com.epam.capabilities.CapCreator;
import com.epam.capabilities.ChromeCapCreator;
import com.epam.capabilities.FirefoxCapCreator;
import com.epam.capabilities.IECapCreator;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Artur_Koshelev.
 */
public enum DriverType {
    CHROME(new ChromeCapCreator()),
    FIREFOX(new FirefoxCapCreator()),
    IE(new IECapCreator());

    DesiredCapabilities capabilities;

    DriverType(CapCreator capCreator) {
        this.capabilities = capCreator.FactoryMethod();
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }
}
