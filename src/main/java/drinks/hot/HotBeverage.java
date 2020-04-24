package drinks.hot;
import drinks.Beverage;
import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;

import static drinks.bar.IngredientType.*;

public class HotBeverage extends Beverage {

    public HotBeverage(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public BeverageTemperature getTemperature() {
        if(hasMilk()) {
            if(ingredients.contains(Ice)) {
                return BeverageTemperature.ROOM_TEMPERATURE;
            }
            return BeverageTemperature.WARM;
        } else if(ingredients.contains(Ice)) {
            return BeverageTemperature.WARM;
        }
        return BeverageTemperature.HOT;
    }

    public boolean hasMilk() {
        return ingredients.contains(Milk);
    }

    public boolean hasSugar() {
        return ingredients.contains(Sugar);
    }

    @Override
    public String getTips() {
        return "How do you make holy water? Boil the hell out of it.";
    }
//    source: http://www.jokes4us.com/miscellaneousjokes/foodjokes/beveragejokes.html
}
