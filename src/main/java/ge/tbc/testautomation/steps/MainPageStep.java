package ge.tbc.testautomation.steps;

import com.codeborne.selenide.Condition;
import ge.tbc.testautomation.pages.MainPage;

@SuppressWarnings("UnusedReturnValue")
public class MainPageStep {
    private final MainPage mainPage = new MainPage();

    public MainPageStep rejectAllCookies() {
        // if (mainPage.cookieConsentRejectAllButtonLocator.isDisplayed()) {}
        mainPage.cookieConsentRejectAllButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageStep clickQuickActionButton() {
        mainPage.quickNavigationActivationButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageStep clickQuickActionLocationButton() {
        mainPage.quickNavigationLocationButtonLocator.shouldBe(Condition.clickable).click();
        return this;
    }
}