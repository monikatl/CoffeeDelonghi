package com.hfad.mycoffee.Coffee;

import com.hfad.mycoffee.R;

public class Espresso extends Coffee {

    private final String name = "Espresso";
    private final String description = "nazwa sposobu przygotowywania kawy w specjalnym ekspresie, przez przepuszczenie 25-35 ml gorącej (90,5-96 °C) wody pod ciśnieniem 8,5-9,5 bara.";
    private final int imageResource = R.drawable.espresso;

    private Capacity capacity;
    private Intensity intensity;

    public Espresso() {
        setDescription(description);
        setName(name);
        setImageResourceId(imageResource);
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public enum Capacity {
        VERY_SMALL("bardzo mała"),
        SMALL("mała"),
        NORMAL("normalna"),
        LARGE("duza"),
        GREAT_BIG("bardzo duza");

        String levelCapacity;

        Capacity(String levelCapacity) {
            this.levelCapacity = levelCapacity;
        }

        public String getLevelCapacity() {
            return levelCapacity;
        }
    }

    public enum Intensity {
        VERY_GENTLE("bardzo łagodna"),
        GENTLE("łagodna"),
        NORMAL("normalna"),
        STRONG("mocna"),
        VERY_STRONG("bardzo mocna");

        String levelIntensity;

        Intensity(String levelIntensity) {
            this.levelIntensity = levelIntensity;
        }

        public String getLevelIntensity() {
            return levelIntensity;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getName())
                                    .append(System.lineSeparator())
                                    .append('*')
                                    .append(capacity.getLevelCapacity().toUpperCase())
                                    .append(System.lineSeparator())
                                    .append('*')
                                    .append(intensity.getLevelIntensity().toUpperCase())
                                    .toString();
    }
}
