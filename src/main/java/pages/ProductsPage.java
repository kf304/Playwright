package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage {

    private final Page page;

    private final Locator pageTitle;
    private final Locator products;
    private final Locator cartIcon;
    private final Locator sortDropdown;

    public ProductsPage(Page page) {
        this.page = page;

        pageTitle = page.locator(".title");
        products = page.locator(".inventory_item");
        cartIcon = page.locator(".shopping_cart_link");
        sortDropdown = page.locator(".product_sort_container");
    }

    public Locator getPageTitle() {
        return pageTitle;
    }

    public Locator getProducts() {
        return products;
    }

    public Locator getCartIcon() {
        return cartIcon;
    }

    public void sortProductsBy(String option) {
        sortDropdown.selectOption(option);
    }

    public void addProductToCart(String productName) {
        Locator product = page
                .locator(".inventory_item")
                .filter(new Locator.FilterOptions()
                        .setHasText(productName));

        product.locator("button").click();
    }

    public void removeProductFromCart(String productName) {
        Locator product = page
                .locator(".inventory_item")
                .filter(new Locator.FilterOptions()
                        .setHasText(productName));

        product.locator("button").click();
    }

    public void clickCart() {
        cartIcon.click();
    }
}