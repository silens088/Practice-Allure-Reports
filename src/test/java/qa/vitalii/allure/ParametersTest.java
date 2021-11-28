package qa.vitalii.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class ParametersTest { //про параметризованные тесты в аллюре

    @DisplayName("Проверка города")
    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"Тольятти", "Москва"})
    public void testLambda(String city) {
        Allure.parameter("Город", city);
    }

    //Экспериментальный параметризованный тест
    @ParameterizedTest(name = "{displayName} {0}")
    @DisplayName("Check Issues")
    @ValueSource(strings = {"There aren’t any open issues.", "You could search", "Author"})

    public void checkIssueMyRepoParameterizedTest(String issues) {

        open("https://github.com/silens088");

        $("[data-test-selector=nav-search-input]").setValue("Practice-Allure-Reports").pressEnter();
        $(linkText("silens088/Practice-Allure-Reports")).click();
        $(partialLinkText("Issues")).click();

        $(byText(Allure.parameter("Искомая строка", issues))).shouldBe(visible);
    }
}

