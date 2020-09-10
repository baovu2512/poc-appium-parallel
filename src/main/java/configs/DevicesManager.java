package configs;

import lombok.Getter;

import java.io.InputStream;
import java.util.Properties;

public class DevicesManager {
    private Properties data;

    //information about devices ANDROID||IOS
    @Getter
    private String PLATFORM;
    @Getter
    private String PLATFORM_VERSION;
    @Getter
    private String DEVICE_NAME;
    @Getter
    private String SYSTEM_PORT;
    @Getter
    private String APP_PATH;
    @Getter
    private String APP_PACKAGE;
    @Getter
    private boolean IS_REAL;

    public DevicesManager getDeviceInformationFrom(String resource) {
        InputStream is = DevicesManager.class.getResourceAsStream("/" + resource);
        data = new Properties();
        try {
            data.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        PLATFORM = data.getProperty("platformName");
        PLATFORM_VERSION = data.getProperty("platformVersion");
        DEVICE_NAME = data.getProperty("deviceName");
        SYSTEM_PORT = data.getProperty("systemPort");
        APP_PATH = System.getProperty("user.dir") + "/src/test/resources/apps/" + data.getProperty("app");
        APP_PACKAGE = data.getProperty("appPackage");
        IS_REAL = Boolean.parseBoolean(data.getProperty("isReal"));

        return this;
    }
}
