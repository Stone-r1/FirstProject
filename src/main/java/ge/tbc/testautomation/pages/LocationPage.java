package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LocationPage {
    public SelenideElement searchBarLocator = $("#tbcx-text-input-1");

    // Tabs / Sub-tabs
    public SelenideElement getTabLocator(String tabName) {
        // Pass "ATM" or "ATMs". Both cases will operate as intended
        return $x(String.format(
                "//button[span[contains(normalize-space(text()), '%s')]]",
                tabName));
    }

    public SelenideElement getSubtabLocator(String subtabName) {
        return $x(String.format(
                "//span[normalize-space(text())='%s']",
                subtabName));
    }

    // Locations(Branches) / Intel about locations(Branches)
    public ElementsCollection branchesListLocator = $$("app-atm-branches-section-list-item");

    public SelenideElement getBranchLocationTitleLocator(SelenideElement location) {
        return location.$x(".//div[@tbcx-pw-title]");
    }

    public SelenideElement getBranchMarkerTypeLocator(SelenideElement location) {
        return location.$x(".//div[contains(@class, 'label')]");
    }

    public SelenideElement getBranchWorkingHoursLocator(SelenideElement location) {
        return location.$x(".//div[contains(@class, 'description')]");
    }
}
