package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import ge.tbc.testautomation.pages.SearchResultPage;
import ge.tbc.testautomation.utils.Helpers;

@SuppressWarnings("UnusedReturnValue")
public class SearchResultSteps {
    private final SearchResultPage searchResultPage = new SearchResultPage();
    private final Helpers helpers = new Helpers();

    // ============== Actions =================
    public SearchResultSteps goToTheLastPage() {
        Selenide.back();
        return this;
    }

    // ============ Assertions ================
    public SearchResultSteps assertSearchSuccess(String keyword) {
        searchResultPage.matchingTextLocator(keyword, helpers.getAlphabet()).shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }
}
