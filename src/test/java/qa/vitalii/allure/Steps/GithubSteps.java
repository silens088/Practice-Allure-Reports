package qa.vitalii.allure.Steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class GithubSteps {  //этот пример примерно аналог pageObject

    @Step("Open page in {GitHub}")
    public void openMainPage(String github) {
        open(github);
    }

    @Step("Search repository")
    public void seachForRepository(String repository) {
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").sendKeys(repository);
        $("[data-test-selector=nav-search-input]").submit();
    }

    @Step("Go to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open tab {Issues}")
    public void openIssueTab(String issues) {
        $(partialLinkText(issues)).click();
    }

    @Step("Check what were Issue with number {number}")
    public void shoudSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }

    //сделать скриншот
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
