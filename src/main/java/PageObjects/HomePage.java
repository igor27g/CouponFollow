package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends  BasePage{

    private WebDriverWait wait;

    private By searchSelectLocator = By.cssSelector("input[class='searchField']");
    private By searchIconLocator = By.cssSelector("form[id='search']>button");
    private By listResultLocator = By.cssSelector("ul[class='sug']>li>a");

    public HomePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 9);
    }

    public HomePage goTo(String url) {
        driver.navigate().to(url);
        return new HomePage(driver);
    }

    public SearchResultsPage findBrandInSearch(String brandName) {
        WebElement searchSelectorElement = driver.findElement(searchSelectLocator);
        slowType(searchSelectorElement, brandName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(listResultLocator)).click();
        return new SearchResultsPage(driver);
    }

    private void slowType(WebElement element, String text) {
        for(int i =0; i<text.length(); i++) {
            element.sendKeys(Character.toString(text.charAt(i)));
        }
    }

}
