package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private By xExitLocator = By.cssSelector("a.x");

    public SearchResultsPage (WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 20);
    }

    public int findCouponsCode() throws IOException, UnsupportedFlavorException {
        List<WebElement> listCoupon = driver.findElements(couponCodeListLocator);
        wait.until(ExpectedConditions.visibilityOfAllElements(listCoupon));
        listCoupon.get(0).click();
        wait = new WebDriverWait(driver,20);
        changeTab();
        driver.findElement(copyButtonLocator).click();
        driver.findElement(xExitLocator).click();
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
