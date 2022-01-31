package demo.autotests.config;

import org.aeonbits.owner.ConfigFactory;

public interface Environment {

    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
}
