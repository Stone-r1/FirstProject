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

    @Test
    public void checkSomeCrap() {
        mainPageStep
                .rejectAllCookies()
                .clickQuickActionButton()
                .clickQuickActionLocationButton();
        locationPageStep
                .enterLocation(SEARCH_RUSTAVELI_TEXT)
                .getRelevantBranches()
                .assertOnlyRelevantLocationsDisplayed(SEARCH_RUSTAVELI_TEXT);
    }
}
