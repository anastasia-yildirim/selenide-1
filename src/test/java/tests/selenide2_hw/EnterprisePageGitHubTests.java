package tests.selenide2_hw;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EnterprisePageGitHubTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    public void navigationToEnterprisePageTest() {
            //Act
            open("");
            $(byTagAndText("button", "Solutions")).shouldBe(visible).hover();
            $("#solutions-by-size-heading").sibling(0).$$("li")
                .filterBy(text("Enterprise")).first().$("a").click();
            //Assert
            $("[data-testid='SubNav-root-heading']").shouldHave(text("Enterprise"));
    }
}