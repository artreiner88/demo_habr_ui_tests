package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private final SelenideElement
            pageHeader = $(".shadow-box__title"),
            emailInputField = $("#email_field"),
            passwordInputField = $("#password_field"),
            signInButton = $("button[name='go']"),
            remindPasswordLink = $(".form__remind-password-link"),
            signUpLink = $(By.linkText("Зарегистрируйтесь"));

    @Step("Check page header")
    public SignInPage checkPageHeader() {
        pageHeader.shouldHave(text("Вход"));
        return this;
    }

    @Step("Sign In with email '{email}' and password '{password}'")
    public MainPage signIn(String email, String password) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        signInButton.click();
        return new MainPage();
    }

    public RemindPasswordPage remindPassword() {
        remindPasswordLink.click();
        return new RemindPasswordPage();
    }

    @Step("Click Sign Up link")
    public SignUpPage signUp() {
        signUpLink.click();
        return new SignUpPage();
    }
}
