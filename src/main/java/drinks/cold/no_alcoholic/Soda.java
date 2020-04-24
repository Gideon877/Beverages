package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;

public class Soda extends NonAlcoholicBeverage {
    public Soda(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public String getTips() {
        return "I have a job crushing Coca-Cola cans. It's soda pressing.";
    }
}
