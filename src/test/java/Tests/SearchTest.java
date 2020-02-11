package Tests;

import PageObjects.HomePage;
import org.junit.jupiter.api.Test;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {

    String brandName = "domino's Pizza";

    @Test
    public void findCouponBrandUsingSearch() throws IOException, UnsupportedFlavorException {
        HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
        int couponCode = homePage.writeBrandInSearch(brandName).findCoupons();
        assertEquals(Integer.parseInt(configuration.getCouponCode()), couponCode, "Wrong value of coupon code");
    }
}
