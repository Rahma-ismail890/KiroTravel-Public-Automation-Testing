import DataReader.JsonReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SignUpTest extends BaseTest{
    @DataProvider(name="ValidRegistration")
    public Object[][] ReadValidRegistration()
    {
       return JsonReader.readJsonFile("RegisterTestData","ValidRegisterationData");
    }
    @Test(dataProvider ="ValidRegistration")
    public void testValidRegister(HashMap<String,String> registerData)
    {
        String name = registerData.get("userName");
        String email = System.currentTimeMillis() +registerData.get("Email");
        String code = registerData.get("code");
        String phone = registerData.get("phone");
        String pass = registerData.get("pass");
        String confirmPass = registerData.get("confirmPass");

        signUpPage.SignUp(name,email,code,phone,pass,confirmPass);
        Assert.assertTrue(signUpPage.verificationMessage());
    }
    @DataProvider(name="InvalidRegisterationData")
    public Object[][] ReadInvalidRegistration()
    {
        return JsonReader.readJsonFile("RegisterTestData","InvalidRegisterationData");
    }
    @Test(dataProvider ="InvalidRegisterationData")
    public void testInvalidRegister(HashMap<String,String> registerData)
    {
        String name = registerData.get("userName");
        String email = registerData.get("Email");
        String code = registerData.get("code");
        String phone = registerData.get("phone");
        String pass = registerData.get("pass");
        String confirmPass = registerData.get("confirmPass");
        String errorMessage= registerData.get("ExpectedErrorMessage");

        signUpPage.SignUp(name,email,code,phone,pass,confirmPass);
        Assert.assertTrue(signUpPage.ErrorMessage(errorMessage));
    }
}
