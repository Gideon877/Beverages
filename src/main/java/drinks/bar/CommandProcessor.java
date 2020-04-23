package drinks.bar;

import drinks.Beverage;
import drinks.cold.ColdBeverage;
import drinks.hot.HotBeverage;

public class CommandProcessor {

    private final CommandExtractor commandExtractor;

    public CommandProcessor(CommandExtractor commandExtractor) {
        this.commandExtractor = commandExtractor;
    }

    public Beverage getBeverage() {
        Beverage beverage;
        BeverageType beverageType = commandExtractor.getDrinkType();

        if( beverageType == BeverageType.Tea ||  beverageType == BeverageType.Coffee) {
            beverage = new HotBeverage(beverageType);
        }else {
            beverage = new ColdBeverage(beverageType);

        }

        addExtras(beverage);
        return beverage;
    }

    private void addExtras(Beverage beverage) {
        for (IngredientType type: commandExtractor.getExtras()) {
            beverage.addIngredients(type);
        }
    }

}
