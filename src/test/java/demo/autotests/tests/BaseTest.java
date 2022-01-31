package demo.autotests.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.autotests.config.Project;
import demo.autotests.helpers.Attachments;
import demo.autotests.helpers.DriverSettings;
import demo.autotests.helpers.DriverUtils;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith({AllureJunit5.class})
public class BaseTest {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @BeforeEach
    public void openMainPage() {
        open("/");
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        Attachments.addScreenshotAs("Last screenshot");
        Attachments.addPageSource();
        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            Attachments.addVideo(sessionId);
        }
    }
}
