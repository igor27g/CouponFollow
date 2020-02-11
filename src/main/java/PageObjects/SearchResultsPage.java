package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SearchResultsPage  extends BasePage{

    private WebDriverWait wait;

    private By couponCodeListLocator = By.cssSelector("div[class='deal-desc']>.cr");
    private By copyButtonLocator = By.cssSelector("button[id='copy-button']");

    public SearchResultsPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public SearchResultsPage goTo(String url) {
        driver.navigate().to(url);
        return new SearchResultsPage(driver);
    }

    public int findCoupons() throws IOException, UnsupportedFlavorException {
        List<WebElement> listCoupon = driver.findElements(couponCodeListLocator);
        listCoupon.get(0).click();
        changeTab();
        driver.findElement(copyButtonLocator).click();
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        return Integer.parseInt(myText);
    }

    private void changeTab() {
        Set<String> windows = driver.getWindowHandles();
        String parentWindow = driver.getWindowHandle();
        windows.remove(parentWindow);
        String secondWindow = windows.iterator().next();
        driver.switchTo().window(secondWindow);
    }



}
