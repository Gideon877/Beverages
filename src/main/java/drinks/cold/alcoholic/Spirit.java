package drinks.cold.alcoholic;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;

public class Spirit extends AlcoholicBeverage {
    // todo: take a shot or drink in a glass (based on extras - ice)
    public Spirit(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public BeverageTemperature getTemperature() {
        if(hasIce()) {
            return BeverageTemperature.COLD;
        }
        return BeverageTemperature.ROOM_TEMPERATURE;
    }
}
