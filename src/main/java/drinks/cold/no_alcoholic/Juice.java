package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;

public class Juice extends NonAlcoholicBeverage {
    public Juice(BeverageType drinkType) {
        super(drinkType);
    }

    public void drink() {
        System.out.println("Drink Juice from a glass.");
    }
}
