package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;
import drinks.cold.ColdBeverage;

class NonAlcoholicBeverage extends ColdBeverage {
    public NonAlcoholicBeverage(BeverageType drinkType) {
        super(drinkType);
    }
    @Override
    public String getTips() {
        return "Did you hear about the guy who got hit in the head with a can of Coke? He was lucky it was a soft drink.";
    }
}
