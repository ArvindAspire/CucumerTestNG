package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

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
           // driver= new ChromeDriver(chromeOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
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
           // driver= new EdgeDriver(edgeOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), edgeOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            tlDriver.set(driver);
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions= new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            //driver= new FirefoxDriver(firefoxOptions);
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            tlDriver.set(driver);
        }
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
