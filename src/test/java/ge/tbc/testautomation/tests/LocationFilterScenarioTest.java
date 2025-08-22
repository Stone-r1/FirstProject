package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.LocationFilterSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

public class LocationFilterScenarioTest extends BaseTest {
    private final LocationFilterSteps locationFilterSteps = new LocationFilterSteps();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }
}
