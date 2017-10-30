package pageobjects;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends CommonAPI {


    @FindBy(how = How.CSS, using = "#nav-link-shopall")
    public static WebElement departmentsDropDown;

    @FindBy(how = How.XPATH, using = ".//*[@id='nav-link-accountList']/span[2]")
    public static WebElement accNlistsDropDown;

    @FindBy(how=How.XPATH, using= ".//*[@id='nav-flyout-ya-signin']/a/span")
    public static WebElement homeSignInBtn;

    @FindBy(how=How.XPATH,using = ".//*[@id='nav-flyout-shopAll']/div[2]/span[6]")
    public static WebElement fireTvSection;

    @FindBy(how=How.XPATH,using=".//*[@id='nav-flyout-shopAll']/div[3]/div[6]/div[1]/div/a[2]/span[1]")
    public static WebElement fireTvStick;

    @FindBy(how=How.ID,using ="twotabsearchtextbox")
    public static WebElement searchInput;

    @FindBy(how=How.XPATH,using=".//*[@id='nav-cart']")
    public static WebElement shoppingCart;

    @FindBy(how=How.ID, using="ap_email")
    public static WebElement emailInput;

    @FindBy(how= How.ID, using= "ap_password" )
    public static WebElement passInput;

    @FindBy(how=How.XPATH, using =".//*[@id='signInSubmit']")
    public static WebElement signInBtn;

//    @FindBy(how=How.XPATH, using = ".//*[@id='nav-flyout-ya-signin']/a/span")
//    public static WebElement homeSignInBtn;



    public void goToFireTvStick() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(departmentsDropDown).perform();
        Thread.sleep(500);
        act.moveToElement(fireTvSection).perform();
        Thread.sleep(500);
        fireTvStick.click();
    }
    public void signInFormAccNLists(){
        Actions act = new Actions(driver);
        act.moveToElement(accNlistsDropDown).perform();
        homeSignInBtn.click();
    }
    public void searchFor(String value){
        searchInput.sendKeys(value);
    }
    public void clickOnShoppingCart(){
        shoppingCart.click();
    }
    public void logInFromAccNLists(String email, String pass){
        signInFormAccNLists();
        emailInput.sendKeys(email);
        passInput.sendKeys(pass);
        signInBtn.click();

    }
}
