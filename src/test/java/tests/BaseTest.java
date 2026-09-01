package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.ProductsPage;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;

    @BeforeEach
    void setUp() {

        // Start Playwright
        playwright = Playwright.create();

        // Launch Chromium
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(true)
        );

        // Create a new browser page
        page = browser.newPage();

        // Create LoginPage object
        loginPage = new LoginPage(page);

        // Navigate to Swag Labs
        loginPage.navigateToLoginPage();
        productsPage = new ProductsPage(page);
    }

    @AfterEach
    void tearDown() {

        browser.close();
        playwright.close();
    }
}