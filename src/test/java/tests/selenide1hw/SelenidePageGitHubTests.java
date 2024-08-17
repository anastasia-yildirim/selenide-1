package tests.selenide1hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePageGitHubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000;
    }

    @Test
    void selenideGitHubHasSoftAssertionsPageTest() {
            //Act
            open("/selenide/selenide");
            $("#wiki-tab").click();
            $("#wiki-pages-box").find("li.Box-row.wiki-more-pages-link").find("button").shouldBe(visible).scrollTo().click();
            $("#wiki-pages-box").findAll("a").filterBy(text("SoftAssertions")).first().click();
            //Assert
            $("body").shouldHave(text("""
                    @ExtendWith({SoftAssertsExtension.class})
                    class Tests {
                      @Test
                      void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");
                                    
                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                      }
                    }
                """));
    }
}