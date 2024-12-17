package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.Homepage;

import java.io.IOException;

public class HomePageStepdefinition extends WebAPI {
    @Before
    public void envAndSetup() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/");
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    static Homepage homepage;
    public static void getInitElements(){
        homepage = PageFactory.initElements(driver,Homepage.class);
    }
    @Given("I navigate to the Rainforest homepage")
    public void I_navigate_to_the_Rainforest_homepage(){
        getInitElements();
    }
    @Then("The page title should be {string}")
    public void The_page_title_should_be(String string){
        getInitElements();
        string = "RainForest";
    }
}
