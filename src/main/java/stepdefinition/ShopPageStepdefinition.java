package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
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
    public static void getInitElements() {
        shopPage = PageFactory.initElements(driver, ShopPage.class);
    }

    @After
    public void closeBrowser() {
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
    public void i_click_on_Shop_1() {
        shopPage.clickOnShop1();
    }

    @Then("a new tab with URL {string} should open")
    public void a_new_tab_with_URL_should_open(String string) {
        shopPage.newTabOpen();
        shopPage.validateNewTabShop1(string);
        shopPage.OldTabOpen();
    }


    @When("I click on Shop 2")
    public void i_click_on_Shop_2() {
        shopPage.clickOnShop2();
    }

    @Then("again a new tab with URL {string} should open")
    public void again_a_new_tab_with_URL_should_open(String string) {
        shopPage.AnotherTabOpen();
        shopPage.validateNewTabShop2(string);
    }

    @When("I click on Shop 3")
    public void i_click_on_Shop_3() {
        shopPage.clickOnShop3();
    }

    @Then("an alert for shop3 should display the message {string}")
    public void an_alert_for_shop3_should_display_the_message(String string) {
        shopPage.validateAlertforShop3(string);
    }

    @When("I click on Shop 4")
    public void i_click_on_Shop_4() {
        shopPage.clickOnShop4();
    }

    @Then("an alert for shop4 should display the message {string}")
    public void an_alert_for_shop4_should_display_the_message(String string) {
        shopPage.validateAlertforShop4(string);
    }

    @When("I click on Submit a query button")
    public void I_click_on_Submit_a_query_button() {
        shopPage.clickOnSubmitaQuery();
    }

    @Then("a modal appears with a text area and a Close button")
    public void a_modal_appears_with_a_text_area_and_a_Close_button() {
        shopPage.validateQueryModalOpening();
    }

    @When("I click on Submit a query button to open the modal")
    public void I_click_Submit_a_query_button_to_open_the_modal() {
        shopPage.clickOnSubmitaQuery();
    }

    @When("I click on Close button")
    public void i_click_on_Close_button() {
        shopPage.clickOnQueryClose();
    }

    @Then("the modal should close successfully")
    public void the_modal_should_close_successfully() {
        shopPage.validateQueryModalClosing();
    }

    @When("I click on Submit a query to reopen")
    public void i_click_on_Submit_a_query_to_reopen() {
        shopPage.clickOnSubmitaQuery();
    }

    @When("I click on Submit button")
    public void i_click_on_Submit_button() {
        shopPage.clickOnQuerySubmit();
    }

    @Then("the modal should close again successfully")
    public void the_modal_should_close_again_successfully() {
        shopPage.validateQueryModalClosing();
    }

    @When("I click on the Back to home link at the bottom of the shop page")
    public void I_click_on_the_Back_to_home_link_at_the_bottom_of_the_shop_page() {
        shopPage.clickOnBack();
    }

    @Then("I should redirected to the homepage {string}")
    public void I_should_redirected_to_the_homepage(String string) {
        shopPage.validatebacktohomepage(string);
    }

}
