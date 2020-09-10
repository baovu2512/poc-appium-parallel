package configs;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

public class CapabilityGenerate {
    
    
    public static DesiredCapabilities withProperties(DevicesManager devicesManager){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PLATFORM_NAME, devicesManager.getPLATFORM());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, devicesManager.getPLATFORM_VERSION());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, devicesManager.getDEVICE_NAME());
        cap.setCapability(MobileCapabilityType.APP, devicesManager.getAPP_PATH());
        cap.setCapability("avd", devicesManager.getDEVICE_NAME());
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability("systemPort", devicesManager.getSYSTEM_PORT());
        cap.setCapability("appPackage", devicesManager.getAPP_PACKAGE());
        cap.setCapability("appWaitActivity",
                "com.todoist.activity.HomeActivity,com.todoist.activity.WelcomeActivity");
        cap.setCapability("appWaitDuration", 60000);
        cap.setCapability(MobileCapabilityType.NO_RESET, "false");
        cap.setCapability("automationName", "Appium");
        return cap;
    }
}
