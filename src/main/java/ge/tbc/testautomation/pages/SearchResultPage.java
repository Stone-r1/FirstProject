package ge.tbc.testautomation.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultPage {
    public ElementsCollection matchingTextLocator(String text, String alphabet) {
        return $$x(String.format(
                "//*[contains(translate(normalize-space(text()), '%s', '%s'), '%s')]",
                alphabet.toUpperCase(),
                alphabet.toUpperCase(),
                text.toLowerCase())
        );
    }
}
