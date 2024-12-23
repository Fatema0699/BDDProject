package rainforestpage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Homepage extends WebAPI {
    @FindBy(how = How.XPATH, using = "/html/body/header/h1")
    public WebElement headerWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Home")
    public WebElement homeLinkWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Shop")
    public WebElement shopLinkWebelement;
    @FindBy(how = How.XPATH, using = "/html/body/nav/a[3]")
    public WebElement contactLinkWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Back To Home")
    public WebElement backToHomeWebelement;
    @FindBy(how = How.ID, using = "username")
    public WebElement usernameWebelement;
    @FindBy(how = How.ID, using = "password")
    public WebElement passwordWebElement;
    @FindBy(how = How.ID, using = "loginButton")
    public WebElement loginButtonWebElement;
    @FindBy(how = How.ID, using = "errorMessage")
    public WebElement loginErrorMessage;
    @FindBy(how = How.ID, using = "CancelButton")
    public WebElement cancelButtonWebelement;
    @FindBy(how = How.ID, using = "select")
    public WebElement dropdownOptionWebelement;
    @FindBy(how = How.ID, using = "dropdownResult")
    public WebElement dropdownResultValidationWebelement;
    @FindBy(how = How.ID, using = "radio1")
    public WebElement radioBtn1Webelement;
    @FindBy(how = How.ID, using = "radio2")
    public WebElement radiobtn2Webelement;
    @FindBy(how = How.ID, using = "radioResult")
    public WebElement radiobtnResultWebelement;
    @FindBy(how = How.ID, using = "checkbox1")
    public WebElement checkBox1Webelement;
    @FindBy(how = How.ID, using = "checkbox2")
    public WebElement checkBox2Webelement;
    @FindBy(how = How.ID, using = "checkboxResult")
    public WebElement checkboxResultWebelement;
    @FindBy(how = How.ID, using = "datePicker")
    public WebElement datePickerWebelement;
    @FindBy(how = How.ID, using = "dateResult")
    public WebElement datepickerResultWebelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/section[1]/table[1]/thead[1]/tr[1]/th[1]")
    public WebElement interactivetableColumn1Webelement;
    @FindBy(how = How.ID, using = "filter")
    public WebElement filterInteractivetableWebelement;

    //Action methods
    public void clickOnHomeLink() {
        homeLinkWebelement.click();
    }

    public void clickOnShopLink() {
        shopLinkWebelement.click();
    }

    public void clickOnContactLink() {
        contactLinkWebelement.click();
    }

    public void clickOnBack() {
        backToHomeWebelement.click();
    }

    public void newTabOpen() {
        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabs.get(1));
    }

    public void enterUsername(String username) {
        usernameWebelement.click();
        usernameWebelement.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordWebElement.click();
        passwordWebElement.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButtonWebElement.click();
    }

    public void clickOnCancelButton() {
        cancelButtonWebelement.click();
    }

    public void clickOnRadiobtn1() {
        radioBtn1Webelement.click();
    }

    public void clickOnRadiobtn2() {
        radiobtn2Webelement.click();
    }

    public void clickOnCheckbox1() {
        checkBox1Webelement.click();

    }

    public void clickOnCheckbox2() {
        checkBox2Webelement.click();
    }

    public void datePicker(String date) {
        datePickerWebelement.sendKeys(date);
    }

    public void interactiveCol1Click() {
        interactivetableColumn1Webelement.click();
    }

    public void filterInteractiveTable(String input) {
        filterInteractivetableWebelement.sendKeys(input);
    }

    //Validation and assertion
    public void verifyPageTitle() {
        String actual = driver.getTitle();
        String expected = "RainForest";
        assertEquals("Assertion failed", expected, actual);
    }

    public void validateHeader() {
        String actual = headerWebelement.getText();
        String expected = "RainForest";
        assertEquals("Assertion failed", expected, actual);
    }

    public void validatebacktohomelink(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validatehomelink(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validateshoplink(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validatecontactlink(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validUserCredAssertion() {
        String actual = driver.switchTo().alert().getText();
        String expected = "Login successful!";
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void EmptyUsernameCredAssertion() {
        String usernameValidationmsg = usernameWebelement.getAttribute("validationMessage");
        Assert.assertFalse(usernameValidationmsg.isEmpty());
    }

    public void EmptyPasswordCredAssertion() {
        String passwordValidation = passwordWebElement.getAttribute("validationMessage");
        Assert.assertFalse(passwordValidation.isEmpty());
    }

    public void invalidUserCredAssertion() {
        String actual = loginErrorMessage.getText();
        String expected = "Invalid username or password!";
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void clearOutFormvalidation() {
        Assert.assertTrue("Username field is not cleared.", usernameWebelement.getAttribute("value").isEmpty());
        Assert.assertTrue("Password field is not cleared.", passwordWebElement.getAttribute("value").isEmpty());
    }

    public void assertDropdownValueSelection() {
        Select dropdown = new Select(dropdownOptionWebelement); // Ensure this element is correctly located
        dropdown.selectByValue("Congo"); // Ensure "Congo" matches the value attribute in the dropdown
    }

    public void validatedropdownValue(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownResultValidationWebelement, expected));
        String actual = dropdownResultValidationWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void assertDynamicDropdownValueSelection(String item) {
        Select dropdown = new Select(dropdownOptionWebelement);
        dropdown.selectByValue(item);
    }

    public void validateDynamicdropdownValue(String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownResultValidationWebelement, expected));
        String actual = dropdownResultValidationWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void validateRadiobtn() {
        boolean selected = true;
        selected = radioBtn1Webelement.isSelected();
        System.out.println(selected);
        String actual = radiobtnResultWebelement.getText();
        String expected = "You selected: Jaguar";
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void validatemultipleRadiobtn(String expected) {
        boolean selected = true;
        selected = radioBtn1Webelement.isSelected();
        System.out.println(selected);
        String actual = radiobtnResultWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void validatemultipleCheckboxSelection(String expected) {
        String actual = checkboxResultWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void validateUnCheckedbox() {
        if (checkBox1Webelement.isSelected()) {
            clickOnCheckbox1();
        }
        if (checkBox2Webelement.isSelected()) {
            clickOnCheckbox2();
        }
    }

    public void validateUnCheckboxmessage(String expected) {
        String actual = checkboxResultWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void datePickerAssertion(String expected) {
        String actual = datepickerResultWebelement.getText();
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void validateSortedTableData() {
        List<WebElement> columnDataElements = driver.findElements(By.xpath("//*[@id=\"rainforestTable\"]/tbody/tr/td[1]"));

        // Extract text from the elements
        List<String> actualData = new ArrayList<>();
        for (WebElement element : columnDataElements) {
            actualData.add(element.getText());
        }
        // Create a copy of the data and sort it
        List<String> expectedData = new ArrayList<>(actualData);
        Collections.sort(expectedData);
        Assert.assertEquals("Assertion failed", expectedData, actualData);
    }
    public void validateFilterInteractiveTableData(String input){
        List<WebElement> rowsData = driver.findElements(By.xpath("//*[@id=\"rainforestTable\"]/tbody/tr"));
        // Extract text from the elements
        List<String> actualData = new ArrayList<>();
        for (WebElement element : rowsData) {
            String rowText = element.getText();
            if(rowText.contains(input)){
                Assert.assertTrue(true);
            }else {
                Assert.assertTrue(false);
            }
        }
    }


}
