package drinks;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

import java.util.ArrayList;
import java.util.List;

public class Beverage implements Drinkable {
    public final BeverageType drinkType;
    public List<IngredientType> ingredients = new ArrayList<IngredientType>();

    public Beverage(BeverageType drinkType) {
        this.drinkType = drinkType;
    }

    @Override
    public void addIngredients(IngredientType ingredientType) {
        ingredients.add(ingredientType);
    }

    @Override
    public String getDrinkTips() {
        return "Enjoy your drink";
    }

    @Override
    public BeverageType getDrinkType() {
        return drinkType;
    }

    @Override
    public BeverageTemperature getTemperature() {
        return BeverageTemperature.WARM;
    }

    @Override
    public boolean hasExtras() {
        return !ingredients.isEmpty();
    }


}


