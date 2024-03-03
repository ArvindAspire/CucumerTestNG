package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DriverFactory;

import java.time.Duration;

public class Google {
    WebDriver driver;

    By googleLogo= By.xpath("//img[@alt='Google']");

    public Google(WebDriver driver){
        this.driver= driver;
    }


    public void openGoogleHomePage(){
        driver.get("https://www.Google.com");
    }


    public String getTitle(){
        return driver.getTitle();
    }

    public String logoIsDisplayed(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(googleLogo));
        System.out.println("googleLogo logo is displayed");
        return "Success";

    }

}
