import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void GithubPageShouldHaveSoftAssertionsAndCodeJUnit5Example(){
        //  открыть github.com
        open("https://github.com");
        //перейти на страницу Selenide
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        // Нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // перейти в раздел WiKi
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[class=markdown-body]").shouldHave(text("Soft assertions")).shouldBe(visible);
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(By.linkText("Soft assertions")).shouldBe(visible).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class")).shouldBe(visible);

    }

}
