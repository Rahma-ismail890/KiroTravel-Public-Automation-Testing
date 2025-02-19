package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PricingPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By firstTripPriceList =By.xpath("//button[contains(@type,'button')]");
    private final By cash =By.id("cash");
    private final By card_onboard = By.id("card_onboard");
    private final By card_online = By.id("card_online");
    private final By submit = By.xpath("//button[normalize-space()='Submit']");
    private final By flexiblePriceInput =By.xpath("//input[@placeholder='Enter your desirable price']");
    private final By sendOfferBtn = By.xpath("//button[normalize-space()='Send Offer']");
    private final By flexibleCancelBtn = By.xpath("//button[normalize-space()='Send Offer']");
    private final By flexibleBtn = By.id("flexible");
    private final By selectPaymentMethod = By.id("swal2-html-container");
    private final By offerValidationError = By.xpath("//p[contains(@class,'text-danger-300')]");
    public enum paymentMethods {
        Cash,Card_onboard,Card_online
    };
    public enum CarType {
        Sedan , SedanEco, Van4_6,Van4_6Eco, Van7,Van8
    }
    public enum PricingSystem {
        fixed, flexible
    }
    public PricingPage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }
   public void SelectPaymentMethod(paymentMethods paymentMethod )
    {
        if(paymentMethod==paymentMethods.Cash)
        {
            wait.until(ExpectedConditions.elementToBeClickable(cash)).click();
        }
        else if (paymentMethod==paymentMethods.Card_onboard)
        {
            wait.until(ExpectedConditions.elementToBeClickable(card_onboard)).click();
        } else if (paymentMethod==paymentMethods.Card_online)
        {
            wait.until(ExpectedConditions.elementToBeClickable(card_online)).click();
        }
    }
    public void ClickSubmit()
    {
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }

    /**
     *
     * @param paymentMethod
     * @param carType
     */
    public void FexidPricing( paymentMethods paymentMethod   , CarType carType)
    {
        SelectPaymentMethod(paymentMethod);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstTripPriceList));
        List<WebElement> priceList = driver.findElements(firstTripPriceList);

            if (carType == CarType.SedanEco || carType == CarType.Van4_6Eco) {
                wait.until(ExpectedConditions.elementToBeClickable(priceList.get(0))).click();

            } else {
                if (priceList.size() == 2) {
                    wait.until(ExpectedConditions.elementToBeClickable(priceList.get(1))).click();
                } else {
                    wait.until(ExpectedConditions.elementToBeClickable(priceList.get(0))).click();
                }
            }

            ClickSubmit();

    }

    /**
     *
     * @param paymentMethod
     * @param carType
     * @param offerPrice
     */
    public void FlexiblePricing( paymentMethods paymentMethod   , CarType carType, int offerPrice)
    {
       wait.until(ExpectedConditions.elementToBeClickable(flexibleBtn));
       wait.until(ExpectedConditions.visibilityOfElementLocated(flexiblePriceInput)).sendKeys(String.valueOf(offerPrice));
        SelectPaymentMethod(paymentMethod);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendOfferBtn)).click();

    }
    public boolean OfferErrorMessage()
    {
      return wait.until(ExpectedConditions.visibilityOfElementLocated(offerValidationError)).isDisplayed();
    }

}
