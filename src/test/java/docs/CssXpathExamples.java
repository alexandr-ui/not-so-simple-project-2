package docs;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExample() {

        //group: https://t.me/xpath_help
        //hints: https://devhints.io/xpath

        //<input autocomplete="off" placeholder="name@example.com" type="email" id="userEmail" class="mr-sm-2 form-control" data-testid="royal_email">
        $("[data-testid=royal_email]").setValue("some@email.com");
        $(by("data-testid", "royal_email")).setValue("some@email.com");

        //<input autocomplete="off" placeholder="name@example.com" type="email" id="userEmail" class="mr-sm-2 form-control">

        $("[id=userEmail]").setValue("some@email.com");
        $("#userEmail").setValue("some@email.com"); // <- use this
        $("input[id=userEmail]").setValue("some@email.com");

        $x("//input[@id='userEmail']").setValue("some@email.com");
        $(byXpath("//*[@id='userEmail']")).setValue("some@email.com");

        //<input autocomplete="off" placeholder="name@example.com" name="email" class="mr-sm-2 form-control">

        $("[name='email']").setValue("some@email.com");
        $("input[name='email']").setValue("some@email.com");
        $(by("name", "email")).setValue("some@email.com");
        $(byName("email")).setValue("some@email.com"); // <- use this

        //<input autocomplete="off" placeholder="name@example.com" class="mr-sm-2 form-control">

        $(byClassName(".form-control")).setValue("some@email.com");
        $(".mr-sm-2.form-control").setValue("some@email.com");
        $("input.mr-sm-2.form-control").setValue("some@email.com");

        $x("//[@class='form-control']").setValue("some@email.com");
    }
    }
