package drinks.cold.alcoholic;

import drinks.bar.BeverageType;
import drinks.cold.ColdBeverage;

public class AlcoholicBeverage extends ColdBeverage {
    // todo: add age restriction for persons < 18
    public AlcoholicBeverage(BeverageType drinkType) {
        super(drinkType);
    }
}
