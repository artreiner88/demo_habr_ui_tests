package demo.autotests.tests;

import demo.autotests.config.Credentials;
import demo.autotests.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("signIn")
public class SignInPageTests extends BaseTest {
    MainPage mainPage = new MainPage();

    String email = Credentials.credentials.email();
    String password = Credentials.credentials.password();
    String nickName = Credentials.credentials.nickName();

    @Test
    @DisplayName("Sign In as existed user")
    void signInPositiveTest() {
        mainPage
                .goToSignInPage()
                .checkPageHeader()
                .signIn(email, password)
                .checkLoggedInUserMenuItems(nickName);
    }

    @Test
    @DisplayName("Sign Up as button should be visible")
    void signUpButtonTest() {
        mainPage.goToSignInPage().signUpButtonShouldBeVisible();
    }

    @Test
    @DisplayName("Remind password should be visible")
    void remindPasswordButtonTest() {
        mainPage.goToSignInPage().remindPasswordButtonShouldBeVisible();
    }
}
