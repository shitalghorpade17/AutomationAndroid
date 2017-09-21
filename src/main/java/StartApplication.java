import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Forgeahead-Shital on 9/20/2017.
 */
public class StartApplication {

    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

//        File classpathRoot = new File(System.getProperty("user.dir"));
        //       File appDir = new File(classpathRoot, "/Apps/Amazon/");
        File app = new File("src/main/resources/", "Calculator.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability("deviceName", "Nexus 5X");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.android2.calculator3");
        capabilities.setCapability("appActivity", "com.xlythe.calculator.material.Theme.Orange");
        try {
            System.out.println("Hello");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            System.out.println("driver successful");
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
            Thread.sleep(10000);
            driver.quit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

