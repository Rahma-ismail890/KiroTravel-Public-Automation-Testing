import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassEmailTest extends BaseTest {
    @Test
    public void ForgotPassInvalidPhone()
    {
        homePage.clickSignInBtn();
        loginPage.clickForgotPasswordBtn();
        forgotPasswordPage.setPhoneNumber(33,"1202488313");
        Assert.assertTrue(forgotPasswordPage.ErrorMessage());
    }
    @Test
    public void ForgotPassValidPhone()
    {
        homePage.clickSignInBtn();
        loginPage.clickForgotPasswordBtn();
        forgotPasswordPage.setPhoneNumber(20,"1202488313");
        Assert.assertTrue(forgotPasswordPage.SuccessMessage());
    }
    @Test
    public void ForgotEmailInvalidPhone()
    {
        homePage.clickSignInBtn();
        loginPage.clickForgotEmailBtn();
        forgotPasswordPage.setPhoneNumber(33,"1202488313");
        Assert.assertTrue(forgotPasswordPage.ErrorMessage());
    }
    @Test
    public void ForgotEmailValidPhone()
    {
        homePage.clickSignInBtn();
        loginPage.clickForgotEmailBtn();
        forgotPasswordPage.setPhoneNumber(20,"1202488313");
        Assert.assertTrue(forgotPasswordPage.reminderMessage());
    }
}
