package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public final SelenideElement cookieConsentRejectAllButtonLocator = $x("//button[normalize-space(text())='Reject All']");

    // Navbar Navigation
    public final SelenideElement navbarHamburgerMenuButtonLocator = $("tbcx-pw-hamburger-menu");
    public final SelenideElement navbarLocator = $("tbcx-pw-mega-menu-navigation");

    public final SelenideElement navbarTabLocator(String tabName) {
        return navbarLocator.$x(String.format(
                ".//button[normalize-space(text())='%s']",
                tabName
        ));
    }

    // Mega Menu
    public final ElementsCollection megaMenuSubGroupsLocator = $$("tbcx-pw-mega-menu-sub-group");
    public final SelenideElement megaMenuLanguageSwitcherLocator = $x("//tbcx-pw-mega-menu-bottom//tbcx-lang-switcher");
    public final SelenideElement megaMenuActiveTabLocator = $x("//tbcx-pw-mega-menu-navigation//div[contains(@class, 'active')]/button");
    public final SelenideElement megaMenuLabelNameLocator = $x("//tbcx-pw-mega-menu-sub-navigation//div[@tbcxpwlinklabel]");

    public final SelenideElement megaMenuQuickActionLocator(String actionName) {
        return $x(String.format(
                "//tbcx-pw-mega-menu-quick-acitons-item//span[normalize-space(text())='%s']",
                actionName
        ));
    }

    // Quick Navigation
    public final SelenideElement quickNavigationActivationButtonLocator = $x("//app-quick-action-button/button[contains(@class, 'primary')]");
    public final SelenideElement quickNavigationLocationButtonLocator = $x("//app-quick-action-button//tbcx-icon[contains(@style, 'location-pin-outlined')]");

    // Search
    public final ElementsCollection searchResultItemsLocator = $$("app-search-result-item");
    public final SelenideElement searchButtonLocator = $x("//tbcx-icon[contains(@style, 'search-outlined')]");
    public final SelenideElement searchInputLocator = $("#tbcx-text-input-1");
    public final SelenideElement searchResultNotFoundLocator = $x("//p[normalize-space(text())=\"We couldn't find anything.\"]");

    public final SelenideElement searchResultItemShowMoreLocator(SelenideElement resultItem) {
        return resultItem.$("tbcx-pw-button");
    }
}
