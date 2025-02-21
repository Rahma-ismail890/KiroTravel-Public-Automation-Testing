package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingSummaryPage {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    private final By sendReruestBtn = By.xpath("//button[normalize-space()='Send Request']");
    private final By cancelBtn = By.xpath("//button[text()='Cancel']");
    private final By canceleMessage = By.xpath("//h2[normalize-space()='Cancellation Confirmation']");
    private final By yesCncelBtn = By.xpath("//button[normalize-space()='yes, cancel']");
    private final By requestBookingMessage = By.xpath("//h2[normalize-space()='taxi request has been sent successfully']");
    private final By BookBtn = By.xpath("//button[text()='Book']");
    private final By PaymentBtn = By.xpath("//button[text()='Payment']");
    private final By promoCode = By.xpath("//input[contains(@placeholder,'Enter Code')]");
    private final By invoice = By.id("invoice");
    private final By firstName = By.xpath("//input[@placeholder='First Name']");
    private final By lastName = By.xpath("//input[@placeholder='Last Name']");
    private final By address = By.xpath("//input[@placeholder='Address']");
    private final By invoiceRequestBtn = By.xpath("//button[normalize-space()='Send Request']");
    private final By confirmBookingMessageWithCardOnline = By.xpath("//h2[text()='Your reservation has been confirmed']");
    private final By confirmBookingMessage = By.xpath("//span[text()='Your reservation has been confirmed']");
    private final By invalidPromoCode = By.xpath("//div[.='Promo Code not found']");
    private final By validPromoCode = By.xpath("//div[.='Promo code applied successfully']");
    private final By okBtn = By.xpath("//button[text()='Ok']");
    private final By applyBtn = By.xpath("//button[text()='Apply']");
    private final By email = By.id("email");
    public BookingSummaryPage(WebDriver driver)
    {
        this.driver=driver;
         actions = new Actions(driver);
         wait=new WebDriverWait(driver, Duration.ofSeconds(30));

    }
    public enum buttons{
        SendRequest , Book , Payment
    }
    public void clickBtn(buttons Button)
    {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        if(Button==buttons.SendRequest) {
            wait.until(ExpectedConditions.elementToBeClickable(sendReruestBtn)).click();
        } else if (Button==buttons.Book) {
            wait.until(ExpectedConditions.elementToBeClickable(BookBtn)).click();
        } else if (Button==buttons.Payment) {
            wait.until(ExpectedConditions.elementToBeClickable(PaymentBtn)).click();
        }
    }

    public void setPromoCode(String code)
    {
        actions.sendKeys(Keys.DOWN).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoCode)).sendKeys(code);
        driver.findElement(applyBtn).click();
    }
    public void RequestInvoice (String Firstname , String Lastname, String Address)
    {
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        driver.findElement(invoice).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(Firstname);
        driver.findElement(lastName).sendKeys(Lastname);
        driver.findElement(address).sendKeys(Address);
        driver.findElement(invoiceRequestBtn).click();
    }
    public boolean isRequestBooking()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(requestBookingMessage)).isDisplayed();
    }
    public boolean isConfirmedReservationWithCardOnline()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBookingMessageWithCardOnline)).isDisplayed();
    }
    public boolean isConfirmedReservation()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmBookingMessage)).isDisplayed();
    }
    public boolean CancelBooking()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
        driver.findElement(yesCncelBtn).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(canceleMessage)).isDisplayed();

    }
    public boolean isPromoCodeInvalid()
    {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidPromoCode)).isDisplayed();
    }
    public boolean isPromoCodevalid()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(validPromoCode)).isDisplayed();
    }
    public void clickOKBtn()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(okBtn)).click();
        actions.sendKeys(Keys.PAGE_DOWN).pause(500).perform();
    }
}
