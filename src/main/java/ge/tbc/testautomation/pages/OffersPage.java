package ge.tbc.testautomation.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersPage {
    // Category Sections
    public SelenideElement filterChipButtonLocator = $x("//app-marketing-filter-chip/div[@tbcxpwclickaction]");
    public SelenideElement filterButtonLocator = $x("//tbcx-pw-button[not(@class)]/button");

    public SelenideElement cardTypeClearButtonLocator = $$x(
            "//tbcx-pw-button[@class]/button[not(*)] | //h3[normalize-space(.)='Card Type']/following-sibling::button[normalize-space(text())='Clear']"
    ).find(Condition.visible);

    public SelenideElement cardTypeCheckBoxLocator(String cardType) {
        return $$x(String.format(
                "//h3[normalize-space(text())='Card Type']/following::div[normalize-space(.)='%s']/input",
                cardType
        )).find(Condition.visible); // <- only visible one
    }

    // Offers
    public ElementsCollection allOffersLocator = $$x("//app-marketing-list//a");
    public SelenideElement cardInfoMastercardPresentLocator(SelenideElement offer) {
        return offer.$x(".//div[contains(@class, 'card__info')]//div[normalize-space(text())='Mastercard']");
    }
}
