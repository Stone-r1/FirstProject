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
    private ElementsCollection branches;

    public LocationPageStep enterLocation(String location) {
        locationPage.searchBarLocator.shouldBe(Condition.visible).sendKeys(location);
        return this;
    }

    public LocationPageStep getRelevantBranches() {
        branches = locationPage.branchesListLocator.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public LocationPageStep assertOnlyRelevantLocationsDisplayed(String location) {
        Assert.assertTrue(
                branches.stream()
                        .map(locationPage::getTextFromLocation)
                        .map(SelenideElement::getText)
                        .map(String::toLowerCase)
                        .allMatch(text -> text.contains(location.toLowerCase())),
                "There Are Irrelevant Branches."
        );
        return this;
    }
}
