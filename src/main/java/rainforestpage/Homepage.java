package rainforestpage;

import common.WebAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class Homepage extends WebAPI {
    @FindBy(how = How.XPATH, using = "/html/body/header/h1") public WebElement headerWebelement;

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
}
