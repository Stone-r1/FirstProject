package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.LocationPage;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class LocationPageStep {
    private final LocationPage locationPage = new LocationPage();

    public ElementsCollection getBranches() {
        return locationPage.branchesListLocator.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    public LocationPageStep enterLocation(String location) {
        locationPage.searchBarLocator
                .shouldBe(Condition.visible)
                .setValue(location);
        return this;
    }

    // ============ Assertions ================

    public LocationPageStep assertMapPinsCountDecreased(int branchesBeforeSearch) {
        locationPage.branchesListLocator.shouldHave(CollectionCondition.sizeLessThanOrEqual(branchesBeforeSearch));
        return this;
    }

    public LocationPageStep assertOnlyRelevantLocationsDisplayed(String location, int branchesBeforeSearch) {
        Assert.assertTrue(
                locationPage.branchesListLocator
                        .shouldHave(CollectionCondition.sizeLessThan(branchesBeforeSearch))
                        .asFixedIterable().stream()
                        .map(locationPage::getBranchLocationTitleLocator)
                        .map(SelenideElement::getText)
                        .map(String::toLowerCase)
                        .allMatch(text -> text.contains(location.toLowerCase())),
                "There Are Irrelevant Branches." );
        return this;
    }

    public LocationPageStep assertDetailsAreVisibleOnBar() {
        Assert.assertTrue(
                locationPage.branchesListLocator
                        .shouldHave(CollectionCondition.sizeGreaterThan(0))
                        .asFixedIterable().stream()
                        .map(locationPage::getBranchMarkerTypeLocator)
                        .map(SelenideElement::getText)
                        .noneMatch(String::isEmpty),
                "Branch Marker Is Not Visible."
        );

        Assert.assertTrue(
                locationPage.branchesListLocator
                        .shouldHave(CollectionCondition.sizeGreaterThan(0))
                        .asFixedIterable().stream()
                        .map(locationPage::getBranchWorkingHoursLocator)
                        .map(SelenideElement::getText)
                        .noneMatch(String::isEmpty),
                "Branch Working Hours Field Is Not Visible."
        );
        return this;
    }
}