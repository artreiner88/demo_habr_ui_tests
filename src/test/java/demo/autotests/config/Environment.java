package demo.autotests.config;

import org.aeonbits.owner.ConfigFactory;

public class Environment {

    public static EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
}
