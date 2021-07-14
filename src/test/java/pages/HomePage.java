package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ResultsPage;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage searchForGold() {
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        return new ResultsPage(driver);
    }
}
