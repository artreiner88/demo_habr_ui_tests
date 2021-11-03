package demo.autotests.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends MainPage {

    private final String noResultsFoundText = "К сожалению, здесь пока нет ни одной публикации";

    private final SelenideElement
            searchField = $("[name='q']"),
            searchResultTabs = $(".tm-tabs"),
            emptyResultsPlaceHolder = $(".tm-empty-placeholder__text");

    private final ElementsCollection posts = $$(".tm-articles-list article");

    @Step("Check search bar is visible")
    public void checkSearchBarIsVisible() {
        searchField.shouldBe(visible);
        searchResultTabs.shouldBe(visible);
    }

    @Step("Check search results")
    public void checkValidSearchResults(String searchText) {
        posts.shouldHave(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(text(searchText));
    }

    @Step("Check search results")
    public void checkInvalidSearchResults() {
        emptyResultsPlaceHolder.shouldHave(text(noResultsFoundText));
    }
}
