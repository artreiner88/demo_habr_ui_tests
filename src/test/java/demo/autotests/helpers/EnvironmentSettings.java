package demo.autotests.helpers;

import demo.autotests.config.Environment;

public class EnvironmentSettings {

    public static String getEnvironmentUrl() {

        String environment = System.getProperty("environment", "stage");
        System.setProperty("environment", environment);
        return Environment.environmentConfig.webUrl();
    }
}
