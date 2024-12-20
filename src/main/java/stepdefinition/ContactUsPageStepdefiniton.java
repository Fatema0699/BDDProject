package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.ContactUsPage;

import java.io.IOException;

public class ContactUsPageStepdefiniton extends WebAPI {
    static ContactUsPage contactUsPage;

    @BeforeStep
    public static void getInitElements() {
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @After
    public void closeBrowser() {
        cleanUp();
    }

    @Given("I navigate to the Rainforest Contact page")
    public void I_navigate_to_the_Rainforest_Contact_page() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/contact.html");
    }

    @When("the user leaves the Name, Email, and Message fields empty")
    public void the_user_leaves_the_Name_Email_and_Message_fields_empty() {
        contactUsPage.enterName("");
        contactUsPage.enterEmail("");
        contactUsPage.enterMessage("");
    }

    @When("clicks on the Submit button")
    public void clicks_on_the_Submit_button() {
        contactUsPage.clickOnsubmitbutton();
    }

    @Then("I should see all required fields highlighted")
    public void i_should_see_all_required_fields_highlighted() {
        contactUsPage.EmptyContactnameCredAssertion();
        contactUsPage.EmptyEmailCredAssertion();
        contactUsPage.EmptyMessageCredAssertion();
    }

    @Then("the form should not be submitted")
    public void the_form_should_not_be_submitted() {
        contactUsPage.validateURLafterSubmitting();
    }



}
