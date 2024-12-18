package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.ShopPage;

import java.io.IOException;

public class ShopPageStepdefinition extends WebAPI {
    static ShopPage shopPage;

    @BeforeStep
    public static void getInitElements(){
        shopPage = PageFactory.initElements(driver,ShopPage.class);
    }

    @After
    public void closeBrowser(){
        cleanUp();
    }

    @Given("I navigate to the Shop page")
    public void i_navigate_to_the_Shop_page() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/shop");

    }
    @When("I click on Shop 1")
    public void i_click_on_Shop_1(){
        shopPage.clickOnShop1();
    }
    @Then("a new tab with URL {string} should open")
    public void a_new_tab_with_URL_should_open(String string) {
        string = "https://www.example1.com";
        shopPage.newTabOpen();
    }
    @When("I click on Shop 2")
    public void i_click_on_Shop_2(){
        shopPage.clickOnShop2();
    }
    @Then("again a new tab with URL {string} should open")
    public void again_a_new_tab_with_URL_should_open(String string) {
        string = "https://www.example2.com";
        shopPage.newTabOpen();
    }
}
