package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;

public class Juice extends NonAlcoholicBeverage {
    public Juice(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public String getTips() {
        return "I spilled a drink on a girl at a party and that's \"How I Wet Your Mother\". ";
    }
}
