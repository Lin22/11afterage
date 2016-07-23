package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by jv on 16/07/2016.
 */
public class LoginTest {
    LoginPage loginPage;
    WebDriver driver;
    String url = "http://mail.ru";


    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();

//        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        driver.get(url);

    }

    @Test
    public void login() throws Exception {

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
          loginPage.login("antfisher", "@mail.ru", "11321");
//        Assert.assertEquals();
    }
    @AfterClass
    public void closeAfter() {
        driver.close();
    }

}
