package qa.vitalii.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class CheckIssuesSelenideListener {

    @Test
    @DisplayName("Check eroshenkoam repository Issues")
    public void checkIssueWithListenerTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").sendKeys("eroshenkoam/allure-example");
        $("[data-test-selector=nav-search-input]").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#68")).should(Condition.visible);
    }

    @Test
    @DisplayName("Check silens088 repository Issues")
    public void checkIssueMyRepoTest() {

        open("https://github.com/silens088");

        $("[data-test-selector=nav-search-input]").setValue("Practice-Allure-Reports").pressEnter();
        $(linkText("silens088/Practice-Allure-Reports")).click();                           //var1
        //$("ul.repo-list li").$("a").shouldHave(href("Practice-Allure-Reports")).click();  //var2
        $(partialLinkText("Issues")).click();

        $(byText("There aren’t any open issues.")).shouldBe(visible);
    }
}

//Listener - это возможность узнать что происходит внутри библиотеки
//чудо строчка которая сама создаст степы, сохранит скриншот упавшего шага, добавит логов
//SelenideLogger.addListener("allure", new AllureSelenide());