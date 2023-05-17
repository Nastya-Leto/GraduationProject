package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import data.Section;
import test.TestBase;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SearchStringPage extends TestBase {

    public void searchProductInString(String testData) {

        open(baseUrl);
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();

    }



    public void checkItemInSearchResult() {

        $$("[data-test-id=list__products]>div")
                .shouldHave(sizeGreaterThanOrEqual(10));

    }

    public void searchProductCsv(String testData) {

        open(baseUrl);
        $("[data-test-id=input__search]").setValue(testData);
        $("[data-test-id=button__search]").click();

    }

    public void checkItemInSearchResultCsv(String expectedText) {

        $$("[data-test-id=list__products]").first()
                .shouldHave(Condition.text(expectedText));

    }

    public void selectSection(Section section) {

        open(baseUrl);
        $$("#bottom-header li").find(Condition.text(section.name()))
                .click();

    }

    public void checkSectionList(List<String> expectedButtons) {

        $$(".category-list li").filter(visible)
                .shouldHave(CollectionCondition.texts(expectedButtons));

    }
}
