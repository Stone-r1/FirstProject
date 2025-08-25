package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.LocationPage;
import ge.tbc.testautomation.utils.Helpers;
import org.testng.Assert;

import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class LocationPageStep {
    private final LocationPage locationPage = new LocationPage();
    private final Helpers helpers = new Helpers();

    // ============== Helpers =================
    public ElementsCollection getBranches() {
        return locationPage.branchesListLocator.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    // ============== Actions =================
    public LocationPageStep enterLocation(String location) {
        locationPage.searchBarLocator
                .shouldBe(Condition.visible)
                .setValue(location);
        return this;
    }

    public LocationPageStep selectTab(String tabName) {
        locationPage.getTabLocator(tabName)
                .shouldBe(Condition.clickable)
                .click();
        return this;
    }

    public LocationPageStep selectSubtab(String subtabName) {
        locationPage.getSubtabLocator(subtabName)
                .shouldBe(Condition.visible)
                .scrollIntoView("{block: \"center\"}")
                .shouldBe(Condition.enabled)
                .click();
        return this;
    }

    public LocationPageStep resetFiltersToDefault(String activeValue, String... subtabNames) {
        for (String subtabName : subtabNames) {
            if (locationPage.getSubtabLocator(subtabName).getCssValue("background-color").equals(activeValue)) {
                locationPage.getSubtabLocator(subtabName).shouldBe(Condition.clickable).click();
            }
        }
        return this;
    }

    // ============ Assertions ================
    public LocationPageStep assertMapPinsCountDecreased(int branchesBeforeSearch) {
        locationPage.branchesListLocator
                .shouldHave(CollectionCondition.sizeLessThanOrEqual(branchesBeforeSearch))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public LocationPageStep assertOnlyRelevantLocationsDisplayed(String location, int branchesBeforeSearch) {
        List<String> branchTitles = helpers
                .getStaticSnapshot(
                        locationPage.branchesListLocator
                                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                                .shouldHave(CollectionCondition.sizeLessThanOrEqual(branchesBeforeSearch)))
                .stream()
                .map(locationPage::getBranchLocationTitleLocator)
                .map(SelenideElement::getText)
                .map(String::toLowerCase)
                .toList();

        Assert.assertTrue(
                branchTitles.stream().allMatch(text -> text.contains(location.toLowerCase())),
                "There are irrelevant branches."
        );

        return this;
    }

    public LocationPageStep assertDetailsAreVisibleOnBar() {
        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchMarkerTypeLocator)
                        .map(SelenideElement::getText)
                        .noneMatch(String::isEmpty),
                "Branch Marker Is Not Visible."
        );

        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchWorkingHoursLocator)
                        .map(SelenideElement::getOwnText)
                        .noneMatch(String::isEmpty),
                "Branch Working Hours Field Is Not Visible."
        );
        return this;
    }

    // ============ Tabs and Subtabs =============
    public LocationPageStep assertOnlyATMTabVisible() {
        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchMarkerTypeLocator)
                        .map(SelenideElement::getText)
                        .allMatch(text -> text.contains("ATM")),
                "There Are Irrelevant Locations."
        );
        return this;
    }

    public LocationPageStep assertOnlyBranchesTabVisible() {
        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchMarkerTypeLocator)
                        .map(SelenideElement::getText)
                        .noneMatch(text -> text.contains("ATM")),
                "There Are Irrelevant Locations."
        );
        return this;
    }

    public LocationPageStep assertOnlySubtabAlwaysOpenVisible() {
        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchWorkingHoursLocator)
                        .map(SelenideElement::getOwnText)
                        .allMatch(text -> text.contains("24/7")),
                "There Are Irrelevant Locations."
        );
        return this;
    }

    public LocationPageStep assertOnlySubtabOpenNowVisible() {
        Assert.assertTrue(
                helpers.getStaticSnapshot(locationPage.branchesListLocator)
                        .stream()
                        .map(locationPage::getBranchWorkingHoursLocator)
                        .map(SelenideElement::getOwnText)
                        .map(String::trim)
                        .allMatch(helpers::isOpen),
                "There Are Irrelevant Locations."
        );
        return this;
    }

    public LocationPageStep assertDefaultBranchesVisible(List<SelenideElement> defaultBranches) {
        locationPage.branchesListLocator.shouldHave(
                CollectionCondition.size(defaultBranches.size())
        );

        Assert.assertEquals(
                locationPage.branchesListLocator.size(),
                defaultBranches.size(),
                "Default Branches Are Not Visible."
        );
        return this;
    }
}