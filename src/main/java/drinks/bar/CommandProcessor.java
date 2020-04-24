package drinks.bar;

import drinks.Beverage;
import drinks.cold.ColdBeverage;
import drinks.cold.alcoholic.*;
import drinks.cold.no_alcoholic.*;
import drinks.hot.HotBeverage;

public class CommandProcessor {

    private final CommandExtractor commandExtractor;

    public CommandProcessor(CommandExtractor commandExtractor) {
        this.commandExtractor = commandExtractor;
    }

    public Beverage getBeverage() {
        BeverageType beverageType = commandExtractor.getDrinkType();
        Beverage beverage = handleBeverage(beverageType);
        addExtras(beverage);
        return beverage;
    }

    private void addExtras(Beverage beverage) {
        for (IngredientType type: commandExtractor.getExtras()) {
            beverage.addIngredients(type);
        }
    }

    private Beverage handleBeverage(BeverageType beverageType) {
        if( beverageType == BeverageType.Tea ||  beverageType == BeverageType.Coffee) {
             return new HotBeverage(beverageType); // todo: need to remove constructor params
        }

        if(beverageType == BeverageType.Spirit) {
            return  new Spirit(beverageType); // todo: need to remove constructor params
        }

        if(beverageType == BeverageType.Soda) {
            return  new Soda(beverageType); // todo: need to remove constructor params
        }

        if(beverageType == BeverageType.Juice) {
            return  new Juice(beverageType); // todo: need to remove constructor params
        }

        if(beverageType == BeverageType.Beer) {
            return  new Beer(beverageType); // todo: need to remove constructor params
        }

        return new ColdBeverage(beverageType);
    }

}
