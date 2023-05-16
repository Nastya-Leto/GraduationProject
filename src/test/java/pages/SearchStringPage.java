package pages;

import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class SearchStringPage extends TestBase {
    public void searchProduct() {



    }

    public void checkItemInSearchResult() {

        $$("[data-test-id=list__products]>div")
                .shouldHave(sizeGreaterThanOrEqual(10));

    }

    public void checkСhangeСity() {


    }
}
