package ge.tbc.testautomation.steps;

import com.codeborne.selenide.*;
import ge.tbc.testautomation.pages.MainPage;
import ge.tbc.testautomation.utils.Helpers;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class MainPageStep {
    private final MainPage mainPage = new MainPage();
    private final Helpers helpers = new Helpers();

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

    public MainPageStep clickHamburgerMenuButton() {
        mainPage.navbarHamburgerMenuButtonLocator.shouldBe(Condition.visible).click();
        return this;
    }

    public MainPageStep selectNavbarTab(String tabName) {
        mainPage.navbarTabLocator(tabName).shouldBe(Condition.visible).click();
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

    public MainPageStep assertCorrectTabVisible() {
        Assert.assertEquals(
                mainPage.megaMenuActiveTabLocator.getText(),
                mainPage.megaMenuLabelNameLocator.getText(),
                "Wrong Tab."
        );
        return this;
    }

    public MainPageStep assertMegaMenuNotEmpty() {
        mainPage.megaMenuSubGroupsLocator.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    public MainPageStep assertMegaMenuLanguageSwitcherPresent() {
        mainPage.megaMenuLanguageSwitcherLocator.should(Condition.exist);
        return this;
    }

    public MainPageStep assertStickyNavbar() {
        Long yBefore = helpers.getElementPosition(mainPage.navbarLocator);
        Selenide.executeJavaScript("window.scrollBy(0, 200)");
        Long yAfter = helpers.getElementPosition(mainPage.navbarLocator);

        Assert.assertEquals(yBefore, yAfter);
        return this;
    }

    public MainPageStep assertMegaMenuQuickActionsPresent(String... QuickActionLabels) {
        for (String label : QuickActionLabels) {
            mainPage.megaMenuQuickActionLocator(label).should(Condition.exist);
        }

        return this;
    }
}