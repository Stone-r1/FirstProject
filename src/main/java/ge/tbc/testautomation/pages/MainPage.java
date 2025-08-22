package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    // public final SelenideElement navigationBarPersonalLocator = $x("//div[@class='tbcx-pw-navigation-item']//a[@href='/en' or @href='/ka']");
    public final SelenideElement quickNavigationActivationButtonLocator = $x("//app-quick-action-button/button[contains(@class, 'primary')]");
    public final SelenideElement quickNavigationLocationButtonLocator = $x("//app-quick-action-button//tbcx-icon[contains(@style, 'location-pin-outlined')]");
}
