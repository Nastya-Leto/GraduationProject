package tests;

import com.codeborne.selenide.Configuration;
import data.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import pages.WorkWithProductPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    public String product = "Вафельница";
    public String city = "Самара";
    public String message = "В корзине пока нет товаров";



    @BeforeEach
    void setup() {

        Configuration.baseUrl = "https://kazanexpress.ru/";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 100000;
    }


}
