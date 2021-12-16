package selenide;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.open;

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



}
