package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest {

    @Test
    void shouldFindSelenideGithub() {
        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        // $$ - для коллекции элементов ul
        // если нужен 14 элемент, то вместо first() > get(14)
        $$("ul.repo-list li a").first().click();
        sleep(5000);
        $("h1").shouldHave(text("selenide / selenide"));
    }
}
