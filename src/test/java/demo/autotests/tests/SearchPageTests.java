package demo.autotests.tests;

import demo.autotests.pages.MainPage;
import demo.autotests.pages.SearchPage;
import demo.autotests.pages.SearchResultsPage;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("search")
@Epic("Search tests")
public class SearchPageTests extends BaseTest {

    MainPage mainPage = new MainPage();
    SearchPage searchPage;
    SearchResultsPage searchResultsPage;
    String validSearchValue = "Selenide";
    String invalidSearchValue = "Selenededededede";

    @Test
    @DisplayName("User can do a search and get a result")
    void searchPositiveTest() {
        searchPage = mainPage.goToSearchPage();
        searchResultsPage = searchPage.searchFor(validSearchValue);
        searchResultsPage.checkSearchBarIsVisible();
        searchResultsPage.checkValidSearchResults(validSearchValue);
    }

    @Test
    @DisplayName("User can do a search and get no result")
    void searchNegativeTest() {
        searchPage = mainPage.goToSearchPage();
        searchResultsPage = searchPage.searchFor(invalidSearchValue);
        searchResultsPage.checkSearchBarIsVisible();
        searchResultsPage.checkInvalidSearchResults();
    }

    @Test
    @DisplayName("User can return to Main page by click on logo")
    void returnToMainPageTest() {
        searchPage = mainPage.goToSearchPage();
        searchPage.goToHomePage();
    }
}
