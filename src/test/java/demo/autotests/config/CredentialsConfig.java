package demo.autotests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/credentials.properties"
})
public interface CredentialsConfig extends Config {
    String email();
    String notExistedEmail();
    String nickName();
    String password();
}
