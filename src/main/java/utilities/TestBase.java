package utilities;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import utilities.ConfigurationReader;

public class TestBase {
    


        @BeforeTest
        public void setUp() throws Exception {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("version", "92.0");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("resolution","1024x768");
            capabilities.setCapability("build", "First Test");
            capabilities.setCapability("name", "Sample Test");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs

            try {
                String username = ConfigurationReader.get("username");
                String accessKey = ConfigurationReader.get("accessKey");
                RemoteWebDriver driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            }
              }
              
    }
        
    

