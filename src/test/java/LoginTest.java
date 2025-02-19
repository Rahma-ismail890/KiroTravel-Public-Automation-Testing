import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void ValidLogin()
    {
          homePage.clickSignInBtn();
          loginPage.login("rahmaalshrkawy890@gmail.com","1234567890");
        Assert.assertTrue(homePage.Islogin("rahmaalshrkawy890@gmail.com"));
    }
    @Test
    public void InvalidEmail()
    {
        homePage.clickSignInBtn();
        loginPage.login("rahmaalshrkawy0@gmail.com","1234567890");
        Assert.assertTrue(loginPage.UserNotFoundMessage());
    }
    @Test
    public void InvalidPassword()
    {
        homePage.clickSignInBtn();
        loginPage.login("rahmaalshrkawy890@gmail.com","12345890");
        Assert.assertTrue(loginPage.incorrectPassOrEmailMessage());
    }
    @Test
    public void EmptyEmail()
    {
        homePage.clickSignInBtn();
        loginPage.login("","12345890");
        Assert.assertTrue(loginPage.EmptyEmailMessage());
    }
    @Test
    public void EmptyPassword()
    {
        homePage.clickSignInBtn();
        loginPage.login("rahmaalshrkawy890@gmail.com","");
        Assert.assertTrue(loginPage.EmptyPassMessage());
    }
    @Test
    public void EmptyEmailPassword()
    {
        homePage.clickSignInBtn();
        loginPage.login("","");
        Assert.assertTrue(loginPage.EmptyEmailMessage());
        Assert.assertTrue(loginPage.EmptyPassMessage());
    }


}
