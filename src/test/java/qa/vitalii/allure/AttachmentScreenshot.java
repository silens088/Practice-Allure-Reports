package qa.vitalii.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import qa.vitalii.allure.Steps.GithubSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentScreenshot {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String URL_GITHUB = "https://github.com";

    private GithubSteps steps = new GithubSteps();

    @Test
    public void testLambda() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

        step("Открываем главную страницу гитхаб", () -> {
            open("https://github.com");

        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").sendKeys(REPOSITORY);
            $("[data-test-selector=nav-search-input]").submit();
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenchot());
        });
    }

    @Test
    public void testAnnotated() {  //переиспользуемый метод
        steps.openMainPage(URL_GITHUB);
        steps.seachForRepository(REPOSITORY);
        steps.takeScreenshot();
    }

    public byte[] takeScreenchot() {  //скриншот в webDriver
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
