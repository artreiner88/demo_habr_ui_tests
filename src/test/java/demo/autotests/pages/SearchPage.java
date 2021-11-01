package demo.autotests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends MainPage {

    private final SelenideElement searchField = $("input[name='q']");

    @Step("Searching for '{text}'")
    public SearchResultsPage searchFor(String text) {
        searchField.setValue(text).pressEnter();
        return new SearchResultsPage();
    }
}
