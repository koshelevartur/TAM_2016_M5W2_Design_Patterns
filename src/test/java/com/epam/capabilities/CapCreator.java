package com.epam.capabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Artur_Koshelev.
 */
public abstract class CapCreator {
    protected DesiredCapabilities capabilities;

    public abstract DesiredCapabilities FactoryMethod();
}
