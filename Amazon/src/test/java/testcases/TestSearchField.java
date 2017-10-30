package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobjects.SearchField;

public class TestSearchField extends CommonAPI{
    @Test
    public void testSearchBox() throws InterruptedException {
        SearchField searchField = PageFactory.initElements(driver, SearchField.class);
        searchField.enterInputText("Java Books", "Selenium");
    }

}

