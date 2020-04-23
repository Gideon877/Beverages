package drinks.hot;
import drinks.Beverage;
import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;

import static drinks.bar.IngredientType.*;

public class HotBeverage extends Beverage {

    public HotBeverage(BeverageType drinkType) {
        super(drinkType);
    }

    @Override
    public void addIngredients(IngredientType ingredientType) {
        super.addIngredients(ingredientType);
    }

    @Override
    public String getDrinkTips() {
        String temperature = getTemperature().toString().toLowerCase().replace("_", " ");
        return String.format("Order Name: %s\nIngredients: %s. \nTemperature: %s", drinkType.toString(), getIngredients(), temperature);
    }

    @Override
    public boolean hasExtras() {
        return super.hasExtras();
    }

    @Override
    public BeverageTemperature getTemperature() {
        if(hasMilk()) {
            if(ingredients.contains(Ice)) {
                return BeverageTemperature.ROOM_TEMPERATURE;
            }
            return BeverageTemperature.WARM;
        } else if(ingredients.contains(Ice)) {
            return BeverageTemperature.WARM;
        }
        return BeverageTemperature.HOT;
    }

    private String getIngredients() {
        StringBuilder message = new StringBuilder();
        if(drinkType.equals(BeverageType.Tea)) {
            if(ingredients.isEmpty()) {
                return "water and teabag";
            }

            if(ingredients.size() > 0) {
                message.append("water, teabag");
            }
        }

        if(drinkType.equals(BeverageType.Coffee)) {
            if(ingredients.isEmpty()) {
                return "water and coffee beans";
            }

            if(ingredients.size() > 0) {
                message.append("water, coffee beans");
            }
        }


        if(ingredients.size() == 1) {
            message.append(" and ");
            message.append(ingredients.get(0).toString().toLowerCase());
            return message.toString();
        }

        for (int i = 0; i < ingredients.size(); i++) {
            if((ingredients.size() - i) != 1) {
                message.append(", ");
            }
            if((ingredients.size() - i) == 1) {
                message.append(" and ");
            }
            message.append(ingredients.get(i).toString().toLowerCase());
        }
        return message.toString();
    }

    public boolean hasMilk() {
        return ingredients.contains(Milk);
    }

    public boolean hasSugar() {
        return ingredients.contains(Sugar);
    }

}
