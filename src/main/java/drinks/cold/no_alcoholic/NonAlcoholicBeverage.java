package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;
import drinks.cold.ColdBeverage;

class NonAlcoholicBeverage extends ColdBeverage {
    public NonAlcoholicBeverage(BeverageType drinkType) {
        super(drinkType);
    }

    public void drink() {
        System.out.println("Drink carefully. It's cold.");
    }
}
