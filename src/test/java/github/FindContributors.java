package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindContributors {

    @Test
    void verifyFirstContributor() {
//        Configuration.headless = true;
        open("https://github.com/selenide/selenide");
        // hover() - подвести мышь
        // .closest("div") - перейти на ближайший div вверх
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div").$("li").hover();
        $$(".Popover-message").findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
