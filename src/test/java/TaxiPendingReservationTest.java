
import Pages.BookingSummaryPage;
import Pages.PricingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxiPendingReservationTest extends LoginTest {

    @Test
    public void ReservationBeforeCurrentTime()
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/12/2025","11:54PM","sedan",3);
        Assert.assertTrue(homePage.isTimeErrorMessageDisplayed());
    }
    @Test
    public void PendingReservation1Within2h() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/13/2025","12:50AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation1From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/13/2025","12:31AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","07:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }

    @Test
    public void PendingReservation3From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","01:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation1From12amTo330am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","12:05AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2From12amTo330am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Cash, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation2Within2h() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/13/2025","12:50AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation4From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/13/2025","12:31AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation5From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","07:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }

    @Test
    public void PendingReservation6From8pmTo8am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/14/2025","01:55AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation3From12amTo330am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","12:05AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }
    @Test
    public void PendingReservation4From12amTo330am() //set the date equal the current date, currentTime+ 10m <time<currentTime+ 2h
    {
        ValidLogin();
        homePage.TripDetails("Geneva, Switzerlan","Gex la ville, Gex, France","02/17/2025","03:29AM","sedan",3);
        pricingPage.FexidPricing(PricingPage.paymentMethods.Card_onboard, PricingPage.CarType.Sedan);
        bookingSummaryPage.clickBtn(BookingSummaryPage.buttons.SendRequest);
        Assert.assertTrue(bookingSummaryPage.isRequestBooking());

    }


}
