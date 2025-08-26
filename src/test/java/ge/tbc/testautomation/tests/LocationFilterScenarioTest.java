package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.LocationPageSteps;
import ge.tbc.testautomation.steps.MainPageSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Location filter (keyword) updates map + list; details visible. [SCRUM-T1]")
public class LocationFilterScenarioTest extends BaseTest {
    private final MainPageSteps mainPageStep = new MainPageSteps();
    private final LocationPageSteps locationPageStep = new LocationPageSteps();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }

    @Test
    public void locationFilterTest() {
        int branchesBeforeSearch;

        mainPageStep
                .rejectAllCookies()
                .clickQuickActionButton()
                .clickQuickActionLocationButton();

        branchesBeforeSearch = locationPageStep.getBranches().size();

        locationPageStep
                .enterLocation(SEARCH_RUSTAVELI_TEXT)
                .assertMapPinsCountDecreased(branchesBeforeSearch)
                .assertOnlyRelevantLocationsDisplayed(SEARCH_RUSTAVELI_TEXT, branchesBeforeSearch)
                .assertDetailsAreVisibleOnBar();
    }
}