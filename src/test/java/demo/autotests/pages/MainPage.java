package demo.autotests.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MainPage {
    private final String title = "Хабр";

    private final SelenideElement
            becomeAuthorBtn = $(".tm-header__become-author-btn"),
            userProfileIcon = $(".tm-header-user-menu__user_desktop"),
            userNickNameLink = $("a.tm-user-item__username"),
            signInButton = $(byLinkText("Войти")),
            signUpButton = $(byLinkText("Регистрация")),
            signOutButton = $(byLinkText("Выход")),
            becomeAuthorUserProfileLink = $(byLinkText("Как стать автором")),
            rulesLink = $(byLinkText("Правила сайта"));

    @Step("Check page title text")
    public void checkTitle() {
        assertThat(Selenide.title()).containsIgnoringCase(title);
    }

    @Step("Go to 'Become author' page")
    public AuthorPage goToBecomeAuthorPage() {
        becomeAuthorBtn.shouldBe(visible);
        becomeAuthorBtn.click();
        return new AuthorPage();
    }

    @Step("Go to 'Sign in' page")
    public SignInPage goToSignInPage() {
        userProfileIcon.click();
        signInButton.click();
        return new SignInPage();
    }

    @Step("Verify authorized user menu items differ from not authorized user")
    public void checkLoggedInUserMenuItems(String nickName) {
        userProfileIcon.click();
        signInButton.shouldNotBe(visible);
        signUpButton.shouldNotBe(visible);
        userNickNameLink.shouldBe(visible);
        userNickNameLink.shouldHave(text("@" + nickName));
        becomeAuthorUserProfileLink.shouldBe(visible);
        rulesLink.shouldBe(visible);
        signOutButton.shouldBe(visible);
    }
}
