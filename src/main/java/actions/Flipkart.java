package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.DriverFactory;

import java.time.Duration;

public class Flipkart {
    WebDriver driver;

    By flipkartLogo= By.xpath("//img[@title=\"Flipkart\"]");

    public Flipkart(WebDriver driver){
        this.driver= driver;
    }


    public void openFlipkartHomePage(){

        driver.get("https://www.flipkart.com");

    }


    public String getTitle(){
        return driver.getTitle();
    }

    public String logoIsDisplayed(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(flipkartLogo));
        System.out.println("FlipKart logo is displayed");
        return "Success";

    }



}
