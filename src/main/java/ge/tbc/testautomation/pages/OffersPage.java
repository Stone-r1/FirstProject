package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class OffersPage {
    // Category Sections
    public SelenideElement cardTypeClearButtonLocator = $x("//h3[normalize-space(.)='Card Type']/following-sibling::button[normalize-space(text())='Clear']");
    public SelenideElement cardTypeCheckBoxLocator(String cardType) {
        return $x(String.format(
                "//h3[normalize-space(text())='Card Type']/following::div[normalize-space(.)='%s']/input",
                cardType
        ));
    }

    // Offers
    public ElementsCollection allOffersLocator = $$x("//app-marketing-list//a");
    public SelenideElement cardInfoMastercardPresentLocator(SelenideElement offer) {
        return offer.$x(".//div[contains(@class, 'card__info')]//div[normalize-space(text())='Mastercard']");
    }
}
