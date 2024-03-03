package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DriverFactory;

import java.time.Duration;

public class Amazon {
    WebDriver driver;

    By amazonLogo= By.xpath("//a[@id='nav-logo-sprites']");

    public Amazon(WebDriver driver){
        this.driver= driver;
    }


    public void openAmazonHomePage(){
        driver.get("https://www.amazon.com");

    }


    public String getTitle(){
        return driver.getTitle();
    }

    public String logoIsDisplayed(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(amazonLogo));
        System.out.println("amazonLogo logo is displayed");
        return "Success";

    }

}
