package rainforestpage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

}
