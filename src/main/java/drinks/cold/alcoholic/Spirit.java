package drinks.cold.alcoholic;

import drinks.bar.BeverageType;

import static drinks.util.Colors.RED_BRIGHT;
import static drinks.util.Colors.RESET;

public class Spirit extends AlcoholicBeverage {
    // todo: take a shot or drink in a glass (based on extras - ice)
    public Spirit(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public String getTips() {
        return "Take a shot and drink responsibly. " + RED_BRIGHT +
                super.getTips()  + RESET;
    }
}
