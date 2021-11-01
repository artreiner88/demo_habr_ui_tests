package demo.autotests.tests;

import demo.autotests.config.Project;
import demo.autotests.pages.MainPage;
import demo.autotests.pages.RemindPasswordPage;
import demo.autotests.pages.SignInPage;
import demo.autotests.pages.SignUpPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("SignInPageTests")
@Epic("Sign In page tests")
public class SignInPageTests extends BaseTest {

    MainPage mainPage = new MainPage();

    String email = Project.config.email();
    String nickName = Project.config.nickName();
    String password = Project.config.password();

    @Test
    @DisplayName("Sign In as existed user")
    void signInPositiveTest() {
        SignInPage signInPage = mainPage.signIn();
        signInPage
                .checkPageHeader()
                .signIn(email, password)
                .checkLoggedInUserMenuItems(nickName);
    }

    @Test
    @DisplayName("Remind password page can be opened from Sign In page")
    void remindPasswordPageOpensTest() {
        SignInPage signInPage = mainPage.signIn();
        RemindPasswordPage remindPasswordPage = signInPage.remindPassword();
        remindPasswordPage.checkPageHeader();
    }

    @Test
    @DisplayName("Sign Up page can be opened from Sign In page")
    void signUpPageOpensTest() {
        SignInPage signInPage = mainPage.signIn();
        SignUpPage signUpPage = signInPage.signUp();
        signUpPage.checkPageHeader();
    }
}
