package rainforestpage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class Homepage extends WebAPI {
    @FindBy(how = How.XPATH, using = "/html/body/header/h1") public WebElement headerWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Home")public  WebElement homeLinkWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Shop")public  WebElement shopLinkWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Contact")public  WebElement contactLinkWebelement;
    @FindBy(how = How.LINK_TEXT, using = "Back To Home")public  WebElement backToHomeWebelement;

    //Action methods
    public void clickOnHomeLink(){
        homeLinkWebelement.click();
    }
    public void clickOnShopLink(){
        shopLinkWebelement.click();
    }
    public void clickOnContactLink(){
        contactLinkWebelement.click();
    }
    public void clickOnBack(){
        backToHomeWebelement.click();
    }
//    public void newTabOpen(){
////        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(newTabs.get(1));
////        driver.switchTo().window(newTabs.get(0));
//    }

    //Validation and assertion
    public void verifyPageTitle() {
        String actual = driver.getTitle();
        String expected = "RainForest";
        assertEquals("Assertion failed",expected,actual);
    }
    public void validateHeader(){
        String actual = headerWebelement.getText();
        String expected= "RainForest";
        assertEquals("Assertion failed",expected,actual);
    }

    public void validatelink(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "https://";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }
}
