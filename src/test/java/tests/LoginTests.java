package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("User can login with valid credentials")
    void validLogin() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        assertThat(page).hasURL(
                "https://www.saucedemo.com/inventory.html"
        );

        assertThat(
                page.locator(".title")
        ).hasText("Products");
    }

    @Test
    @DisplayName("User cannot login with invalid username")
    void invalidUsername() {

        loginPage.login(
                TestData.INVALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        assertThat(
                loginPage.getErrorMessage()
        ).isVisible();

        assertThat(
                loginPage.getErrorMessage()
        ).containsText(
                "Username and password do not match"
        );
    }

    @Test
    @DisplayName("User cannot login with invalid password")
    void invalidPassword() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.INVALID_PASSWORD
        );

        assertThat(
                loginPage.getErrorMessage()
        ).isVisible();

        assertThat(
                loginPage.getErrorMessage()
        ).containsText(
                "Username and password do not match"
        );
    }

    @Test
    @DisplayName("User cannot login without credentials")
    void emptyCredentials() {

        loginPage.login(
                TestData.EMPTY_USERNAME,
                TestData.EMPTY_PASSWORD
        );

        assertThat(
                loginPage.getErrorMessage()
        ).isVisible();

        assertThat(
                loginPage.getErrorMessage()
        ).containsText(
                "Username is required"
        );
    }
}