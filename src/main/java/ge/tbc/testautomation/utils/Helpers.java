package ge.tbc.testautomation.utils;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Helpers {
    public boolean isOpen(String scheduleTimes) {
        if (scheduleTimes.equalsIgnoreCase("24/7")) {
            return true;
        }

        Map<String, String[]> schedule = new HashMap<>();
        Pattern pattern = Pattern.compile("(\\w+):\\s*(\\d{1,2}:\\d{2})-(\\d{1,2}:\\d{2})");
        Matcher matcher = pattern.matcher(scheduleTimes.toLowerCase());

        while (matcher.find()) {
            schedule.put(matcher.group(1), new String[]{matcher.group(2), matcher.group(3)});
        }

        String[] times = schedule.getOrDefault(LocalDateTime.now().getDayOfWeek().toString().toLowerCase(), schedule.get("week"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
        LocalTime startTime = LocalTime.parse(times[0], formatter);
        LocalTime endTime = LocalTime.parse(times[1], formatter);

        return !LocalDateTime.now().toLocalTime().isBefore(startTime) && !LocalDateTime.now().toLocalTime().isAfter(endTime);
    }

    public List<SelenideElement> getStaticSnapshot(ElementsCollection branches) {
        ElementsCollection stable = branches.shouldHave(CollectionCondition.sizeGreaterThan(0));
        return stable.asFixedIterable().stream().collect(Collectors.toList());
    }

    public String getAlphabet() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public Long getElementPosition(SelenideElement element) {
        Number value = Selenide.executeJavaScript(
                "return arguments[0].getBoundingClientRect().top;",
                element
        );
        return value.longValue();
    }
}