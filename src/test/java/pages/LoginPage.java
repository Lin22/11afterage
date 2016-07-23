package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jv on 16/07/2016.
 */
public class LoginPage {
    private WebDriver driver;
	@FindBy(name="Login")
	private WebElement loginField;
	@FindBy(name="Password")
	private WebElement passwordField;
	@FindBy(name="Domain")
	private WebElement domainList;
	@FindBy(id="mailbox__auth__button")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AfterLoginPage login(String login, String domain, String password) {
        WebDriverWait myWait = new WebDriverWait(driver, 10);
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox__login")));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        new Select(domainList).selectByVisibleText(domain);
        loginButton.click();
        return new AfterLoginPage(driver);
    }

   }
