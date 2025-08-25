package ge.tbc.testautomation.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.OffersPage;
import ge.tbc.testautomation.utils.Helpers;
import org.testng.Assert;

@SuppressWarnings("UnusedReturnValue")
public class OffersSteps {
    private final OffersPage offersPage = new OffersPage();
    private final Helpers helpers = new Helpers();

    // ============== Helpers =================
    public int getOffersSnapshotSize() {
        return offersPage.allOffersLocator.shouldHave(CollectionCondition.sizeGreaterThan(0)).size();
    }

    // ============== Actions =================
    public OffersSteps selectCardType(String... cardOption) {
        for (String option : cardOption) {
            offersPage.cardTypeCheckBoxLocator(option)
                    .scrollIntoCenter()
                    .shouldBe(Condition.clickable)
                    .click();
        }
        return this;
    }

    public OffersSteps deselectCardType() {
        offersPage.cardTypeClearButtonLocator.shouldBe(Condition.clickable).click();
        return this;
    }

    // ============ Assertions ================
    public OffersSteps assertOnlyRelevantOffers() {
        for (SelenideElement element : offersPage.allOffersLocator.shouldHave(CollectionCondition.sizeGreaterThan(0))) {
            offersPage.cardInfoMastercardPresentLocator(element)
                    .should(Condition.exist);
        }
        return this;
    }

    public OffersSteps assertDefaultOffersPresent(int defaultOffersCount) {
        Assert.assertEquals(defaultOffersCount, getOffersSnapshotSize());
        return this;
    }
}
