package demo.autotests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})
public interface EnvironmentConfig extends Config {

    String webUrl();
    String apiUrl();
}
