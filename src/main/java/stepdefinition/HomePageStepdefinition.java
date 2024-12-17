package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.Homepage;

import java.io.IOException;

public class HomePageStepdefinition extends WebAPI {
    @Before
    public void envAndSetup() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/");
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    static Homepage homepage;
    public static void getInitElements(){
        homepage = PageFactory.initElements(driver,Homepage.class);
    }
}
