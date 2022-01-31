package demo.autotests.tests;

import demo.autotests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("main")
public class MainPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Check application title")
    void titleTest() {
        mainPage.checkTitle();
    }

    @Test
    @DisplayName("Check become author possibility")
    void becomeAuthorTest() {
        mainPage.goToBecomeAuthorPage().checkTitle();
    }

    @Test
    @DisplayName("Sign In page should be opened")
    void signInPageOpensTest() {
        mainPage.goToSignInPage().checkPageHeader();
    }
}
