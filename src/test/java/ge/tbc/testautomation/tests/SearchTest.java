package ge.tbc.testautomation.tests;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.MainPageStep;
import ge.tbc.testautomation.steps.OffersSteps;
import ge.tbc.testautomation.steps.SearchResultSteps;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Search: site search by keyword; validate results list and empty state.")
public class SearchTest extends BaseTest {
    private final MainPageStep mainPageStep = new MainPageStep();
    private final SearchResultSteps searchResultSteps = new SearchResultSteps();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }

    @Test
    public void testSearchByKeyword() {
        List<SelenideElement> searchResults;

        mainPageStep
                .rejectAllCookies()
                .clickNavbarSearchButton()
                .enterKeyword(SEARCH_INVALID_TEXT)
                .assertSearchEmpty()
                .enterKeyword(LOCATIONS_TEXT)
                .assertSearchNotEmpty();

        searchResults = mainPageStep.getSearchResults().stream().toList();

        // aq sheileba loopis dawera ro yvela sheamowmos
        mainPageStep
                .goToSearchedPage(searchResults.getFirst());

        searchResultSteps
                .assertSearchSuccess(LOCATIONS_TEXT);
    }
}