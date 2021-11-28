package qa.vitalii.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class CheckIssueLambda {

    private static final String REPOSITORY1 = "eroshenkoam/allure-example";
    private static final String REPOSITORY2 = "silens088/Practice-Allure-Reports";
    private static final String URL = "https://github.com";

    @Test
    public void checkIssueInEroshenkoamGithub() {
        step("Open maid page in GutHub", () -> {
            open(URL);
        });

        step("Search repository " + REPOSITORY1, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").sendKeys(REPOSITORY1);
            $("[data-test-selector=nav-search-input]").submit();
        });

        step("Go in to repository " + REPOSITORY1, () -> {
            $(linkText(REPOSITORY1)).click();

        });
        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();

        });
        step("Check what were Issue with number 68", () -> {
            $(withText("#68")).should(Condition.visible);
        });
    }

    @Test
    public void checkIssueInMyGithub() {

        step("Open page in Github", () -> {
            open(URL);
        });

        step("Search the repository " + REPOSITORY2, () -> {
            $("[data-test-selector=nav-search-input]").setValue("Practice-Allure-Reports").pressEnter();
        });

        step("Go to the repository " + REPOSITORY2, () -> {
            $(linkText("silens088/Practice-Allure-Reports")).click();
        });

        step("Open tab Issue", () -> {
            $(partialLinkText("Issues"));
        });

        $(partialLinkText("Issues")).click();

        $(byText("There aren’t any open issues.")).shouldBe(visible);
    }
}
