package Tests;

import PageObjects.HomePage;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    String url = "https://couponfollow.com/";
    String brandName = "domino's Pizza";


    @Test
    public void findCouponBrandUsingSearch() {
        HomePage homePage = new HomePage(driver).goTo(url).writeBrandInSearch(brandName);
    }

//    HomePage homePage = new HomePage(driver)
}
