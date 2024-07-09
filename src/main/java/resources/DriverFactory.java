package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public WebDriver driver;

    private static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();

    public void init_Browser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--incognito");
           // driver= new ChromeDriver(chromeOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://ec2-13-201-89-73.ap-south-1.compute.amazonaws.com:4444/wd/hub"), chromeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            tlDriver.set(driver);
            System.out.println(Thread.currentThread().getId());
        }

        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions= new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            edgeOptions.addArguments("--incognito");
           // driver= new EdgeDriver(edgeOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://ec2-13-201-89-73.ap-south-1.compute.amazonaws.com:4444/wd/hub"), edgeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            tlDriver.set(driver);
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions= new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            firefoxOptions.addArguments("--incognito");
            //driver= new FirefoxDriver(firefoxOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://ec2-13-201-89-73.ap-south-1.compute.amazonaws.com:4444/wd/hub"), firefoxOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            tlDriver.set(driver);
        }
    }

    public void takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./failed_tests/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
