package drinks.bar;

public enum BeverageType {
    Tea("Teabag"),
    Coffee("Coffee Beans"),
    Soda("Soda"),
    Spirit("Whiskey"),
    Juice("Fruit Juice"),
    Water("Carbonated Water"),
    Beer("Lager");

    private final String basicIngredients;

    BeverageType(String basicIngredients) {
        this.basicIngredients = basicIngredients;
    }

    public String getBasicIngredients() {
        return basicIngredients;
    }
}
