package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    private final By email = By.id("email");
    private final By card = By.xpath("//div[@class='AnimatePresence PaymentMethodFormVisible-container']");
    private final By card_number = By.id("cardNumber");
    private final By cardExpiry = By.id("cardExpiry");
    private final By cardCvc = By.id("cardCvc");
    private final By billingName = By.id("billingName");
   private final By bookingIframe = By.xpath("//iframe[@name='embedded-checkout']");
   private final By payment = By.xpath("//button[@type='submit']");
    public PaymentPage(WebDriver driver)
    {
        this.driver=driver;
        actions = new Actions(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void pay(String Email,String cardNumber,String CardExpiry, String CardCvc, String BillingName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookingIframe));

       driver.switchTo().frame(driver.findElement(bookingIframe));
       wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(card)).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(card_number)).sendKeys(cardNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardExpiry)).sendKeys(CardExpiry);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvc)).sendKeys(CardCvc);
        wait.until(ExpectedConditions.visibilityOfElementLocated(billingName)).sendKeys(BillingName);
        actions.scrollByAmount(0,500).pause(300).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(payment)).click();
    }

}
