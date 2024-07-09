package AppHooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import resources.ConfigReader;
import resources.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks extends DriverFactory{

 private DriverFactory driverFactory;
 private Properties properties;

 private ConfigReader configReader;

 private WebDriver driver;

    private ExtentReports extent;
    private ExtentTest test;

 @Before(order=0)
 public void getProperty()  {
     configReader= new ConfigReader();
     properties=configReader.init_prop();
     ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/report.html");
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
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



}
