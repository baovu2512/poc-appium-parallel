package base;

import org.junit.BeforeClass;

import static configs.CustomDriver.getCap;
import static configs.CustomDriver.setCapability;

public class BaseTest {
    public static String fileName = "default.properties";

    @BeforeClass
    public static void setup() {
        if (getCap() == null) {
            System.out.println("vao if");
            setCapability(fileName);
        }
    }
}