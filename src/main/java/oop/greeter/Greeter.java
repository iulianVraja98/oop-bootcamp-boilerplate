package oop.greeter;

import java.time.LocalTime;

public class Greeter {
    private final LocalTime localTime;

    public Greeter(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String greet(String name) {
        name = name.trim();
        name = capitalizeFirstLetter(name);
        String timeLine = defineGreetingPhraseFromTime();

        return timeLine + name;
    }

    private String defineGreetingPhraseFromTime() {
        String greetingPhrase = "Hello ";

        if (isMorningTime()) {
            greetingPhrase = "Good morning ";
        } else if (isEveningTime()) {
            greetingPhrase = "Good evening ";
        }

        return greetingPhrase;
    }

    private boolean isEveningTime() {
        return localTime.isBefore(LocalTime.parse("22:00:00"))
            && localTime.isAfter(LocalTime.parse("17:59:59"));
    }

    private boolean isMorningTime() {
        return localTime.isBefore(LocalTime.parse("12:00:00"))
            && localTime.isAfter(LocalTime.parse("05:59:59"));
    }

    public String capitalizeFirstLetter(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
