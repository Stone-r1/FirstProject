package ge.tbc.testautomation.tests;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.MainPageSteps;
import ge.tbc.testautomation.steps.SearchResultSteps;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Search By Keyword Filter on Location Page. [SCRUM-T3]")
public class SearchTest extends BaseTest {
    private final MainPageSteps mainPageStep = new MainPageSteps();
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