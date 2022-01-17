package demo.autotests.config;

import org.aeonbits.owner.ConfigFactory;

public interface Credentials {
    CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
}
