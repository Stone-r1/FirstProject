package ge.tbc.testautomation.tests;


import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.MainPageSteps;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(description = "Mobile Hamburger Menu & Sticky Navbar Validation. [SCRUM-T5]")
public class HamburgerMenuTest extends BaseTest {
    private final MainPageSteps mainPageStep = new MainPageSteps();

    @Override
    protected void openTestPage() {
        open(TBC_MAIN_URL);
    }

    @Test
    public void hamburgerMenuTest() {
        mainPageStep
                .rejectAllCookies()
                .clickHamburgerMenuButton()
                .selectNavbarTab(TAB_PERSONAL_TEXT)
                .assertCorrectTabVisible()
                .assertMegaMenuLanguageSwitcherPresent()
                .assertMegaMenuNotEmpty()
                .assertCorrectTabVisible()
                .assertStickyNavbar()
                .assertMegaMenuQuickActionsPresent(
                        CURRENCY_EXCHANGE_TEXT,
                        LOCATIONS_TEXT,
                        OFFERS_TEXT
                );
    }
}
