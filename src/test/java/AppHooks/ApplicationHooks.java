package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import resources.ConfigReader;
import resources.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ApplicationHooks extends DriverFactory{

 private DriverFactory driverFactory;
 private Properties properties;

 private ConfigReader configReader;

 private WebDriver driver;

 @Before(order=0)
 public void getProperty()  {
     configReader= new ConfigReader();
     properties=configReader.init_prop();
 }

 @Before(order=1)
 public void  launchBrowser() throws Throwable {
     driverFactory = new DriverFactory();
     //String browser= properties.getProperty("browser");
     String browser= ConfigReader.getBrowserType();
     System.out.println("Browser is : "+browser);
     driverFactory.init_Browser(browser);

 }

 @After(order=0)
    public void quitBrowser(){

     getDriver().quit();
 }

    @After(order=1)
    public void addScreenshot(Scenario scenario) throws IOException {
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");

    }

    @AfterStep
    public void addScreenshotAfterFailedStep(Scenario scenario){

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }

    }


}
