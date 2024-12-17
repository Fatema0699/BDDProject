package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.ShopPage;

import java.io.IOException;

public class ShopPageStepdefinition extends WebAPI {
    @Before
    public void envAndSetup() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/shop");
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    static ShopPage shopPage;
    public static void getInitElements(){
        shopPage = PageFactory.initElements(driver,ShopPage.class);
    }

}
