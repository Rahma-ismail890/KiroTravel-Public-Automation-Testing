package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By email = By.xpath("//input[@placeholder='Email']");
    private final By password = By.xpath("//input[@placeholder='Password']");
    private final By remeberMe = By.id("remember");
    private final By forgotEmail = By.xpath("//button[normalize-space()='Forgot Email?']");
    private final By forgotPassword = By.xpath("//button[text()='Forgot password?']");
    private final By signInBtn = By.cssSelector("button[type='submit']");
    private final By createAcount = By.xpath("//button[normalize-space()='Create Account']");
    private final By userNotFound = By.xpath("//p[text()='User not found']");
    private final By incorrectPassOrEmail =By.xpath("//p[text()='Password or email is incorrent.']");
    private final By emptypass = By.xpath("//span[text()='Password is required']");
    private final By emptyEmail=By.xpath("//span[text()='Email is required']");
public LoginPage(WebDriver driver)
{
    this.driver=driver;
    wait=new WebDriverWait(driver, Duration.ofSeconds(8));
}
public void login(String UserEmail , String Pass)
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(UserEmail);
    driver.findElement(password).sendKeys(Pass);
    driver.findElement(signInBtn).click();
}
public boolean UserNotFoundMessage()
{
    return wait.until(ExpectedConditions.visibilityOfElementLocated(userNotFound)).isDisplayed();
}
    public boolean incorrectPassOrEmailMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPassOrEmail)).isDisplayed();
    }
    public boolean EmptyEmailMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyEmail)).isDisplayed();
    }
    public boolean EmptyPassMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptypass)).isDisplayed();
    }
    public void clickForgotPasswordBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPassword)).click();
    }
    public void clickForgotEmailBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotEmail)).click();
    }
}
