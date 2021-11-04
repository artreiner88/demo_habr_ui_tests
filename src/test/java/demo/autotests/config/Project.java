package demo.autotests.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
