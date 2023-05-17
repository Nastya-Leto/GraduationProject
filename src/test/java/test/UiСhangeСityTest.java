package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;

import static io.qameta.allure.Allure.step;

public class UiСhangeСityTest extends TestBase {

    HeaderPage headerPage = new HeaderPage();


    @Test
    @DisplayName("Проверка изменения места геолокации")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
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
