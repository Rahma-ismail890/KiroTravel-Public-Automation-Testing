import Pages.BookingSummaryPage;
import Pages.PricingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxiPendingReservationWithPromoCodeTest extends LoginTest {
    @Test
    public void PendingReservationWithin2hWitValidaPromoCode() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France", dynamicDateAndTime.Date(0,0), dynamicDateAndTime.Time(1,0), "sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservationFrom8pmTo8amWithValidaPromoCode() //set the date equal the current date, 8pm <time< 11:59pm or tomorrow  12am=<time< 07:59am
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France", dynamicDateAndTime.Date(1,0), "07:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From12amTo330amWithValidaPromoCode() //set any future date, 12am <time<= 3:30am
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France", dynamicDateAndTime.Date(4,0), "03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From12amTo330amWithInvalidaPromoCode()//set any future date, 12am <time<= 3:30am
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France", dynamicDateAndTime.Date(4,9), "03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("R");
        Assert.assertTrue(bookingSummaryPage.isPromoCodeInvalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
}
