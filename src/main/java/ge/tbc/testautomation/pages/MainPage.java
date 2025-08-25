package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public SelenideElement cookieConsentRejectAllButtonLocator = $x("//button[normalize-space(text())='Reject All']");

    // Navbar Navigation
    public SelenideElement navbarHamburgerMenuButtonLocator = $("tbcx-pw-hamburger-menu");
    public SelenideElement navbarLocator = $("tbcx-pw-mega-menu-navigation");

    public SelenideElement navbarTabLocator(String tabName) {
        return navbarLocator.$x(String.format(
                ".//button[normalize-space(text())='%s']",
                tabName
        ));
    }

    // Mega Menu
    public ElementsCollection megaMenuSubGroupsLocator = $$("tbcx-pw-mega-menu-sub-group");
    public SelenideElement megaMenuLanguageSwitcherLocator = $x("//tbcx-pw-mega-menu-bottom//tbcx-lang-switcher");
    public SelenideElement megaMenuActiveTabLocator = $x("//tbcx-pw-mega-menu-navigation//div[contains(@class, 'active')]/button");
    public SelenideElement megaMenuLabelNameLocator = $x("//tbcx-pw-mega-menu-sub-navigation//div[@tbcxpwlinklabel]");

    public SelenideElement megaMenuQuickActionLocator(String actionName) {
        return $x(String.format(
                "//tbcx-pw-mega-menu-quick-acitons-item//span[normalize-space(text())='%s']",
                actionName
        ));
    }

    // Quick Navigation
    public SelenideElement quickNavigationActivationButtonLocator = $x("//app-quick-action-button/button[contains(@class, 'primary')]");
    public SelenideElement quickNavigationLocationButtonLocator = $x("//app-quick-action-button//tbcx-icon[contains(@style, 'location-pin-outlined')]");

    // Search
    public ElementsCollection searchResultItemsLocator = $$("app-search-result-item");
    public SelenideElement searchButtonLocator = $x("//tbcx-icon[contains(@style, 'search-outlined')]");
    public SelenideElement searchInputLocator = $("#tbcx-text-input-1");
    public SelenideElement searchResultNotFoundLocator = $x("//p[normalize-space(text())=\"We couldn't find anything.\"]");

    public SelenideElement searchResultItemShowMoreLocator(SelenideElement resultItem) {
        return resultItem.$("tbcx-pw-button");
    }
}
