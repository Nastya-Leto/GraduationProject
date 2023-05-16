package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiСhangeСityTest extends TestBase {

    HeaderPage headerPage = new HeaderPage();
    @DisplayName("Проверка изменения места геолокации")
    @Test
    void addingProductToTheCart() {


        step("Клик на Хедер с городом", () -> {

            headerPage.clickToCity();

        });
        step("Выбор города через поисковую строку", () -> {

            headerPage.selectionCity();
        });

        step("Проверка, что город изменился", () -> {

            headerPage.checkСhangeСity();

        });

    }
}
