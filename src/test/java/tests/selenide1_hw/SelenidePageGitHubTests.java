package tests.selenide1_hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePageGitHubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void selenideGitHubHasSoftAssertionsPageTest() {
            //Act
            open("/selenide/selenide");
            $("#wiki-tab").click();
            $("#user-content-chapters").parent().sibling(0).$$("li")
                    .filterBy(text("Soft assertions")).first().$("a").click();
            //Assert
            $(".gh-header-title").shouldHave(text("SoftAssertions"));
    }
}