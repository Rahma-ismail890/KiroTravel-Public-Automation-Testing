import ConfigFiles.EnvironmentVariables;
import DataReader.DynamicDateAndTime;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
   WebDriver driver;
   HomePage homePage;
   LoginPage loginPage;
   ForgotPasswordPage forgotPasswordPage;
   PricingPage pricingPage;
   BookingSummaryPage bookingSummaryPage;
   EnvironmentVariables environmentVariables;
   PaymentPage paymentPage;
   SignUpPage signUpPage;
   DynamicDateAndTime dynamicDateAndTime;

   @BeforeMethod
   public void Setup()
   {
       driver=new ChromeDriver();
       driver.get(environmentVariables.ProductionURL);
       driver.manage().window().maximize();
       homePage = new HomePage(driver);
       loginPage= new LoginPage(driver);
       forgotPasswordPage = new ForgotPasswordPage(driver);
       pricingPage =new PricingPage(driver);
       bookingSummaryPage = new BookingSummaryPage(driver);
       signUpPage = new SignUpPage(driver);
       paymentPage = new PaymentPage(driver);
       dynamicDateAndTime=new DynamicDateAndTime(driver);
   }
   @AfterMethod
   public void threadDown()
   {

        driver.quit();
   }
}
