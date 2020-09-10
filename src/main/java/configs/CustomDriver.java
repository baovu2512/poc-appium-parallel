package configs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomDriver implements DriverSource {

    public static DesiredCapabilities getCap() {
        return cap.get();
    }

    public static ThreadLocal<DesiredCapabilities> cap = new ThreadLocal<>();

    public static void setCapability(String fileNames){
        DevicesManager devicesManager = new DevicesManager().getDeviceInformationFrom(fileNames);;
        CustomDriver.cap.set(CapabilityGenerate.withProperties(devicesManager));
    }

    @Override
    public AppiumDriver newDriver() {
        ServicesManager servicesManager = new ServicesManager();
        servicesManager.startAppiumServer();
        System.out.println("new "+"\n"+cap.get());
        if (cap != null) {
            try {

                return initDriver(servicesManager.getAppiumService(), cap.get());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("test");
                return null;
            }
        }else{
            return initDriver(servicesManager.getAppiumService(), cap.get());
        }
    }

    public synchronized AppiumDriver<AndroidElement> initDriver(AppiumDriverLocalService
                                                                        localService, DesiredCapabilities cap) {
        return new AppiumDriver<AndroidElement>(localService, cap);
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
