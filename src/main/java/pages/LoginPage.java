package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;

        usernameField = page.locator("#user-name");
        passwordField = page.locator("#password");
        loginButton = page.locator("#login-button");
        errorMessage = page.locator("[data-test='error']");
    }

    public void navigateToLoginPage() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        usernameField.fill(username);
    }

    public void enterPassword(String password) {
        passwordField.fill(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public Locator getErrorMessage() {
        return errorMessage;
    }
}