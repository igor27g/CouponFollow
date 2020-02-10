package Tests;

import PageObjects.HomePage;
import PageObjects.SearchResultsPage;
import org.junit.jupiter.api.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class SearchTest extends BaseTest {

    String brandName = "domino's Pizza";

    @Test
    public void findCouponBrandUsingSearch() throws IOException, UnsupportedFlavorException {
       HomePage homePage = new HomePage(driver).goTo(configuration.getBaseUrl());
       SearchResultsPage searchResultsPage = homePage.writeBrandInSearch(configuration.getBrandName()).findCoupons();
    }
}
