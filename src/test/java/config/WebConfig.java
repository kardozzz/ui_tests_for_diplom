
package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseURL")
    @DefaultValue("https://job.mts.ru")
    String getBaseUrl();

    @Key("remoteURL")
    String getRemoteUrl();

}

