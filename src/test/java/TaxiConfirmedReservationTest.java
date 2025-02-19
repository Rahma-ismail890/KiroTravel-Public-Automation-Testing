import Pages.BookingSummaryPage;
import Pages.PricingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxiConfirmedReservationTest extends LoginTest {
    @Test
    public void ConfirmedReservationWithCash()
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","09/14/2025","01:55PM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.Book);
        Assert.assertTrue(bookingSummaryPage.isConfirmedReservation());

    }
    @Test
    public void ConfirmedReservationWithCard_onboard()
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","08/14/2025","01:55PM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.Book);
        Assert.assertTrue(bookingSummaryPage.isConfirmedReservation());

    }
    @Test
    public void ConfirmedReservationWithCard_online()
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","08/16/2025","06:55PM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_online, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.Payment);
        paymentPage.pay("rahma@gmail.com","4242424242424242","03/33","342","rahma");
        Assert.assertTrue(bookingSummaryPage.isConfirmedReservationWithCardOnline());

    }
}

