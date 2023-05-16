package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WorkWithProductPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiAddingToFavoritesTest extends TestBase {
    WorkWithProductPage workWithProductPage = new WorkWithProductPage();

    @DisplayName("Проверка добавления товара в избранное")
    @Test
    void addingProductToTheCart() {


        step("Поиск товара", () -> {

            workWithProductPage.productSearch();

        });
        step("Открытие карточки первого товара из списка", () -> {

            workWithProductPage.openCard();
        });

        step("Добавление товара в избранное", () -> {

            workWithProductPage.addingToFavorites();

        });

        step("Проверка наличия товара в избранном", () -> {

            workWithProductPage.checkItemInFavorites();

        });
    }
}
