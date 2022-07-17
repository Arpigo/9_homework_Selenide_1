package selenide;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("GitHubSoftAssertionTest")
    void gitHubSoftAssertionTest() {

        // - Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("ul li.wiki-more-pages-link").$("button").click();
        $("ul[data-filterable-for=wiki-pages-filter]");

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("SoftAssertions")).click();
        $$(".markdown-body h4").findBy(text("JUnit5"))
                .shouldHave(text("Using JUnit5 extend test class:"));
    }
}
