package drinks.cold.alcoholic;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiritTest {

    @Nested
    @DisplayName("When you order a spirit")
    class getSpirits {
        @Test
        @DisplayName("on the rocks")
        void onTheRock() {
            ColdBeverage beverage = new Spirit(BeverageType.Spirit);
            beverage.addIngredients(IngredientType.Ice);

            assertTrue(beverage.hasIce());
            assertEquals(BeverageTemperature.COLD, beverage.getTemperature());
        }

        @Test
        @DisplayName("neat shot")
        void neatShot() {
            ColdBeverage beverage = new Spirit(BeverageType.Spirit);
            assertFalse(beverage.hasIce());
            assertEquals(BeverageTemperature.ROOM_TEMPERATURE, beverage.getTemperature());
        }
    }

}