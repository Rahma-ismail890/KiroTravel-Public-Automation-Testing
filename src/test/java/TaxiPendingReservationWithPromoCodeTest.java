import Pages.BookingSummaryPage;
import Pages.PricingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxiPendingReservationWithPromoCodeTest extends LoginTest {
    @Test
    public void PendingReservationWithin2hWitValidaPromoCode() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","02:50AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservationFrom8pmTo8amWithValidaPromoCode() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","07:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From12amTo330amWithValidaPromoCode() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("D");
        Assert.assertTrue(bookingSummaryPage.isPromoCodevalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From12amTo330amWithInvalidaPromoCode() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.setPromoCode("R");
        Assert.assertTrue(bookingSummaryPage.isPromoCodeInvalid());
        bookingSummaryPage.clickOKBtn();
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
}
