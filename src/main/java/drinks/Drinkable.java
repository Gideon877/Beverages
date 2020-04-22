package drinks;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

public interface Drinkable {
    void addIngredients(IngredientType ingredientType);
    String getDrinkTips();
    BeverageType getDrinkType();
    BeverageTemperature getTemperature();
    boolean hasExtras();
}
