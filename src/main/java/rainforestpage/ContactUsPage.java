package rainforestpage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class ContactUsPage extends WebAPI {
    @FindBy(how = How.XPATH, using = "/html/body/nav/a[3]")
    public WebElement contactLinkWebelement;
    @FindBy(how = How.XPATH, using = "/html/body/form/input[3]")
    public WebElement contactSubmitWebelement;
    @FindBy(how = How.ID, using = "name")
    public WebElement contactNameWebelement;
    @FindBy(how = How.ID, using = "email")
    public WebElement contactEmailWebelement;
    @FindBy(how = How.ID, using = "message")
    public WebElement contactMessageWebelement;

    //Action methods

    public void clickOnsubmitbutton() {
        contactSubmitWebelement.click();
    }

    public void enterName(String name) {
        contactNameWebelement.click();
        contactNameWebelement.sendKeys(name);
    }

    public void enterEmail(String email) {
        contactNameWebelement.click();
        contactNameWebelement.sendKeys(email);
    }

    public void enterMessage(String message) {
        contactNameWebelement.click();
        contactNameWebelement.sendKeys(message);
    }


    //Validation and assertion

    public void EmptyContactnameCredAssertion() {
        String contactnameValidationmsg = contactNameWebelement.getAttribute("validationMessage");
        Assert.assertFalse(contactnameValidationmsg.isEmpty());
    }

    public void EmptyEmailCredAssertion() {
        String emailValidation = contactEmailWebelement.getAttribute("validationMessage");
        Assert.assertFalse(emailValidation.isEmpty());
    }

    public void EmptyMessageCredAssertion() {
        String messageValidation = contactMessageWebelement.getAttribute("validationMessage");
        Assert.assertFalse(messageValidation.isEmpty());
    }

    public void validateURLafterSubmitting() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/contact.html";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

}

