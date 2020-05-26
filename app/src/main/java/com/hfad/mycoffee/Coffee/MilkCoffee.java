package com.hfad.mycoffee.Coffee;

import com.hfad.mycoffee.R;

public class MilkCoffee extends Coffee {

    public MilkCoffee(String name, String description, int imageResourceId) {
        super(name, description, imageResourceId);
    }

    public static final Coffee [] coffee = {
            new MilkCoffee("Cappucino", "włoski napój kawowy z dodatkiem spienionego mleka (rzadziej z bitą śmietaną) i szczyptą sypkiej czekolady lub kakao dla ozdoby", R.drawable.cappucino),
            new MilkCoffee("CaffeLatte", "włoski napój kawowy powstający w wyniku wlania podgrzanego mleka do kawy espresso.",R.drawable.caffelatte),
            new MilkCoffee("Latte Macchiato", "napój mleczny powstały przez powolne (delikatnie, po ściance) dolanie kawy espresso do gorącego mleka, pokrytego warstwą mlecznej piany",R.drawable.latte_macchiato),
            new MilkCoffee("Flat White", "przygotowywany poprzez zalanie jednej lub dwóch porcji espresso spienionym mlekiem o jednorodnej, aksamitnej konsystencji", R.drawable.flat_white),
            new MilkCoffee("Mleko", "ciepłe, spienione mleko jest mieszaniną wieloskładnikową, składająca się z trzech podstawowych faz, będących w ścisłej zależności od siebie: emulsyjnej, koloidalnej i molekularnej.", R.drawable.mleko)
    };

}
