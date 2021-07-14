import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeTest {


    private WebDriver driver;

    @BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz/");
    }

    @AfterEach
    private void teardownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void checkGoldReturn() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }


    @Test
    public void goldNumberListings() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        WebElement numberOfResults = driver.findElement(By.cssSelector("span#totalCount"));
        System.out.println("The number of results is: " + numberOfResults.getText());

    }

    @Test
    public void goldCurrentPriceTopItem() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        WebElement price = driver.findElement(By.cssSelector("#SuperGridGallery_BucketList_ClassifiedPrice_listingClassifiedPriceAmountPoa"));
        System.out.println("The current price of the top item is: " + price.getText());
    }

    @Test
    public void goldClickOnListViewButton() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        WebElement clickListView = driver.findElement(By.cssSelector("#ListingViewBar_listViewTab_icon_a > img"));
        clickListView.click();
        Thread.sleep(5000);
    }

    @Test
    public void goldListTitlesOfTopTen() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
        WebElement clickListView = driver.findElement(By.cssSelector("#ListingViewBar_listViewTab_icon_a > img"));
        clickListView.click();
        Thread.sleep(5000);
        for (int i = 1; i<=10; i++){
            WebElement title = driver.findElement(By.cssSelector("#mainContent > div.supergrid-overlord > div:nth-child("+ i +") > a > div > div.location-wrapper > div.info > div.title"));
            System.out.println("The title of listing number " + i + ": "+ title.getText());
        }
    }

    @Test
    public void checkGoldClickSearchWithWait() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        WebElement clickBox = driver.findElement(By.cssSelector("button.btn.btn-trademe"));
        clickBox.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-of-page > div.site-footer")));
    }

    @Test
    public void checkGoldSubmitFormLowestBuyNow() throws Exception{
        WebElement queryBox = driver.findElement(By.cssSelector("input#searchString.default-input.input-main-search.text.ac_input.LoNotSensitive"));
        queryBox.sendKeys("gold");
        queryBox.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-of-page > div.site-footer")));
        Select select = new Select(driver.findElement(By.cssSelector("#listingTitleBarSelect")));
        select.selectByVisibleText("Lowest Buy Now");
        List<WebElement> prices = driver.findElements(By.cssSelector("#SuperGridGallery_BucketList_BidInfo_listingBidPrice"));
        // To be completed later lmao

    }


}

