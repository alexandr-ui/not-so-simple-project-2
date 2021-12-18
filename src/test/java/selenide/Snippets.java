package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {
    void browser_command_examples() {

//        https://the-internet.herokuapp.com/


        open("https://www.google.com/");
        Configuration.baseUrl = "https://github.com";
        open("/selenide/selenide");
        open("/", AuthenticationType.BASIC, "user", "password");

        Selenide.back();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        Selenide.confirm(); // OK in alert dialog
        Selenide.dismiss(); // Cancel in alert dialogs

        Selenide.closeWindow(); // Close active tab
        Selenide.closeWebDriver(); // close browser completely

        Selenide.switchTo().frame("new"); // go to iFrame
        Selenide.switchTo().defaultContent(); // return back

        Selenide.switchTo().window("the internet");
    }

    void selectors_examples() {
        $("div").click();
        element("div");

        $$("collection of elements").first().click();
        elements("collection of elements").first().click();

        $("div", 2).click();

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull text")).click();

        $("div").$("h1").find(byText("abc")).click();

        //very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();

}

    void actions_examples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick(); // right click

        $("").hover();

        $("").setValue("text"); //cleat and enter text
        $("").append("text"); // add text
        $("").clear();

        $("").sendKeys("c"); //press hotkey c

        actions().sendKeys("c").perform(); // hotkey c on whole application
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); //Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        actions().moveToElement($("div")).clickAndHold().moveByOffset(300,200).release().perform();


        //old html actions
        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_option");

    }

    void assertions_examples() {
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);

        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30));

        Configuration.timeout = 6000;
        Configuration.baseUrl = "google.com";


        //launch with timeout
        //gradle test -Dselenide.timeout=6000 -DbrowserSize=1900x1200 -DbaseUrl="https://google.com"

    }

    void conditions_examples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").shouldHave(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));
        $("").shouldHave(cssValue("font-size", "12"), Duration.ofSeconds(8));

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("enabled"));
        $("").shouldHave(attribute("name", "Fred");
        $("").shouldHave(attributeMatching("name", "[0-9]abc$");

        $("").shouldBe(checked); //for checkbox

        $("").should(exist); // exist can mean that it may be visible but hidden

        $("").shouldBe(enabled); //checks enabled attribute
        $("").shouldBe(disabled);

    }

    void collections_example() {

        //selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        //faster:
//        $("div").click();
        elements("div").first().click();
        $$("div").last().click();
        $$("div").get(1).click();
        $("div", 1).click();
        $$("div").findBy(text("123")).click(); // finds first

        //assertions
        $$("div").shouldHave(size(0));
        $$("div").shouldBe(CollectionCondition.empty); // the same

        $$("div").shouldHave(texts("Alpha", "Beta", "Psi"));
        $$("div").shouldHave(exactTexts("Alpha", "Beta", "Psi"));

        $$("div").shouldHave(textsInAnyOrder("Beta", "Alpha", "Psi"));
        $$("div").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Alpha", "Psi"));

        $$("div").shouldHave(itemWithText("Gamma")); // verifies if Gamma is among the elements

        $$("div").shouldHave(sizeGreaterThan(0));
        $$("div").shouldHave(sizeGreaterThanOrEqual(1));
        $$("div").shouldHave(sizeLessThan(3));
        $$("div").shouldHave(sizeLessThanOrEqual(2));

    }

    void file_operations_examples() throws FileNotFoundException {
        File file1 = $("a file link").download(); //only for <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); //more common but may have issues with Grid/Selenoid

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        // don't forget to submit!
        $("uploadButton").click();

    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]+arguments[1];", 6, 7);
    }
}
