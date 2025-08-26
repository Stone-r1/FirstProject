package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.MainPageSteps;
import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Card Type Filters Validity on All-Offers Page. [SCRUM-T4]")
public class OffersFilterTest extends BaseTest {
    private final OffersSteps offersSteps = new OffersSteps();
    private final MainPageSteps mainPageStep = new MainPageSteps();

    @Override
    protected void openTestPage() {
        open(TBC_ALL_OFFERS);
    }

    @Test
    public void testOffersFilter() {
        int defaultOffersSize;

        mainPageStep.rejectAllCookies();

        defaultOffersSize = offersSteps.getOffersSnapshotSize();
        offersSteps
                .selectCardType(MASTERCARD_CARD_TYPE)
                .assertOnlyRelevantOffers()
                .deselectCardType()
                .assertDefaultOffersPresent(defaultOffersSize);
    }
}