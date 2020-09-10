package testsuites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testscripts.test;
import testscripts.testparallel;

import static configs.CustomDriver.setCapability;

@RunWith(Suite.class)
@Suite.SuiteClasses({testparallel.class})
public class RegressionTestSuite1 {

    @BeforeClass
    public static void regressionTestSuite() {
        System.out.println("second");
        setCapability("nexus4.properties");
    }
} 