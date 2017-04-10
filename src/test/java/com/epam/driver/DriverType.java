package com.epam.driver;

import com.epam.capabilities.CapCreator;
import com.epam.capabilities.ChromeCapCreator;
import com.epam.capabilities.FirefoxCapCreator;
import com.epam.capabilities.IECapCreator;

/**
 * Created by Artur_Koshelev.
 */
public enum DriverType {
    CHROME(new ChromeCapCreator()),
    FIREFOX(new FirefoxCapCreator()),
    IE(new IECapCreator());

    private CapCreator capCreator;

    DriverType(CapCreator capCreator) {
        this.capCreator = capCreator;
    }

    public CapCreator getCapCreator() {
        return this.capCreator;
    }
}
