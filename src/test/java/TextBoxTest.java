import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

//    @Test
//    void successfulSubmitForm() {
//        open("https://demoqa.com/text-box");
//
//        $("[id=userName]").setValue("Some user");
//        $("[id=userEmail]").setValue("Some@email.com");
//        $("[id=currentAddress]").setValue("Some address");
//        $("[id=permanentAddress]").setValue("Some permanent address");
//        $("[id=submit]").click();
//
//        $("[id=name]").shouldHave(text("Name:"), text("Some user"));
//        $("[id=email]").shouldHave(text("Some@email.com"));
//        $("p[id=currentAddress]").shouldHave(text("Some address"));
//        $("p[id=permanentAddress]").shouldHave(text("Some permanent address"));
//
//    }

//    @Test
//    void successfulSubmitFormWithVariable() {
//        String userName = "some user";
//
//        open("https://demoqa.com/text-box");
//
//        $("[id=userName]").setValue(userName);
//        $("[id=userEmail]").setValue("Some@email.com");
//        $("[id=currentAddress]").setValue("Some address");
//        $("[id=permanentAddress]").setValue("Some permanent address");
//        $("[id=submit]").click();
//
//        $("[id=name]").shouldHave(text("Name:"), text(userName));
//        $("[id=email]").shouldHave(text("Some@email.com"));
//        $("p[id=currentAddress]").shouldHave(text("Some address"));
//        $("p[id=permanentAddress]").shouldHave(text("Some permanent address"));
//
//    }

//    @Test
//    void successfulSubmitFormSearchInOutput() {
//        String userName = "some user";
//
//        open("https://demoqa.com/text-box");
//
//        $("[id=userName]").setValue(userName);
//        $("[id=userEmail]").setValue("Some@email.com");
//        $("[id=currentAddress]").setValue("Some address");
//        $("[id=permanentAddress]").setValue("Some permanent address");
//        $("[id=submit]").click();
//
//        $("[id=output]").shouldHave((text(userName)), text("Some@email.com"), text("Some address"),
//                text("Some permanent address"));
//
//    }

    @Test
    void successfulSubmitFormWithBadLocators() {
        String userName = "some user";

        open("https://demoqa.com/text-box");

        $("[id=userName]").setValue(userName);
        $("[placeholder=\"name@example.com\"]").setValue("Some@email.com");
        $("textarea").setValue("Some address");
        $(".form-control", 3).setValue("Some permanent address");
        $(byText("Submit")).click();

        $("[id=output]").shouldHave((text(userName)), text("Some@email.com"), text("Some address"),
                text("Some permanent address"));

    }
}
