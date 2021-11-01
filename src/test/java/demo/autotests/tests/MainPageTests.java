package demo.autotests.tests;

import demo.autotests.pages.MainPage;
import demo.autotests.pages.SignInPage;
import demo.autotests.pages.SignUpPage;
import demo.autotests.pages.components.MainNavBarItem;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


@Tag("main")
@Epic("Main Page tests")
// TODO: Implement test rerunning
public class MainPageTests extends BaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Check Habr projects list is correct")
    @Description("")
    void existingProjectsListTest() {
        mainPage.verifyProjectsList();
    }

    @Test
    @DisplayName("Navigation bar should exist")
    void navigationBarTest() {
        mainPage.verifyNavBarItems();
    }

    @Test
    @DisplayName("Base elements should exist")
    void baseElementsPresenceTest() {
        mainPage.checkBaseElements();
    }

    @Test
    @DisplayName("Check user menu if user is not logged in")
    void loggedOutUserMenuItemsTest() {
        mainPage.checkLoggedOutUserMenuItems();
    }

    @Test
    @DisplayName("'Become author' button should exist")
    void becomeAuthorTest() {
        mainPage.becomeAuthor();
    }

    @EnumSource(value = MainNavBarItem.class, names = {"MARKETING"})
    @ParameterizedTest(name = "Switch to 'headerMenuItem'")
    void switchToMainNavBarItemTest(MainNavBarItem headerMenuItem) {
        mainPage.switchToMainNavBarItem(headerMenuItem);
    }

    @Test
    @DisplayName("Sign Up page can be opened from user menu")
    void signUpPageOpensTest() {
        SignUpPage signUpPage = mainPage.signUp();
        signUpPage.checkPageHeader();
    }

    @Test
    @DisplayName("Sign In page can be opened from user menu")
    void signInPageOpensTest() {
        SignInPage signInPage = mainPage.signIn();
        signInPage.checkPageHeader();
    }
}
