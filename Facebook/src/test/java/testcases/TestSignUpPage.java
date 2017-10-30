package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SignUpPage;

public class TestSignUpPage extends CommonAPI {
    @Test
    public void testSignUpPage() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.goToSignUpPage();
        sleepFor(4);
        SignUpPage fbSignUp = PageFactory.initElements(driver,SignUpPage.class);
        fbSignUp.signUpFB("David","john","msjamansarker@gmail.com","abc123","June","12","1982","male");

    }


}
