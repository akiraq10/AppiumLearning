package src;

import com.google.common.reflect.ClassPath;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import src.Driver.Platform;

import java.io.IOException;
import java.util.*;

public class Main {
    @SuppressWarnings("UnstableApiUsage")
    public static void main(String[] args) throws IOException {
        // get all test classes
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testClasses = new ArrayList<>();

        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoNAme = info.getName();
//            System.out.println(classInfoNAme);
            boolean startWithTestDot = classInfoNAme.startsWith("src.test."); // lay tat cả class trong 'test' package
            boolean isBaseTestClass = classInfoNAme.startsWith("src.test.BaseTest"); // Check co phai BaseTest.class ko
            boolean isMainClass = classInfoNAme.startsWith("src.test.Main"); // check co phai Main.class ko

            //add class ko fai là Basetest.class and Main.class to testClass
            if (startWithTestDot && !isBaseTestClass && !isMainClass) {
                testClasses.add(info.load());
            }

        }
        System.out.println(testClasses);

        // Get platform
//        String platformName= System.getProperty("platform");
        String platformName = System.getenv("platform");
        if (platformName == null) {
            throw new IllegalArgumentException("[ERR] please provider platform via -Dplatform=");
        }

        try {
            Platform.valueOf(platformName);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] we don't support platform " + platformName + " , supported platform: " + Arrays.toString(Platform.values()));
        }

        // Devices under test
        List<String> iPhoneDeviceList = Arrays.asList("iPhone 12", "iPhone 13");
        List<String> androidDeviceList = Arrays.asList("android 12", "android 14", "android 16");
        List<String> deviceList = platformName.equalsIgnoreCase("ios") ? iPhoneDeviceList : androidDeviceList;

        // Assign test classes into devices
        final int testNumEachDevice = testClasses.size() / deviceList.size();
        Map<String, List<Class<?>>> desiredCaps = new HashMap<>();

        for (int deviceIndex = 0; deviceIndex < deviceList.size(); deviceIndex++) {
            int startIndex = deviceIndex * testNumEachDevice;
            boolean isTheLastDevice = deviceIndex == deviceList.size() - 1;
            int endIndex = isTheLastDevice ? testClasses.size() : (startIndex + testNumEachDevice);
            List<Class<?>> subTestList = testClasses.subList(startIndex, endIndex);
            desiredCaps.put(deviceList.get(deviceIndex), subTestList);

        }

        //build dynamic test suite
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("Regression");

        List<XmlTest> allTests = new ArrayList<>();
        for (String deviceName : desiredCaps.keySet()) {
            XmlTest test = new XmlTest(suite);
            test.setName(deviceName);
            List<XmlClass> xmlClasses = new ArrayList<>();
            List<Class<?>> dedicatedClasses = desiredCaps.get(deviceName);
            for (Class<?> dedicatedClass : dedicatedClasses) {
                xmlClasses.add(new XmlClass(dedicatedClass.getName()));

            }
            test.setXmlClasses(xmlClasses);
            test.addParameter("UUID", deviceName);
            test.addParameter("PLATFORM_NAME", platformName);
            test.addParameter("PLATFORM_VERSION", "15.1");
            allTests.add(test);

        }
        suite.setTests(allTests);
        suite.setParallel(XmlSuite.ParallelMode.METHODS);
        suite.setThreadCount(10);

        System.out.println(suite.toXml());

//        Add testSuite into suite list
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
//
//        //Invoke run method
        testNG.setXmlSuites(suites);
        testNG.run();


    }
}
