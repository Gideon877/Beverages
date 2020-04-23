package drinks.cold.no_alcoholic;

import drinks.bar.BeverageType;
import drinks.cold.ColdBeverage;

class NonAlcoholicBeverage extends ColdBeverage {
    public NonAlcoholicBeverage(BeverageType drinkType) {
        super(drinkType);
    }
    @Override
    public String getDrinkTips() {
        System.out.println(ingredients.size()+ "-------");
        if(hasIce()) {
            return "Enjoy your drink with straw";
        }
        return "Enjoy your drink,,";
    }
}
