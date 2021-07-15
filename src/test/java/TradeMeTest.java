import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.ResultsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeMeTest {


    private WebDriver driver;
    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeAll
    private static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    private void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.tmsandbox.co.nz/");
        homePage = new HomePage(driver);
    }

    @AfterEach
    private void teardownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void checkGoldReturn() throws Exception{
        homePage.searchFor("gold");
        Thread.sleep(5000);
    }


    @Test
    public void goldNumberListings() throws Exception{
        resultsPage = homePage.searchFor("gold");
        Integer numberOfResults = resultsPage.getTotalCount();
        System.out.println("The number of results is: " + numberOfResults);

    }

    @Test
    public void goldCurrentPriceTopItem() throws Exception{
        homePage.searchFor("gold");
        WebElement price = driver.findElement(By.cssSelector("#SuperGridGallery_BucketList_ClassifiedPrice_listingClassifiedPriceAmountPoa"));
        System.out.println("The current price of the top item is: " + price.getText());
    }

    @Test
    public void goldClickOnListViewButton() throws Exception{
        homePage.searchFor("gold");
        WebElement clickListView = driver.findElement(By.cssSelector("#ListingViewBar_listViewTab_icon_a > img"));
        clickListView.click();
        Thread.sleep(5000);
    }

    @Test
    public void goldListTitlesOfTopTen() throws Exception{
        homePage.searchFor("gold");
        WebElement clickListView = driver.findElement(By.cssSelector("#ListingViewBar_listViewTab_icon_a > img"));
        clickListView.click();
        Thread.sleep(5000);
        for (int i = 1; i<=10; i++){
            WebElement title = driver.findElement(By.cssSelector("#mainContent > div.supergrid-overlord > div:nth-child("+ i +") > a > div > div.location-wrapper > div.info > div.title"));
            System.out.println("The title of listing number " + i + ": "+ title.getText());
        }
    }

    @Test
    public void checkGoldWithWait() throws Exception{
        homePage.searchFor("gold");

    }

    @Test
    public void checkGoldLowestBuyNow() throws Exception{
        homePage.searchFor("gold");
        Select select = new Select(driver.findElement(By.cssSelector("#listingTitleBarSelect")));
        select.selectByVisibleText("Lowest Buy Now");
        List<WebElement> prices = driver.findElements(By.cssSelector("#SuperGridGallery_BucketList_BidInfo_listingBidPrice"));
        // To be completed later lmao

    }


}

