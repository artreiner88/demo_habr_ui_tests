package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SignUpPage {

    private final String url = "https://account.habr.com/register";

    private final SelenideElement
            errorNoticeTextBlock = $("#global_notices"),
            successRegistrationBlock = $(".shadow-box"),
            pageHeader = $(".shadow-box__title"),
            emailInputField = $("#email_field"),
            nickNameInputField = $("#nickname_field"),
            passwordInputField = $("#password_field"),
            repeatPasswordInputField = $("#password_repeat"),
            recaptchaFrame = $("iframe[title='reCAPTCHA']"),
            recaptchaCheckBox = $("#recaptcha-anchor"),
            signUpButton = $("#registration_button"),
            signInLink = $(By.linkText("Войдите"));

    @Step("Open Sign Up page")
    public SignUpPage openSignUpPage() {
        open(url);
        return this;
    }

    @Step("Check page header")
    public SignUpPage checkPageHeader() {
        pageHeader.shouldHave(text("Регистрация"));
        return this;
    }

    @Step("Sign up with email '{email}', nick name '{nickName}' and password '{password}'")
    public SignUpPage signUp(String email, String nickName, String password) {
        emailInputField.setValue(email);
        nickNameInputField.setValue(nickName);
        passwordInputField.setValue(password);
        repeatPasswordInputField.setValue(password);
        switchTo().frame(recaptchaFrame);
        recaptchaCheckBox.click();
        switchTo().defaultContent();
        signUpButton.click();
        return this;
    }

    public void checkRegistrationIsSuccessful() {
        successRegistrationBlock.shouldBe(visible);
        successRegistrationBlock.shouldHave(text("Подтвердите почту"));
    }

    public void checkRegistrationIsFailed() {
        errorNoticeTextBlock.shouldHave(text("Форма содержит ошибки"));
    }

    @Step("Go to Sign In page")
    public SignInPage signIn() {
        signInLink.click();
        return new SignInPage();
    }
}
