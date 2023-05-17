package test;


import data.Section;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchStringPage;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class UiSearchQueryTest extends TestBase {

    SearchStringPage searchProduct = new SearchStringPage();

    @ValueSource(strings = {"Корм для кошек", "Корм для собак"})
    @ParameterizedTest(name = "В поисковой выдаче на kazanexpress должно отоброжаться 10 результатов по запросу {0}")
    @DisplayName("Проверка количества результатов в поисковом запросе")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void checkingSearchResults(String testData) {

        step("Поиск товара через поисковую строку", () -> {
            searchProduct.searchProductInString(testData);
        });

        step("Проверка количества в результатах поиска", () -> {
            searchProduct.checkItemInSearchResult();
        });
    }


    @CsvSource(value = {
            "Корм для кошек,Сухой полнорационный корм KITEKAT для взрослых кошек",
            "Корм для собак,Сухой корм для собак Chappi"
    })
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отражаться текст {1}")
    @DisplayName("Проверка соответствия запроса и выводимых результатов")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void secondTestSearchResult(String testData, String expectedText) {

        step("Поиск товара на сайте", () -> {
            searchProduct.searchProductCsv(testData);
        });

        step("Проверка результатов поиска", () -> {
            searchProduct.checkItemInSearchResultCsv(expectedText);
        });
    }



    @MethodSource
    @ParameterizedTest(name = "Для раздела {0} должен отражаться список подразделов {1}")
    @DisplayName("Проверка списка подразделов для поискового запроса")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void sectionContentTest(Section section, List<String> expectedButtons) {

        step("Выбрать раздел на сайте", () -> {
            searchProduct.selectSection(section);
        });

        step("Проверить список существующих подразделов", () -> {
            searchProduct.checkSectionList(expectedButtons);
        });

    }


}
