package demo.autotests.tests;

import demo.autotests.config.Project;
import demo.autotests.pages.MainPage;
import demo.autotests.pages.SignInPage;
import demo.autotests.pages.SignUpPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("SignUpPageTests")
@Epic("Sign Up page tests")
public class SignUpPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    SignUpPage signUpPage = new SignUpPage();

    String email = Project.credentials.email();
    String password = Project.credentials.password();
    String nickName = Project.credentials.nickName();

    @Test
    @DisplayName("User can sign up")
    @Disabled("Skipped: Captcha should be disabled")
    void signUpPositiveTest() {
        signUpPage = mainPage.signUp();
        signUpPage
                .checkPageHeader()
                .signUp("#email", "#nickname", "#password")
                .checkRegistrationIsSuccessful();
    }

    @Test
    @DisplayName("Existing user cannot sign up")
    @Disabled("Skipped: Captcha should be disabled")
    void signUpExistingUserTest() {
        signUpPage = mainPage.signUp();
        signUpPage
                .signUp(email, nickName, password)
                .checkRegistrationIsFailed();
    }

    @Test
    @DisplayName("Sign In page should be opened from Sign Un page")
    void signInPageOpensTest() {
        signUpPage = mainPage.signUp();
        SignInPage signInPage = signUpPage.signIn();
        signInPage.checkPageHeader();
    }
}
