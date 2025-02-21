package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

        WebDriver driver;
        WebDriverWait wait;
        private final By userNam= By.id("name");
        private final By email=By.id("email");
        private final By phone=By.xpath("//input[@name='phone']");
        private final By pass=By.id("password");
        private final By confirmPass =By.id("confirmPassword");
        private final By countryListBtn= By.xpath("//div[@class='selected-flag']");
        private final By signup = By.xpath("//span[normalize-space()='Sign Up']");
        private final By sideMenu = By.cssSelector("span[class='text-[12px] flex gap-3'] span svg[fill='currentColor']");
        private final By signUpBtn = By.cssSelector("button[type='submit']");
        private final By userNameEmpty = By.xpath("//div[contains(text(),'Name is required')]");
        private final By emailEmpty = By.xpath("//div[contains(text(),'email is required')]");
        private final By phoneEmpty = By.xpath("//div[text()='Phone number is required']");
        private final By passEmpty =By.xpath("//p[normalize-space()='password is required']");
        private final By confirmPassEmpty = By.xpath("//p[normalize-space()='confirmPassword is required']");
        private final By smallPass = By.xpath("//p[contains(text(),'Password must be 8-30 characters long and include ')]");
        private final By ConfirmPasscNotMatch = By.xpath("//p[normalize-space()='Passwords do not match']");
        private final By verificationMessage = By.xpath("//span[text()=' Mail Verification']");
        private final By emailExist = By.xpath("//p[contains(text(),'Email already exists')]");
        private final By phoneExist = By.xpath("//p[.='Phone number already exists']");
        private final  String countryCode = "//li/span[text()='+%s']";
        public SignUpPage(WebDriver driver)
        {
            this.driver=driver;
            wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        }
        private void setPhoneNumber(String code , String Phone)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(countryListBtn)).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(countryCode,code)))).click();
           wait.until(ExpectedConditions.visibilityOfElementLocated(phone)).sendKeys(Phone);

        }
        public void SignUp (String Name , String Email,String code , String Phone,String password, String confirmPassword)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(signup)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(userNam)).sendKeys(Name);
            driver.findElement(email).sendKeys(Email);
            setPhoneNumber(code,Phone);
            driver.findElement(pass).sendKeys(password);
            driver.findElement(confirmPass).sendKeys(confirmPassword);
            driver.findElement(signUpBtn).click();

        }
        public boolean EmptyName ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(userNameEmpty)).isDisplayed();
        }
        public boolean EmptyEmail ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailEmpty)).isDisplayed();
        }
        public boolean EmptyPhone ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneEmpty)).isDisplayed();
        }
        public boolean EmptyPass ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(passEmpty)).isDisplayed();
        }
        public boolean EmptyConfirmPassword ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassEmpty)).isDisplayed();
        }
        public boolean EmailExist ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailExist)).isDisplayed();
        }
        public boolean PhoneExist ()
        {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneExist)).isDisplayed();
        }
    public boolean verificationMessage ()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(verificationMessage)).isDisplayed();
    }
    public boolean ErrorMessage (String ErrorMessage)
    {
       // System.out.println(driver.findElement(By.xpath(errorMessage)).getText());
        By error = By.xpath(ErrorMessage);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).isDisplayed();
    }

    }


