import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    /**
     *
     * @BeforeAll
     *
     *      @BeforEach
     *              @Test
     *      @AfterEach
     *
     *      @BeforeEach
     *              @Test
     *      @AfterEach
     *
     * @AfterAll
     */

    static Logger logger = LoggerFactory.getLogger(SearchTest.class);

    @BeforeAll
    static void config() {

         logger.info("@BeforeALL method");
//        Configuration.browserSize = "2880 × 1800";
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openGooglePage() {
        logger.info("@BeforeEach method");
        open("https://www.google.com/");
    }

    @AfterEach
    void closeBrowser() {
         closeWebDriver();
    }

    @Test
    void selenideSearchText() {
        logger.info("This is selenide test!");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    @Test
    void allureSearchText() {
        logger.info("This is allure test!");
        $(byName("q")).setValue("Allure testops").pressEnter();
        $("#search").shouldHave(text("qameta.io"));
    }
}
