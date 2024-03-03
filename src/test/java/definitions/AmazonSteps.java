package definitions;

import actions.Amazon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.DriverFactory;


public class AmazonSteps {

    Amazon amazon ;

    WebDriver driver;

    public AmazonSteps(){
        amazon = new Amazon(this.driver=DriverFactory.getDriver());
    }


    @Given("the user open the amazon browser")
    public void theUserOpenTheAmazonBrowser() {
        amazon.openAmazonHomePage();
    }


    @Then("the user verify the title of amazon page")
    public void theUserVerifyTheTitleOfAmazonPage() {
        Assert.assertEquals(amazon.getTitle(),"Amazon.com. Spend less. Smile more.");
    }

    @Then("the user verify the amazon logo")
    public void theUserVerifyTheAmazonLogo() {
        Assert.assertEquals(amazon.logoIsDisplayed(),"Success");
    }
}
