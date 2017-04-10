package com.epam.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Artur_Koshelev.
 */
public abstract class CapCreator {
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public abstract DesiredCapabilities FactoryMethod();
}
