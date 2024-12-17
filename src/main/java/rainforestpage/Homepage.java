package rainforestpage;

import common.WebAPI;

import static org.junit.Assert.assertEquals;

public class Homepage extends WebAPI {

    //Validation and assertion
    public void verifyPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "RainForest";
        assertEquals("Assertion failed",expectedTitle,actualTitle);
    }
}
