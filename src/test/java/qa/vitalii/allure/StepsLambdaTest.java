package qa.vitalii.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepsLambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String URL = "https://github.com";

    @Test
    public void testGithub() {

        step("Открываем главную страницу гитхаб", () -> {
            open(URL);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").sendKeys(REPOSITORY);
            $("[data-test-selector=nav-search-input]").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Check what were Issue with number 68", () -> {
            $(withText("#68")).should(Condition.visible);
        });

    }
}
