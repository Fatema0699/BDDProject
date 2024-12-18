package rainforestpage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopPage extends WebAPI {
    //webelement for this page
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[1]") public WebElement shop1Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[2]") public WebElement shop2Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[3]") public WebElement shop3Webelement;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/button[4]") public WebElement shop4Webelement;

    //Action methods
    public void clickOnShop1(){
        shop1Webelement.click();
    }
    public void clickOnShop2(){
        shop2Webelement.click();
    }
    public void newTabOpen(){
        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabs.get(1));
        driver.switchTo().window(newTabs.get(0));
    }
    //validation and assertion
    public void validateNewTab(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "https://";
        assertEquals("The URL of the new tab does not match", expectedUrl, actualUrl);
    }

}
