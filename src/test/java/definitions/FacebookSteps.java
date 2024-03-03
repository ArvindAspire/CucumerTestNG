package definitions;


import actions.Facebook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import resources.DriverFactory;


public class FacebookSteps  {

    Facebook facebook;

    public FacebookSteps(){
        facebook = new Facebook(DriverFactory.getDriver());
    }


    @Given("the user open the facebook browser")
    public void theUserOpenTheFacebookBrowser() {
        facebook.openFacebookHomePage();
    }

    @Then("the user verify the title of facebook page")
    public void theUserVerifyTheTitleOfFacebookPage() {
        Assert.assertEquals(facebook.getTitle(),"Facebook – log in or sign up");
    }

    @Then("the user verify the facebook logo")
    public void theUserVerifyTheFacebookLogo() {
        Assert.assertEquals(facebook.logoIsDisplayed(),"Success");
    }
}
