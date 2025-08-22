package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocationPage {
    public final SelenideElement searchBarLocator = $("#tbcx-text-input-1");
    public final ElementsCollection branchesListLocator = $$("app-atm-branches-section-list-item");

    public SelenideElement getTextFromLocation(SelenideElement location) {
        return location.$x(".//div[@tbcx-pw-title]");
    }
}
