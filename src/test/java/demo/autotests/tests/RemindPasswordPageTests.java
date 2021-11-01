package demo.autotests.tests;

import demo.autotests.pages.MainPage;
import demo.autotests.pages.RemindPasswordPage;
import demo.autotests.pages.SignInPage;
import demo.autotests.pages.SignUpPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static demo.autotests.config.Project.config;

@Tag("RemindPasswordPageTests")
@Epic("Remind password page tests")
public class RemindPasswordPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    RemindPasswordPage remindPasswordPage;
    String email = config.email();
    String notExistedEmail = config.notExistedEmail();

    @Test
    @DisplayName("Existing user can retrieve his password")
    @Disabled("Skipped: Captcha should be disabled")
    void remindPasswordPositiveTest() {
        SignInPage signInPage = mainPage.signIn();
        remindPasswordPage = signInPage.remindPassword();
        remindPasswordPage
                .remindPassword(email)
                .checkSuccessfulPasswordRemindMessage();
    }

    @Test
    @DisplayName("User cannot retrieve his password with invalid email")
    @Disabled("Skipped: Captcha should be disabled")
    void remindPasswordInvalidEmailTest() {
        SignInPage signInPage = mainPage.signIn();
        remindPasswordPage = signInPage.remindPassword();
        remindPasswordPage
                .remindPassword("eeee")
                .checkIncorrectEmailError();
    }

    @Test
    @DisplayName("User cannot retrieve his password with not existing email")
    @Disabled("Skipped: Captcha should be disabled")
    void remindPasswordNotExistedEmailTest() {
        SignInPage signInPage = mainPage.signIn();
        remindPasswordPage = signInPage.remindPassword();
        remindPasswordPage
                .remindPassword(notExistedEmail)
                .checkEmailNotFoundMessage();
    }

    @Test
    @DisplayName("Sign In page can be opened")
    void signInPageOpensTest() {
        SignInPage signInPage = mainPage.signIn();
        remindPasswordPage = signInPage.remindPassword();
        remindPasswordPage.goToSignInPage();
        signInPage.checkPageHeader();
    }

    @Test
    @DisplayName("Sign Un page can be opened")
    void signUpPageOpensTest() {
        SignInPage signInPage = mainPage.signIn();
        remindPasswordPage = signInPage.remindPassword();
        SignUpPage signUpPage = remindPasswordPage.goToSignUpPage();
        signUpPage.checkPageHeader();
    }
}
