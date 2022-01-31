package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private final String pageHeaderText = "Вход";

    private final SelenideElement
            pageHeader = $(".shadow-box__title"),
            emailInputField = $("#email_field"),
            passwordInputField = $("#password_field"),
            signInButton = $("button[name='go']"),
            remindPasswordLink = $(".form__remind-password-link"),
            signUpLink = $(By.linkText("Зарегистрируйтесь"));

    @Step("Check page header text")
    public SignInPage checkPageHeader() {
        pageHeader.shouldHave(text(pageHeaderText));
        return this;
    }

    @Step("Sign in")
    public MainPage signIn(String email, String password) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        signInButton.click();
        return new MainPage();
    }

    @Step("Verify 'Remind password' button is visible")
    public void remindPasswordButtonShouldBeVisible() {
        remindPasswordLink.shouldBe(visible);
    }

    @Step("Verify 'Sign up' button is visible")
    public void signUpButtonShouldBeVisible() {
        signUpLink.shouldBe(visible);
    }
}
