package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class BingTest {

    Browser browser;
    Page page;

    @BeforeEach
    public void before() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
        page = browser.newPage();
    }

    @Test
    @DisplayName("Search for Playwright")
    public void playwrightTest() {
        page.navigate("https://playwright.dev/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("playwright.png")));
    }

    @Test
    @DisplayName("Search for Bing")
    public void bingTest() {
        page.navigate("https://www.bing.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("bing.png")));
    }

    @AfterEach
    public void after() {
        browser.close();
    }
}
