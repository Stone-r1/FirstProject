package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Offers: apply filters; validate results; reset filters restores defaults.")
public class OffersFilterTest extends BaseTest {
    private final OffersSteps offersSteps = new OffersSteps();

    @Override
    protected void openTestPage() {
        open(TBC_ALL_OFFERS);
    }

    @Test
    public void testOffersFilter() {
        int defaultOffersSize;

        defaultOffersSize = offersSteps.getOffersSnapshotSize();
        offersSteps
                .selectCardType(MASTERCARD_CARD_TYPE)
                .assertOnlyRelevantOffers()
                .deselectCardType()
                .assertDefaultOffersPresent(defaultOffersSize);
    }
}