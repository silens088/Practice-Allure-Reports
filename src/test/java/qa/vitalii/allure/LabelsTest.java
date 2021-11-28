package qa.vitalii.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("vvelichko")
    @Feature("Авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Авторизация через Email")
    @DisplayName("Test for check Github")
    @Link(name = "GitHub", url = "https://github.com/")
    public void testLambda() {

    }

    //         ↓ = ↑

    @Test
    public void testAnnotated() {
        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Test for check Google");
        });
        Allure.label("owner", "vvelichko");
        Allure.feature("Авторизация");
        Allure.story("Авторизация через Email");
        Allure.label("severity", "BLOCKER");
        Allure.link("GitHub", "https://github.com");
    }
}
