package erettsegik.majus2020.metjelentes;

import packages.greetings.Greeter;

import java.util.Optional;

public class Temperatures {
    private Optional<Integer> egy = Optional.empty();
    private Optional<Integer> het = Optional.empty();
    private Optional<Integer> tisenharom = Optional.empty();
    private Optional<Integer> tizenkilenc = Optional.empty();
    private int min = 100;
    private int max = -1;

    public boolean isAverage() {
        return egy.isPresent() && het.isPresent() && tisenharom.isPresent() && tizenkilenc.isPresent();
    }

    public int getAverage() {
        return (int) ((0.5 + egy.get() + het.get() + tisenharom.get() + tizenkilenc.get()) / 4);
    }

    public int getDifference() {
        return max - min;
    }

    public Temperatures store(int value, int time) {
        switch (time) {
            case 1 -> egy = Optional.of(value);
            case 7 -> het = Optional.of(value);
            case 13 -> tisenharom = Optional.of(value);
            case 19 -> tizenkilenc = Optional.of(value);
        }

        min = Math.min(min, value);
        max = Math.max(max, value);
        return this;
    }
}
