package Tests;

import PageObjects.BingPage;
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
    BingPage bing;

    @BeforeEach
    public void before() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));
        page = browser.newPage();
        bing = new BingPage();
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
        page.navigate(bing.getUrl());
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("bing.png")));
        page.click(bing.getSeachTextbox());
        page.locator(bing.getSeachTextbox()).fill("playwright");
        page.locator(bing.getSeachIcon()).click();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("searchresults.png")));
    }

    @AfterEach
    public void after() {
        browser.close();
    }
}
