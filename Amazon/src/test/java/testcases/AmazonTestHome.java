package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class AmazonTestHome extends CommonAPI{
    @Test
    public void testGoToFireStick() throws InterruptedException {
        HomePage  amazoneHome = PageFactory.initElements(driver, HomePage.class);
        amazoneHome.goToFireTvStick();


    }
    @Test
    public void testSignInFromAccNLists(){
        HomePage  amazoneHome = PageFactory.initElements(driver, HomePage.class);
        amazoneHome.signInFormAccNLists();
    }
    @Test
    public void testSearchFor(){
        HomePage  amazoneHome = PageFactory.initElements(driver, HomePage.class);
        amazoneHome.searchFor("Lord of rings");
    }
    @Test
    public void testClickOnShoppingCart(){
        HomePage  amazoneHome = PageFactory.initElements(driver, HomePage.class);
        amazoneHome.clickOnShoppingCart();

    }
    @Test
    public void testLogInFromAccNLists(){
        HomePage  amazoneHome = PageFactory.initElements(driver, HomePage.class);
        amazoneHome.logInFromAccNLists("jaman@gmail.com","abc123");

    }



}


