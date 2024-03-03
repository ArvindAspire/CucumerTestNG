package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DriverFactory;

import java.time.Duration;

public class Facebook {
    WebDriver driver;

    By facebookLogo= By.xpath("//img[@alt='Facebook']");

    public Facebook(WebDriver driver){
        this.driver= driver;
    }


    public void openFacebookHomePage(){
        driver.get("https://www.facebook.com");
    }


    public String getTitle(){
        return driver.getTitle();
    }

    public String logoIsDisplayed(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(facebookLogo));
        System.out.println("facebookLogo logo is displayed");
        return "Success";

    }

}
