package testsuites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testscripts.test;

import static configs.CustomDriver.setCapability;

@RunWith(Suite.class)
@Suite.SuiteClasses({test.class})
public class RegressionTestSuite {

    @BeforeClass
    public static void regressionTestSuite() {
        System.out.println("first");
        setCapability("nexus6p.properties");
    }
} 