import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AmazonSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultsAreDisplayed() {
        driver.get("https://www.amazon.co.jp");

        // 検索ボックスを待って入力
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
        searchBox.sendKeys("Java");

        // 検索ボタンをクリック
        driver.findElement(By.id("nav-search-submit-button")).click();

        // 検索結果のリストが表示されるまで待つ
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-component-type='s-search-result']"))
        );

        // 検索結果の件数を取得
        List<WebElement> results = driver.findElements(By.cssSelector("[data-component-type='s-search-result']"));

        System.out.println("検索結果件数: " + results.size());

        // 結果が1件以上あること
        assertTrue(results.size() > 0, "検索結果が0件です");
    }

    @Test
    public void searchResultContainsKeyword() {
        driver.get("https://www.amazon.co.jp");

        // 検索ボックスが現れるまで最大10秒待つ
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
        searchBox.sendKeys("Java");

        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // 検索結果ページのタイトルを待つ
        wait.until(ExpectedConditions.titleContains("Java"));

        String title = driver.getTitle();
        System.out.println("ページタイトル: " + title);
        assertTrue(title.contains("Java"), "タイトルにJavaが含まれていません: " + title);
    }

    @Test
    public void searchBoxIsDisplayed() {
        driver.get("https://www.amazon.co.jp");

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );
        assertTrue(searchBox.isDisplayed(), "検索ボックスが表示されていません");
        System.out.println("検索ボックス確認OK");
    }
}