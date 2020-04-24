package drinks.bar;

import drinks.Beverage;
import drinks.cold.alcoholic.Spirit;
import drinks.cold.no_alcoholic.Juice;
import drinks.hot.HotBeverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTemperatureTest {

    @Nested
    @DisplayName("When order")
    class GetSpiritsTemperature {

        @Test
        @DisplayName("Neat spirit")
        void spiritShot() {
            Beverage vodka = new Spirit(BeverageType.Spirit);
            assertEquals(BeverageTemperature.ROOM_TEMPERATURE, vodka.getTemperature());
        }

        @Test
        @DisplayName("spirit on the rocks")
        void spiritOnTheRockShot() {
            Beverage vodka = new Spirit(BeverageType.Spirit);
            vodka.addIngredients(IngredientType.Ice);
            assertEquals(BeverageTemperature.COLD, vodka.getTemperature());
        }

    }

    @Nested
    @DisplayName("When order")
    class GetHotBeverage {
        @Test
        @DisplayName("coffee without Milk")
        void hotCoffee() {
            Beverage beverage = new HotBeverage(BeverageType.Coffee);
            assertEquals(BeverageTemperature.HOT, beverage.getTemperature());
        }

        @Test
        @DisplayName("coffee with Milk")
        void warmCoffee() {
            Beverage beverage = new HotBeverage(BeverageType.Coffee);
            beverage.addIngredients(IngredientType.Milk);
            System.out.println(beverage.getDrink());

            assertEquals(BeverageTemperature.WARM, beverage.getTemperature());
        }
    }

    @Nested
    @DisplayName("When order")
    class GetColdBeverage {
        @Test
        @DisplayName("juice without ice")
        void coldJuice() {
            Beverage beverage = new Juice(BeverageType.Juice);
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
        }

        @Test
        @DisplayName("juice with ice")
        void warmCoffee() {
            Beverage beverage = new Juice(BeverageType.Juice);
            beverage.addIngredients(IngredientType.Ice);
            assertEquals(BeverageTemperature.EXTREMELY_COLD, beverage.getTemperature());
        }
    }
}