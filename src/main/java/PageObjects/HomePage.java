package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends  BasePage{

    private WebDriverWait wait;
    Actions actions;

    private By searchSelector = By.cssSelector("input[class='searchField']");
    private By searchIcon = By.cssSelector("form[id='search']>button");
    private By listResult = By.cssSelector("ul[class='sug']>li>a");
    private By coupon = By.cssSelector("div>a[data-func='showCode']");
    private By couponCode = By.cssSelector("div>span[class='coupon-code']");

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 7);
    }

    public HomePage goTo(String url) {
        driver.navigate().to(url);
        return new HomePage(driver);
    }

    public HomePage writeBrandInSearch(String brandName) {
        WebElement searchSelectorElement = driver.findElement(searchSelector);
        slowType(searchSelectorElement,brandName);
        driver.findElement(listResult).click();

//        List<WebElement> listSearch = driver.findElements(listResult);
//        listSearch.get(0).getAttribute("href");
        return this;
    }

    public HomePage clickSearchIcon() {
        driver.findElement(searchIcon).click();
        return this;
    }


    private void slowType(WebElement element, String text) {
        for(int i =0; i<text.length(); i++) {
            element.sendKeys(Character.toString(text.charAt(i)));
        }
    }

//    public HomePage findCoupon() {
////        wait.until(ExpectedConditions.urlContains("https://couponfollow.com/site/dominos.com"));
////        List<WebElement> listCoupons =
////        wait.until(ExpectedConditions.elementToBeClickable(couponCode)).click();
////        String firstCouponText = driver.findElement(couponCode).getText();
////        System.out.println(firstCouponText);
////        return this;
//    }


}
