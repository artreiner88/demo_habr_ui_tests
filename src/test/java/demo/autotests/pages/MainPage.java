package demo.autotests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import demo.autotests.pages.components.MainNavBarItem;
import demo.autotests.pages.components.ProjectsListItem;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPage {

    private final String mainPageTitle = "Все публикации подряд / Хабр";
    private final String becomeAuthorPageHeaderText = "Как стать автором";

    private final SelenideElement
            habrProjectsListsOpenButton = $(".tm-header__dropdown-toggle"),
            logo = $(".tm-header__logo"),
            becomeAuthorBtn = $(".tm-header__become-author-btn"),
            mainNavBar = $("nav"),
            searchIcon = $(".tm-header-user-menu__search"),
            userProfileIcon = $(".tm-header-user-menu__user_desktop"),
            pageHeader = $(".tm-section-name__text"),
            userNickNameLink = $("a.tm-user-item__username"),
            signInButton = $(byLinkText("Войти")),
            signUpButton = $(byLinkText("Регистрация")),
            signOutButton = $(byLinkText("Выход")),
            becomeAuthorUserProfileLink = $(byLinkText("Как стать автором")),
            rulesLink = $(byLinkText("Правила сайта"));

    private final ElementsCollection
            habrProjects = $$(".tm-our-projects__item title"),
            mainNavBarItems = $$("nav a");


    @Step("Return to Home page")
    public void goToHomePage() {
        logo.click();
        assertThat($("title").innerText()).isEqualTo(mainPageTitle);
    }

    @Step("Check Habr projects list in header")
    public void verifyProjectsList() {
        habrProjectsListsOpenButton.click();
        List<ProjectsListItem> projectsList = new LinkedList<>(Arrays.asList(ProjectsListItem.values()));
        assertThat(habrProjects.size()).isEqualTo(projectsList.size());

        Iterator<ProjectsListItem> iterator = projectsList.listIterator();

        for (SelenideElement project : habrProjects) {
            assertThat(project.innerText()).isEqualTo(iterator.next().getTitle());
        }
    }

    @Step("Check NavBar links labels")
    public void verifyNavBarItems() {
        List<MainNavBarItem> mainNavBarItemList = new LinkedList<>(Arrays.asList(MainNavBarItem.values()));
        for (MainNavBarItem mainNavBarItem : mainNavBarItemList) {
            assertThat(mainNavBarItem.getTitle()).isIn(mainNavBarItems.texts());
        }
    }

    @Step("Click How to become an author button")
    public void becomeAuthor() {
        becomeAuthorBtn.click();
        pageHeader.shouldHave(text(becomeAuthorPageHeaderText));
    }

    @Step("Switch to {mainNavBarItem} tab")
    public void switchToMainNavBarItem(MainNavBarItem mainNavBarItem) {
        mainNavBar.$(By.linkText(mainNavBarItem.getTitle())).click();
        pageHeader.shouldHave(text(mainNavBarItem.getTitle()));
    }

    @Step("Check base elements")
    public void checkBaseElements() {
        becomeAuthorBtn.shouldBe(visible);
        mainNavBar.shouldBe(visible);
        searchIcon.shouldBe(visible);
        userProfileIcon.shouldBe(visible);
    }

    @Step("Go to Search page")
    public SearchPage goToSearchPage() {
        searchIcon.click();
        return new SearchPage();
    }

    @Step("Check Logged Out User menu items")
    public void checkLoggedOutUserMenuItems() {
        userProfileIcon.click();
        userNickNameLink.shouldNotBe(visible);
        signInButton.shouldBe(visible);
        signUpButton.shouldBe(visible);
        becomeAuthorUserProfileLink.shouldBe(visible);
        rulesLink.shouldBe(visible);
    }

    @Step("Check Logged In User menu items")
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

    @Step("Open User menu and click Log in button")
    public SignInPage signIn() {
        userProfileIcon.click();
        signInButton.click();
        return new SignInPage();
    }

    @Step("Open profile menu and click Sign up button")
    public SignUpPage signUp() {
        userProfileIcon.click();
        signUpButton.click();
        return new SignUpPage();
    }
}
