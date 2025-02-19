package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {
WebDriver driver;
WebDriverWait wait;
Actions action;
    private final By sideMenu = By.cssSelector("span[class='text-[12px] flex gap-3'] span svg[fill='currentColor']");
    private final By signInBtn = By.xpath("//button[text()='Sign In']");
    private final By email = By.xpath("//span[@class='text-[12px] flex gap-3']");
    private final By pickup = By.id("departureLocation");
    private final By dropoff = By.id("arrivalLocation");
    private final By date = By.cssSelector("input[name='date']");
    private final By time = By.cssSelector("input[placeholder='Select time']");
    private final By passengersBtn = By.xpath("(//button[@type='button'][text()='Passengers'])[2]");
    private final By luggagesBtn = By.xpath("(//button[@type='button'][text()='Luggages'])[2]");
    private final By extraDataBtn =By.xpath("(//button[@type='button'][text()='Extra Data'])[2]");
    private final By vanBtn = By.xpath("//span[normalize-space()='Van']");
    private final By sedanBtn = By.xpath("//span[normalize-space()='sedan']");
    private final By passengerIncBtn = By.xpath("(//button[contains(@aria-label,'increment')])[4]");
    private final By getPassengerDecBtn = By.xpath("(//button[contains(@aria-label,'decrement')])[4]");
    private final By childrenIncBtn = By.xpath("(//button[contains(@aria-label,'increment')])[5]");
    private final By childrenDecBtn = By.xpath("(//button[contains(@aria-label,'decrement')])[5]");
    private final By viewPriceBtn = By.xpath("//button[normalize-space()='View Prices']");
    private final By autocompletList = By.xpath("//div[contains(@class,'pac-item')]");
    private final By timeErrorMessage = By.xpath("//span[contains(text(),'The time must be')]");

public HomePage(WebDriver driver)
{
   this.driver=driver;
   wait=new WebDriverWait(driver, Duration.ofSeconds(15));
   action = new Actions(driver);
   action.scrollByAmount(0,500).pause(300).perform();
}
public void clickSignInBtn()
{
   wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu)).click();
   wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn)).click();
}
public boolean Islogin (String userEmail)
{
   return wait.until(ExpectedConditions.textToBe(email,userEmail));

}
public boolean isTimeErrorMessageDisplayed()
{
    return wait.until(ExpectedConditions.visibilityOfElementLocated(timeErrorMessage)).isDisplayed();
}
public void TripDetails(String pickupAdd, String dropoffAdd , String Date , String Time , String carType , int passengernom)
{
   wait.until(ExpectedConditions.elementToBeClickable(pickup));
   WebElement  pick_up = driver.findElement(pickup);
   pick_up.sendKeys(pickupAdd);

       wait.until(ExpectedConditions.visibilityOfElementLocated(autocompletList));
       List<WebElement> list = driver.findElements(autocompletList);
       list.get(0).click();
  driver.findElement(dropoff).sendKeys(dropoffAdd);
    wait.until(ExpectedConditions.visibilityOfElementLocated(autocompletList));
    list = driver.findElements(autocompletList);
    list.get(0).click();
  driver.findElement(date).sendKeys(Date);
  driver.findElement(time).sendKeys(Time);
  for(int i=0;i<passengernom;i++)
  {
     driver.findElement(passengerIncBtn).click();
  }

  driver.findElement(viewPriceBtn).click();



}
}
