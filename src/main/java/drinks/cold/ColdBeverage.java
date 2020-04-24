package drinks.cold;

import drinks.Beverage;
import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class ColdBeverage extends Beverage {
    //todo: can be drank in a glass, bottle or can
    public ColdBeverage(BeverageType drinkType) {
        super(drinkType);
    }
    public boolean hasIce() {
        return ingredients.contains(IngredientType.Ice);
    }

    @Override
    public BeverageTemperature getTemperature() {
        if(drinkType.equals(BeverageType.Spirit)) {
            if(!hasIce()) {
                return BeverageTemperature.ROOM_TEMPERATURE;
            }
        } else {
            if(hasIce()) {
                return BeverageTemperature.EXTREMELY_COLD;
            }
        }
        return BeverageTemperature.COLD;
    }
    public String getTips() {
        return "Did you hear about the guy who got hit in the head with a can of Coke? He was lucky it was a soft drink.";
    }

}
