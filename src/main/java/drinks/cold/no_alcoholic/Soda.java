package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;

public class Soda extends NonAlcoholicBeverage {
    public Soda(BeverageType drinkType) {
        super(drinkType);
    }
    public void drink() {
        System.out.println("Drink in a can.");
    }
}
