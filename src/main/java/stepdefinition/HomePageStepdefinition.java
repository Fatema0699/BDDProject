package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.Homepage;

import java.io.IOException;

public class HomePageStepdefinition extends WebAPI{
    static Homepage homepage;

    @BeforeStep
    public static void getInitElements(){
        homepage = PageFactory.initElements(driver,Homepage.class);
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    @Given("I navigate to the Rainforest homepage")
    public void I_navigate_to_the_Rainforest_homepage() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/");
    }
    @Then("The page title should be RainForest")
    public void The_page_title_should_be_RainForest(){
        homepage.verifyPageTitle();
    }
    @Then("The header should display RainForest")
    public void The_header_should_display_RainForest(){
       homepage.validateHeader();
    }
    @When("I click on the Home link")
    public void i_click_on_the_Home_link() {
       homepage.clickOnHomeLink();
    }
    @Then("I should be redirected to the homepage {string}")
    public void i_should_be_redirected_to_the_homepage(String string){
        string = "https://monsur26.github.io/mypage";
    }
    @When("I click on the Shop link")
    public void i_click_on_the_Shop_link() {
      homepage.clickOnShopLink();
    }
    @Then("I should be redirected to the shoppage {string}")
    public void i_should_be_redirected_to_the_shoppage(String string) {
        string = "https://monsur26.github.io/mypage/shop";
        homepage.clickOnBack();
    }
    @When("I click on the Contact link")
    public void i_click_on_the_Contact_link() {
      homepage.clickOnContactLink();
    }
    @Then("I should be redirected to the contactpage {string}")
    public void i_should_be_redirected_to_the_contactpage(String string) {
        string="https://monsur26.github.io/mypage/contact";
        homepage.clickOnBack();
    }
}
