package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage  extends BasePage{

    private WebDriverWait wait;

//    private By listArticle = By.cssSelector("div.content>section>article>div>div:nth-child(2)>div");
    private By coupon = By.cssSelector("div>a[data-func='showCode']");
    private By couponCode = By.cssSelector("div>span[class='coupon-code']");

    public SearchResultsPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 12);
    }


    public SearchResultsPage sayHello() {
        System.out.println("Hello");
        return new SearchResultsPage(driver);
    }




}
