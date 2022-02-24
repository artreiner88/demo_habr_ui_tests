package demo.autotests.tests;

import demo.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


@Tag("smoke")
@Epic("Smoke tests")
public class SmokeTests extends BaseTest {

    @Test
    @Description("Open and check page title")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://habr.com/ru'", () ->
                open("https://habr.com/ru"));

        step("Page title should have text 'Все публикации подряд / Хабр'", () -> {
            String expectedTitle = "Все публикации подряд / Хабр";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Disabled("Skipped: Console log error")
    @Description("Check that there are no console log errors in browser")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://habr.com/ru'", () ->
                open("https://habr.com/ru"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
