package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By phone = By.xpath("//input[@id='phone-2']");
    private final By submit = By.cssSelector("button[type='submit']");
    private final By errorMessage =By.xpath("//p[normalize-space()='This phone number does not exist']");
    private final By listBtn = By.xpath("//div[contains(@title,'France: + 33')]");
    private final By reminder = By.xpath("//span[normalize-space()='This is the email address of your Account']");
    private final By  successMessage = By.xpath("//span[normalize-space()='Reset password link has been sent to your email']");
    private final String countryCode ="//span[text()='+%d']";
    public ForgotPasswordPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
   public void setPhoneNumber(int code , String Phone)
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(listBtn)).click();
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(countryCode,code)))).click();
       driver.findElement(phone).sendKeys(Phone);
       driver.findElement(submit).click();
   }
   public boolean ErrorMessage()
   {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
   }
    public boolean reminderMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reminder)).isDisplayed();
    }
    public boolean SuccessMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
