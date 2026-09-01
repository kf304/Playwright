package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductsTests extends BaseTest {

    @Test
    @DisplayName("Products page is displayed after login")
    void productsPageDisplayed() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        assertThat(productsPage.getPageTitle())
                .hasText("Products");
    }

    @Test
    @DisplayName("Products are displayed")
    void productsAreDisplayed() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        assertThat(productsPage.getProducts())
                .hasCount(6);
    }

    @Test
    @DisplayName("User can add product to cart")
    void addProductToCart() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        productsPage.addProductToCart(
                "Sauce Labs Backpack"
        );

        assertThat(productsPage.getCartIcon())
                .hasText("1");
    }
}