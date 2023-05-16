package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import data.Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchStringPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class UiSearchQueryTest extends TestBase {

    SearchStringPage searchProduct = new SearchStringPage();

    @ValueSource(strings = {
            "Корм для кошек", "Корм для собак"
    })

    @DisplayName("Проверка количества результатов в поисковом запросе")
    @ParameterizedTest(name = "В поисковой выдаче на kazanexpress должно отоброжаться 10 результатов по запросу {0}")
    void checkingSearchResults(String testData) {

        step("Поиск товара через поисковую строку", () -> {

            open(baseUrl);
            $("[data-test-id=input__search]").setValue(testData);
            $("[data-test-id=button__search]").click();

        });
        step("Проверка количества в результатах поиска", () -> {

            searchProduct.checkItemInSearchResult();
        });
    }

    @DisplayName("Проверка соответсвия запроса и выводимых результатов")
    @CsvSource(value = {
            "Корм для кошек,Сухой полнорационный корм KITEKAT для взрослых кошек",
            "Корм для собак,Сухой корм для собак Chappi"
    })
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отражаться текст {1}")
    void secondTestSearchResult(String testData, String expectedText) {

        step("Поиск товара на сайте", () -> {
            open(baseUrl);
            $("[data-test-id=input__search]").setValue(testData);
            $("[data-test-id=button__search]").click();
        });

        step("Проверка результатов поиска", () -> {
            $$("[data-test-id=list__products]").first()
                    .shouldHave(Condition.text(expectedText));
        });
    }

    static Stream<Arguments> sectionContentTest() {
        return Stream.of(
                Arguments.of(Section.Одежда, List.of("Все категории", "Одежда",
                        "Детская одежда", "Женская одежда", "Мужская одежда", "Спецодежда")),
                Arguments.of(Section.Обувь, List.of("Все категории", "Обувь", "Аксессуары для обуви",
                        "Специализированная обувь", "Женская обувь", "Мужская обувь",
                        "Обувь для девочек", "Обувь для мальчиков"))
        );
    }

    @DisplayName("Проверка списка подразделов для поискового запроса")
    @MethodSource
    @ParameterizedTest(name = "Для раздела {0} должен отражаться список подразделов {1}")
    void sectionContentTest(Section section, List<String> expectedButtons) {

        step("Выбрать раздел на сайте", () -> {
            open(baseUrl);
            $$("#bottom-header li").find(Condition.text(section.name())).click();
        });
        step("Проверить список существующих подразделов", () -> {

            $$(".category-list li").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));

        });

    }


}
