package stepdefinition;

import common.WebAPI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.PageFactory;
import rainforestpage.ContactUsPage;

import java.io.IOException;

public class ContactUsPageStepdefiniton extends WebAPI {
    @Before
    public void envAndSetup() throws IOException {
        setUp(false,
                "browserstack",
                "Windows", "11",
                "Edge", "131",
                "https://monsur26.github.io/mypage/contact");
    }
    @After
    public void closeBrowser(){
        cleanUp();
    }
    static ContactUsPage contactUsPage;
    public static void getInitElements(){
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }
}
