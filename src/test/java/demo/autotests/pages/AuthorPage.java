package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorPage {
    private final String becomeAuthorPageHeaderText = "Как стать автором";

    SelenideElement
            writePostButton = $(".tm-write-button"),
            pageHeader = $(".tm-section-name__text");

    @Step("Check page header text")
    public void checkTitle() {
        pageHeader.shouldHave(text(becomeAuthorPageHeaderText));
    }

    @Step("Verify 'Write post' button is visible")
    public void writePostButtonShouldExist() {
        writePostButton.shouldBe(visible);
    }
}
