package demo.autotests.helpers;

import demo.autotests.config.Environment;
import demo.autotests.config.Project;

public class EnvironmentSettings {

    public static String getEnvironment() {

        String environment = System.getProperty("environment", "stage");
        System.setProperty("environment", environment);
        return Environment.environmentConfig.webUrl();
    }
}
