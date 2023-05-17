package pages;

import test.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class WorkWithProductPage extends TestBase {
    public void productSearch() {

        open(baseUrl);
        $("[data-test-id=input__search]").setValue(product);
        $("[data-test-id=button__search]").click();
    }

    public void openCard() {

        $$("[data-test-id=list__products]").first()
                .$("[data-test-id=item__product-card]").click();
    }

    public void addingToCart() {

        $("[data-test-id=button__add-cart]").click();
    }

    public void checkItemInCart() {

        $("#cart-button").click();
        $("#cart-products-container").shouldHave(text(product));
    }

    public void addingToFavorites() {

        $("[alt=like]").click();
    }

    public void checkItemInFavorites() {

        $("[data-test-id=button__wishes]").click();
        $("#category-products").shouldHave(text(product));
    }

    public void removalFromCart() {

        $("#cart-button").click();
        $("[data-test-id=button__delete-from-cart]").click();

    }
}
