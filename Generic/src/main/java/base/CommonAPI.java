package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;

    private String saucelabs_username = "";
    private String saucelabs_accesskeys = "";
    private String browserstack_username = "";
    private String browserstack_accesskey = "";

    @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_version", "browser_name", "browser_version", "url"})
    @BeforeMethod
    public void setUp(boolean useCloudEnv,String cloudEnvName,String os, String os_version,
                      String browser_name,String browser_version,String url ) throws IOException {
        if(useCloudEnv==true){
            if(cloudEnvName.equalsIgnoreCase("browserstack")){
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,
                        os_version,browser_name,browser_version);
            }else if(cloudEnvName.equalsIgnoreCase("sauselabs")){
                getCloudDriver(cloudEnvName,saucelabs_username,saucelabs_accesskeys,os,
                        os_version,browser_name,browser_version);
            }
        }else{
            getLocalDriver(os,browser_name);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }
    public WebDriver getLocalDriver(String os,String browser_name){
        if(browser_name.equalsIgnoreCase("chrome")){
            if(os.contains("win")){
                System.setProperty("webdriver.chrome.driver","../Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
            }else if(os.contains("mac") || os.contains("os x")){
                System.setProperty("webdriver.chrome.driver","../Generic/driver/chromedriver");
                driver = new ChromeDriver();
            }
        }else if(browser_name.equalsIgnoreCase("firefox")){
            if(os.contains("win")){
                System.setProperty("webdriver.gecko.driver","../Generic/driver/geckodriver.exe");
                driver = new FirefoxDriver();
            }else if(os.contains("mac") || os.contains("os x")){
                System.setProperty("webdriver.gecko.driver","../Generic/driver/geckodriver");
                driver = new FirefoxDriver();
            }

        }
        return driver;
    }
    public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os,
                                    String os_version, String browser_name, String browser_version) throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browser_name);
        cap.setCapability("browser_version", browser_version);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if (envName.equalsIgnoreCase("Saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }



    @AfterMethod
    public void tearDown(){
        System.out.println("Session is over");
        driver.close();

    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeByXpathNEnter(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator) {
        String st = driver.findElement(By.id(locator)).getText();
        return st;
    }
    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
//    public List<String> getTextFromWebElements(String type, String locator) {
//        List<WebElement> element;
//        List<String> text = new ArrayList<>();
//        element = getElementList(type, locator);
//        for (WebElement we : element) {
//            text.add(we.getText());
//        }
//        return text;
//    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void navigateBack() {
        driver.navigate().back();
    }
    public void navigateForward() {
        driver.navigate().forward();
    }

    public void sleepFor(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }


}
