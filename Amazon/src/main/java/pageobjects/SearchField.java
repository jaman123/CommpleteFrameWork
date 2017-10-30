package pageobjects;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchField extends CommonAPI {
    @FindBy(how= How.ID,using ="twotabsearchtextbox")
    public static WebElement SearchInputText;
    @FindBy(how=How.CSS, using =".nav-input")
    public static WebElement searchBtn;

    public void enterInputText(String value, String value1) throws InterruptedException {
        SearchInputText.sendKeys(value);
        Thread.sleep(3000);
        searchBtn.click();
        Thread.sleep(3000);
        SearchInputText.sendKeys();
        SearchInputText.clear();
        Thread.sleep(3000);
        SearchInputText.sendKeys(value1);
        Thread.sleep(3000);
    }

}
