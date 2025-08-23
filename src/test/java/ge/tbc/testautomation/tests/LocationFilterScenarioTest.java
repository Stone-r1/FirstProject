package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.LocationPageStep;
import ge.tbc.testautomation.steps.MainPageStep;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

public class LocationFilterScenarioTest extends BaseTest {
    private final MainPageStep mainPageStep = new MainPageStep();
    private final LocationPageStep locationPageStep = new LocationPageStep();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }

    @Test(description = "Location filter (keyword) updates map + list; details visible")
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
