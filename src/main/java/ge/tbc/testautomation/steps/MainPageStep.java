package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.MainPage;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public class MainPageStep {
    private final MainPage mainPage = new MainPage();

    // ============== Helpers =================
    public ElementsCollection getSearchResults() {
        return mainPage.searchResultItemsLocator;
    }

    // ============== Actions =================
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

    public MainPageStep clickNavbarSearchButton() {
        mainPage.searchButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageStep enterKeyword(String keyword) {
        // clear previous input first
        mainPage.searchInputLocator
                .shouldBe(Condition.visible)
                .clear();
        mainPage.searchInputLocator
                .shouldBe(Condition.visible)
                .setValue(keyword);
        return this;
    }

    public MainPageStep goToSearchedPage(SelenideElement searchedPage) {
        mainPage.searchResultItemShowMoreLocator(searchedPage).shouldBe(Condition.visible).click();
        return this;
    }

    // ============ Assertions ================
    public MainPageStep assertSearchEmpty() {
        mainPage.searchResultNotFoundLocator.shouldBe(Condition.visible);
        return this;
    }

    public MainPageStep assertSearchNotEmpty() {
        mainPage.searchResultItemsLocator.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }
}