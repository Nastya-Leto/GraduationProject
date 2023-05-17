package test;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.WorkWithProductPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiRemovalFromCartTest extends TestBase {
    WorkWithProductPage workWithProductPage = new WorkWithProductPage();

    @Test
    @DisplayName("Проверка добавления товара в корзину")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void addingProductToTheCart() {


        step("Поиск товара", () -> {
            open(baseUrl);

            workWithProductPage.productSearch();

        });
        step("Открытие карточки первого товара из списка", () -> {

            workWithProductPage.openCard();

        });

        step("Добавление товара в корзину", () -> {

            workWithProductPage.addingToCart();

        });

        step("Проверка наличия товара в корзине", () -> {

            workWithProductPage.checkItemInCart();

        });

        step("Удаление товара из корзины", () -> {

            workWithProductPage.removalFromCart();

        });

        step("Проверка удаления товара из корзины", () -> {

            //$("#cart-button").click();
            $("[data-test-id=block__empty-page]")
                    .shouldHave(text(message));

        });
    }
}
