package ge.tbc.testautomation.tests;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.LocationPageStep;
import ge.tbc.testautomation.steps.MainPageStep;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Tabs & sub-tabs (Branch/ATM + services like 24/7, Open now)")
public class TabsAndSubtabsTest extends BaseTest {
    private final MainPageStep mainPageStep = new MainPageStep();
    private final LocationPageStep locationPageStep = new LocationPageStep();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }

    @Test
    public void tabsAndSubTabsTest() {
        // Saving as list because I need static snapshot and now dynamic wrapper.
        List<SelenideElement> defaultBranches;

        mainPageStep
                .rejectAllCookies()
                .clickQuickActionButton()
                .clickQuickActionLocationButton();

        defaultBranches = locationPageStep.getBranches().stream().toList();

        locationPageStep
                .selectTab(TAB_ATM)
                .assertOnlyATMTabVisible()
                .selectSubtab(ALWAYS_OPEN_SUBTAB)
                .assertOnlySubtabAlwaysOpenVisible()
                .resetFiltersToDefault(SUBTAB_ACTIVE_COLOR, ALWAYS_OPEN_SUBTAB)
                .selectSubtab(OPEN_NOW_SUBTAB)
                .assertOnlySubtabOpenNowVisible()
                .resetFiltersToDefault(SUBTAB_ACTIVE_COLOR, OPEN_NOW_SUBTAB)
                .selectTab(TAB_BRANCHES)
                .assertOnlyBranchesTabVisible()
                .selectSubtab(ALWAYS_OPEN_SUBTAB)
                .assertOnlySubtabAlwaysOpenVisible()
                .resetFiltersToDefault(SUBTAB_ACTIVE_COLOR, ALWAYS_OPEN_SUBTAB)
                .selectSubtab(OPEN_NOW_SUBTAB)
                .assertOnlySubtabOpenNowVisible()
                .resetFiltersToDefault(SUBTAB_ACTIVE_COLOR, OPEN_NOW_SUBTAB)
                .selectTab(TAB_ALL)
                .assertDefaultBranchesVisible(defaultBranches);

        /*
         I need to assert:
         - Default Tab State
         - Switch to ATM -> Only ATMS are visible on the menu
            - click 24/7 subtab and validate that there are only 24/7 ATMS available
            - click Open now subtab and validate the same
            - apply both and validate the same thing
         - Switch to Branches -> Only Branches are visible
            - click 24/7 subtab and validate that there are only 24/7 Branches available
            - click Open now subtab and validate the same
            - apply both and validate the same thing

         - Rest All filters and assert that we've got 'defaultBranches'
         */
    }
}
