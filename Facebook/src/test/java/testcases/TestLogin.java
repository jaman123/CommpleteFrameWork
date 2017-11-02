package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class TestLogin extends CommonAPI {
    @Test
    public void testLoginFB() throws InterruptedException {
        HomePage hp = PageFactory.initElements(driver, HomePage.class);
        hp.goToLoginPage();
        LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
        lp.loginFB("jaman_sh@hotmail.com", "shahjaman092015");
    }

//    @Test
    public void testForgotAcc() {
        LoginPage forgotAcc = PageFactory.initElements(driver, LoginPage.class);
        forgotAcc.forgotAcc();
    }
}