package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.*;

public class RedBusTest extends BaseClass {

    @Test
    public void redbusFlow() throws Exception {

        driver.get("https://www.redbus.in");

        HomePage home = new HomePage(driver);
        SearchResultsPage search = new SearchResultsPage(driver);
        SeatSelectionPage seat = new SeatSelectionPage(driver);
        PassengerPage passenger = new PassengerPage(driver);
        PaymentPage payment = new PaymentPage(driver);

        home.enterFromCity();
        home.enterToCity();
        home.selectDate();
        home.clickSearch();

        Thread.sleep(3000);
        search.applyACFilter();
        search.clickFirstBusSeats();

        Thread.sleep(3000);
        seat.pickSeat();
        seat.chooseBoardingPoint1();
        //seat.clickContinue();
        seat.pickup1("Vytilla Jn");
        seat.chooseDroppingPoint("HOSUR");
        seat.clickContinue();

        passenger.fillPassengerDetails();
        passenger.selectState();
        passenger.personaldata();
        passenger.clickProceedToPay();
        payment.isPaymentPageLoaded();
        
        utils.ScreenshotUtil.takeScreenshot("RedBus_LastPage");


       // Assert.assertTrue(payment.isPaymentPageLoaded(), "Payment page not loaded!");
    }
}
