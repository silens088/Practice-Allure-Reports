package qa.vitalii.allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametersTest { //про параметризованные тесты в аллюре

    @DisplayName("Проверка города")
    @ParameterizedTest(name = "{displayName} {0}")
    @ValueSource(strings = {"Тольятти", "Москва"})
    public void testLambda(String city) {
        Allure.parameter("Город", city);
    }
}

