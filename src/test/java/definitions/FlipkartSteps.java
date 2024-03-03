package definitions;

import actions.Flipkart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import resources.DriverFactory;


public class FlipkartSteps  {

    Flipkart flipkart;

    public FlipkartSteps(){
        flipkart = new Flipkart(DriverFactory.getDriver());
    }



    @Given("the user open the flipkart browser")
    public void theUserOpenTheFlipkartBrowser() {
        flipkart.openFlipkartHomePage();
    }

    @Then("the user verify the title of flipkart page")
    public void theUserVerifyTheTitleOfFlipkartPage() {
        Assert.assertEquals(flipkart.getTitle(),"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
    }


    @Then("the user verify the flipkart logo")
    public void theUserVerifyTheFlipkartLogo() {
        Assert.assertEquals(flipkart.logoIsDisplayed(),"Success");
    }
}
