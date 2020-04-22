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
    public boolean hasExtras() {return super.hasExtras();}

    @Override
    public BeverageTemperature getTemperature() {
        if(hasIce()) {
            return BeverageTemperature.EXTREMELY_COLD;
        }
        return BeverageTemperature.COLD;
    }
}
