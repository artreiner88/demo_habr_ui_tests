package demo.autotests.tests;

import demo.autotests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("author")
public class AuthorPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Write post button should be visible")
    void writePostButtonShouldBeVisible() {
        mainPage.goToBecomeAuthorPage().writePostButtonShouldExist();
    }
}
