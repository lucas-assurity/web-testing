package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
    private final WebDriver driver;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-of-page > div.site-footer")));
    }

    public String getTotalCount() {
        return driver.findElement(By.cssSelector("span#totalCount")).getText();
    }
}
