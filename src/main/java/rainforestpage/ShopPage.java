package rainforestpage;

import common.WebAPI;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopPage extends WebAPI {
    //webelement for this page
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[1]")
    public WebElement shop1Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[2]")
    public WebElement shop2Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[3]")
    public WebElement shop3Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[4]")
    public WebElement shop4Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[5]")
    public WebElement submitQueryWebelement;
    @FindBy(how = How.ID, using = "queryModal")
    public WebElement querymodalWebelement;
    @FindBy(how = How.CLASS_NAME, using = "close-btn")
    public WebElement querycloseButtonWebelement;
    @FindBy(how = How.XPATH, using = "//*[@id=\"queryModal\"]/div/textarea")
    public WebElement textareaWebelement;
    @FindBy(how = How.XPATH, using = "//*[@id=\"queryModal\"]/div/button")
    public WebElement querySubmitButtonWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Back To Home")
    public WebElement backToHomeWebelement;

    //Action methods
    public void clickOnShop1() {
        shop1Webelement.click();
    }

    public void clickOnShop2() {
        shop2Webelement.click();
    }

    public void newTabOpen() {
        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabs.get(1));
        driver.switchTo().window(newTabs.get(0));
    }

    public void clickOnShop3() {
        shop3Webelement.click();
    }

    public void clickOnShop4() {
        shop4Webelement.click();
    }

    public void clickOnSubmitaQuery() {
        submitQueryWebelement.click();
    }

    public void clickOnQueryClose() {
        querycloseButtonWebelement.click();
    }

    public void clickOnQuerySubmit() {
        querySubmitButtonWebelement.click();
    }

    public void clickOnBack() {
        backToHomeWebelement.click();
    }

    //validation and assertion
    public void validateNewTab() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

    public void validateAlertforShop3() {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "You are entering the Shop 3 shop!";
        assertEquals("Alert message is incorrect", expectedMessage, actualMessage);
        alert.accept();
    }

    public void validateAlertforShop4() {
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = "You are entering the Shop 4 shop!";
        assertEquals("Alert message is incorrect", expectedMessage, actualMessage);
        alert.accept();
    }

    public void validateQueryModalOpening() {
        Assert.assertTrue("Modal should be visible", querymodalWebelement.isDisplayed());
        Assert.assertTrue("Text area should be present in the modal", textareaWebelement.isDisplayed());
        Assert.assertTrue("Close button should be present in the modal", querycloseButtonWebelement.isDisplayed());
    }

    public void validateQueryModalClosing() {
        Assert.assertFalse("Modal should be closed", querymodalWebelement.isDisplayed());
    }

    public void validatebacktohomepage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://monsur26.github.io/mypage/index.html";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

}
