package configs;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class ServicesManager {

    @Getter
    @Setter
    private AppiumDriverLocalService appiumService;

    public void startAppiumServer() {
        try {
            if (appiumService != null) {
                appiumService.stop();
            }
            AppiumServiceBuilder builder = new AppiumServiceBuilder();
            builder.withIPAddress("127.0.0.1");
            builder.usingAnyFreePort();
            builder.withLogFile(new File(System.getProperty("user.dir") + "/appiumLogs/" + System.currentTimeMillis() + ".text"));
            appiumService = AppiumDriverLocalService.buildService(builder);
            appiumService.clearOutPutStreams();
            appiumService.start();
            System.out.println("Appium server started at: - " + appiumService.getUrl());
            setAppiumService(appiumService);
            if (appiumService == null) {
                throw new AppiumServerHasNotBeenStartedLocallyException(
                        "An appium server node is not started!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopAppiumServer() {
        try {
            if (appiumService.isRunning()) {
                appiumService.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
