package appium.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SamplesTest {

    @Test
    public void deveSerUmTesteDeTestes() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName", "emulator-5554");
//        capabilities.setCapability("browserName ", "Chrome");
//        capabilities.setCapability("autoWebviewTimeout", 5000);
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appPackage", "com.ctappium");
//        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/cebola/Dev/CursoAppium/src/main/resources/CTAppium-1-1.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@text='SeuBarriga Híbrido']")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> contextHandles = driver.getContextHandles();
        System.out.println(contextHandles);
        if (contextHandles.size() > 1)
            driver.context((String) contextHandles.toArray()[1]);

        driver.quit();
    }
}

