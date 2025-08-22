package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.MainPage;

public class LocationFilterSteps {
    private final MainPage mainPage = new MainPage();

    public LocationFilterSteps clickQuickActionButton() {
        mainPage.quickNavigationActivationButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public LocationFilterSteps clickQuickActionLocationButton() {
        mainPage.quickNavigationLocationButtonLocator.shouldBe(Condition.clickable).click();
        return this;
    }
}