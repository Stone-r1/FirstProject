package ge.tbc.testautomation.steps;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.pages.MainPage;
import ge.tbc.testautomation.utils.Helpers;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class MainPageSteps {
    private final MainPage mainPage = new MainPage();
    private final Helpers helpers = new Helpers();

    // ============== Helpers =================
    public ElementsCollection getSearchResults() {
        return mainPage.searchResultItemsLocator;
    }

    // ============== Actions =================
    public MainPageSteps rejectAllCookies() {
        // if (mainPage.cookieConsentRejectAllButtonLocator.isDisplayed()) {}
        mainPage.cookieConsentRejectAllButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageSteps clickQuickActionButton() {
        mainPage.quickNavigationActivationButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageSteps clickQuickActionLocationButton() {
        mainPage.quickNavigationLocationButtonLocator.shouldBe(Condition.clickable).click();
        return this;
    }

    public MainPageSteps clickNavbarSearchButton() {
        mainPage.searchButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageSteps clickHamburgerMenuButton() {
        mainPage.navbarHamburgerMenuButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageSteps selectNavbarTab(String tabName) {
        mainPage.navbarTabLocator(tabName).shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageSteps enterKeyword(String keyword) {
        // clear previous input first
        mainPage.searchInputLocator
                .shouldBe(Condition.visible)
                .clear();
        mainPage.searchInputLocator
                .shouldBe(Condition.visible)
                .setValue(keyword);
        return this;
    }

    public MainPageSteps goToSearchedPage(SelenideElement searchedPage) {
        mainPage.searchResultItemShowMoreLocator(searchedPage).shouldBe(Condition.visible).click();
        return this;
    }

    // ============ Assertions ================
    public MainPageSteps assertSearchEmpty() {
        mainPage.searchResultNotFoundLocator.shouldBe(Condition.visible);
        return this;
    }

    public MainPageSteps assertSearchNotEmpty() {
        mainPage.searchResultItemsLocator.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public MainPageSteps assertCorrectTabVisible() {
        Assert.assertEquals(
                mainPage.megaMenuActiveTabLocator.getText(),
                mainPage.megaMenuLabelNameLocator.getText(),
                "Wrong Tab."
        );
        return this;
    }

    public MainPageSteps assertMegaMenuNotEmpty() {
        mainPage.megaMenuSubGroupsLocator.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public MainPageSteps assertMegaMenuLanguageSwitcherPresent() {
        mainPage.megaMenuLanguageSwitcherLocator.should(Condition.exist);
        return this;
    }

    public MainPageSteps assertStickyNavbar() {
        Long yBefore = helpers.getElementPosition(mainPage.navbarLocator);
        Selenide.executeJavaScript("window.scrollBy(0, 200)", mainPage.megaMenuSubNavigationFieldLocator);
        Long yAfter = helpers.getElementPosition(mainPage.navbarLocator);

        Assert.assertEquals(yBefore, yAfter);
        return this;
    }

    public MainPageSteps assertMegaMenuQuickActionsPresent(String... QuickActionLabels) {
        for (String label : QuickActionLabels) {
            mainPage.megaMenuQuickActionLocator(label).should(Condition.exist);
        }

        return this;
    }
}