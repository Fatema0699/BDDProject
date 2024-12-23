package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.Homepage;

import java.io.IOException;

public class HomePageStepdefinition extends WebAPI {
    static Homepage homepage;

    @BeforeStep
    public static void getInitElements() {
        homepage = PageFactory.initElements(driver, Homepage.class);
    }

    @After
    public void closeBrowser() {
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
    public void The_page_title_should_be_RainForest() {
        homepage.verifyPageTitle();
    }

    @Then("The header should display RainForest")
    public void The_header_should_display_RainForest() {
        homepage.validateHeader();
    }

    @When("I click on the Home link")
    public void i_click_on_the_Home_link() {
        homepage.clickOnHomeLink();
    }

    @Then("I should be redirected to the homepage {string}")
    public void i_should_be_redirected_to_the_homepage(String expectedUrl) {
        homepage.validatehomelink(expectedUrl);
    }

    @When("I click on the Shop link")
    public void i_click_on_the_Shop_link() {
        homepage.clickOnShopLink();
    }

    @Then("I should be redirected to the shoppage {string}")
    public void i_should_be_redirected_to_the_shoppage(String expectedUrl) {
        homepage.validateshoplink(expectedUrl);
    }

    @When("I click on the Back to home link")
    public void I_click_on_the_Back_to_home_link() {
        homepage.clickOnBack();
    }

    @Then("I should be back to the homepage {string}")
    public void I_should_be_back_to_the_homepage(String expectedUrl) {
        homepage.validatebacktohomelink(expectedUrl);
    }

    @When("I click on the Contact link")
    public void i_click_on_the_Contact_link() {
        homepage.clickOnContactLink();
    }

    @Then("I should be redirected to the contactpage {string}")
    public void i_should_be_redirected_to_the_contactpage(String expectedUrl) {
        homepage.newTabOpen();
        homepage.validatecontactlink(expectedUrl);
    }

    @When("User clicks and enters valid username on the username field")
    public void User_clicks_and_enters_valid_username_on_the_username_field() {
        homepage.enterUsername("Username1");
    }

    @When("User clicks and enters valid password on the password field")
    public void User_clicks_and_enter_valid_password_on_the_password_field() {
        homepage.enterPassword("Password1");
    }

    @When("User clicks on the Login button")
    public void User_clicks_on_the_Login_button() {
        homepage.clickOnLoginButton();
    }

    @Then("User is successfully logged in")
    public void User_is_successfully_logged_in() {
        homepage.validUserCredAssertion();
    }

    @When("the user leaves the username and password fields blank")
    public void the_user_leaves_the_username_and_password_fields_blank() {
        homepage.enterUsername("");
        homepage.enterPassword("");
    }

    @Then("the browser should highlight the required fields")
    public void the_browser_should_highlight_the_required_fields() {
        homepage.EmptyUsernameCredAssertion();
        homepage.EmptyPasswordCredAssertion();
    }

    @When("User clicks and enters invalid username on the username field")
    public void User_clicks_and_enters_invalid_username_on_the_username_field() {
        homepage.enterUsername("User");
    }

    @When("User clicks and enters invalid password on the password field")
    public void User_clicks_and_enter_invalid_password_on_the_password_field() {
        homepage.enterPassword("Pass");
    }

    @Then("User should see an Error message")
    public void User_should_see_an_Error_message() {
        homepage.invalidUserCredAssertion();
    }

    @When("User clicks and enters username on the username field")
    public void User_clicks_and_enters_username_on_the_username_field() {
        homepage.enterUsername("User");
    }

    @When("User clicks and enters password on the password field")
    public void User_clicks_and_enter_password_on_the_password_field() {
        homepage.enterPassword("Pass");
    }

    @When("User click on the Cancel button")
    public void User_click_on_the_Cancel_button() {
        homepage.clickOnCancelButton();
    }

    @Then("the fields should be clear out")
    public void the_fields_should_be_clear_out() {
        homepage.clearOutFormvalidation();
    }

    @When("I select Congo Rainforest from the dropdown")
    public void i_select_Congo_Rainforest_from_the_dropdown() {
        homepage.assertDropdownValueSelection();
    }

    @Then("I should see {string} displayed")
    public void i_should_see_displayed(String expected) {
        homepage.validatedropdownValue(expected);
    }

    //    @When("I select Amazon Rainforest  from the dropdown")
//    public void i_select_Amazon_Rainforest_from_the_dropdown() {
//        homepage.assertDynamicDropdownValueSelection();
//    }
//
//    @Then("I should see {string} displayed")
//    public void i_should_see_displayed(String string) {
//        string = "You selected: Amazon";
//        homepage.validatedynamicdropdownValue();
//    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String item) {
        homepage.assertDynamicDropdownValueSelection(item);
    }

    @Then("I should able to see {string} displayed")
    public void i_should_able_to_see_displayed(String expected) {
        homepage.validateDynamicdropdownValue(expected);
    }

    @When("I select the Jaguar radio button")
    public void I_select_the_Jaguar_radio_button() {
        homepage.clickOnRadiobtn1();
    }

    @Then("I should see You selected: Jaguar displayed")
    public void I_should_see_You_selected_Jaguar_displayed() {
        homepage.validateRadiobtn();
    }

    @When("I select Jaguar from the radio button section")
    public void i_select_Jaguar_from_the_radio_button_section() {
        homepage.clickOnRadiobtn1();
    }

    @Then("I should be able to see {string} displayed")
    public void i_should_be_able_to_see_displayed(String string) {
        homepage.validatemultipleRadiobtn(string);
    }

    @When("I select Sloth from the radio button section")
    public void i_select_Sloth_from_the_radio_button_section() {
        homepage.clickOnRadiobtn2();
    }

    @When("I select Medicinal Plants and Timber checkboxes")
    public void I_select_Medicinal_Plants_and_Timber_checkboxes() {
        homepage.clickOnCheckbox1();
        homepage.clickOnCheckbox2();
    }

    @Then("A valid message {string} should displayed")
    public void A_valid_message_should_displayed(String expected) {
        homepage.validatemultipleCheckboxSelection(expected);
    }

    @When("I deselect all checkboxes")
    public void I_deselect_all_checkboxes() {
        homepage.validateUnCheckedbox();
    }

    @Then("A message {string} should displayed")
    public void A_message_should_displayed(String expected) {
        homepage.validateUnCheckboxmessage(expected);
    }

    @When("I select {string} from the date picker")
    public void i_select_from_the_date_picker(String date) {
        homepage.datePicker(date);
    }

    @Then("I should see the {string}")
    public void I_should_see_the(String expected) {
        homepage.datePickerAssertion(expected);
    }

    @When("I click on the Rainforest Name column header")
    public void i_click_on_the_Rainforest_Name_column_header() {
       homepage.interactiveCol1Click();
    }

    @Then("the Rainforest Name column should be sorted alphabetically")
    public void the_Rainforest_Name_column_should_be_sorted_alphabetically() {
       homepage.validateSortedTableData();
    }

    @When("I type {string} in the filter input")
    public void i_type_in_the_filter_input(String input) {
        homepage.filterInteractiveTable(input);
    }

    @Then("only rows containing {string} should be displayed")
    public void only_rows_containing_should_be_displayed(String input) {
        homepage.validateFilterInteractiveTableData(input);
    }

}
