package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class RemindPasswordPage {

    private final SelenideElement
            header = $(".shadow-box__title"),
            failedBlock = $(".notice__text"), // Пользователь с такой почтой не найден
            incorrectEmailMessage = $(".s-error"),
            successBlock = $("#success_block"), // Мы отправили вам на почту инструкции по восстановлению пароля.
            emailInputField = $("#email_field"),
            recaptchaFrame = $("iframe[title='reCAPTCHA']"),
            recaptchaCheckBox = $(".recaptcha-checkbox-border"),
            sendButton = $("button[name='go']"),
            signInLink = $(By.linkText("Войти")),
            signUpLink = $(By.linkText("зарегистрироваться"));

    @Step("Check Remind password page header")
    public void checkPageHeader() {
        header.shouldHave(text("Восстановление пароля"));
    }

    @Step("Remind password with email '{email}'")
    public RemindPasswordPage remindPassword(String email) {
        emailInputField.setValue(email);
        switchTo().frame(recaptchaFrame);
        recaptchaCheckBox.click();
        recaptchaCheckBox.shouldHave(attribute("style")).shouldHave(value("display: none"));
        switchTo().defaultContent();
        sendButton.click();
        return this;
    }

    @Step("Check successful password remind message")
    public void checkSuccessfulPasswordRemindMessage() {
        successBlock.shouldBe(visible);
        successBlock.shouldHave(text("Мы отправили вам на почту инструкции по восстановлению пароля."));
    }

    @Step("Check not valid email message")
    public void checkIncorrectEmailError() {
        incorrectEmailMessage.shouldHave(text("Введите корректный e-mail"));
    }

    @Step("Check email not found message")
    public void checkEmailNotFoundMessage() {
        failedBlock.shouldHave(text("Пользователь с такой почтой не найден"));
    }

    @Step("Go to Sign in page")
    public SignInPage goToSignInPage() {
        signInLink.click();
        return new SignInPage();
    }

    @Step("Go to Sign up page")
    public SignUpPage goToSignUpPage() {
        signUpLink.click();
        return new SignUpPage();
    }
}
