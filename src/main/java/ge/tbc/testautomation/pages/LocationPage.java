package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LocationPage {
    public final SelenideElement searchBarLocator = $("#tbcx-text-input-1");

    // Tabs / Sub-tabs
    public final SelenideElement allTabLocator = $x("//button[span[normalize-space(text())='All']]");
    public final SelenideElement branchesTabLocator = $x("//button[span[normalize-space(text())='Branches']]");
    public final SelenideElement atmsTabLocator = $x("//button[span[normalize-space(text())='ATMs']]");
    public final SelenideElement alwaysOpenSubtabLocator = $x("//span[normalize-space(text())='24/7']");
    public final SelenideElement openNowSubtabLocator = $x("//span[normalize-space(text())='Open now']");

    // Locations(Branches) / Intel about locations(Branches)
    public final ElementsCollection branchesListLocator = $$("app-atm-branches-section-list-item");

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
