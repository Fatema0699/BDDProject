package rainforestpage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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

    public void validatebacktohomelink() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/index.html";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validatehomelink() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/#";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validateshoplink() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/shop.html";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validatecontactlink() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/contact.html";
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

    public void validatedropdownValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownResultValidationWebelement, "You selected: Congo"));
        String actual = dropdownResultValidationWebelement.getText();
        String expected = "You selected: Congo";
        Assert.assertEquals("Assertion failed", expected, actual);
    }

    public void assertDynamicDropdownValueSelection() {
        Select dropdown = new Select(dropdownOptionWebelement);
        dropdown.selectByValue("Daintree"); // Ensure "Amazon" matches the value attribute in the dropdown
    }

    public void validateDynamicdropdownValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownResultValidationWebelement, "You selected: Daintree"));
        String actual = dropdownResultValidationWebelement.getText();
        String expected = "You selected: Daintree";
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
    public void validatemultipleRadiobtn() {
        boolean selected = true;
        selected = radioBtn1Webelement.isSelected();
        System.out.println(selected);
        String actual = radiobtnResultWebelement.getText();
        String expected = "You selected: Sloth";
        Assert.assertEquals("Assertion failed", expected, actual);
    }

}
