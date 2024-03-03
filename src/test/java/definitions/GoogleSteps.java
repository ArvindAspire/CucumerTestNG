package definitions;

import actions.Google;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import resources.DriverFactory;


public class GoogleSteps  {

    Google google;


   public GoogleSteps(){
        google = new Google(DriverFactory.getDriver());
   }




    @Given("the user open the google browser")
    public void theUserOpenTheGoogleBrowser() {
        google.openGoogleHomePage();
    }

    @Then("the user verify the title of google page")
    public void theUserVerifyTheTitleOfGooglePage() {
        Assert.assertEquals(google.getTitle(),"Google");
    }


    @Then("the user verify the google logo")
    public void theUserVerifyTheGoogleLogo() {
       Assert.assertEquals(google.logoIsDisplayed(),"Success");
    }
}
