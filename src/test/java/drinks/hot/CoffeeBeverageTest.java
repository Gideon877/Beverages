package drinks.hot;

import drinks.bar.BeverageTemperature;
import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.bar.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeBeverageTest {

    @Nested
    @DisplayName("When you order Coffee")
    class GetCoffee {

        @Test
        @DisplayName("Without Sugar and Milk")
        void withoutSugarAndMilk() {
            Person personA = new Person();
            HotBeverage coffee = new HotBeverage(BeverageType.Coffee);

           // assertEquals("This Coffee is made of water and coffee beans.", personA.drink(coffee));
            assertFalse(coffee.hasMilk());
            assertFalse(coffee.hasSugar());
        }

        @Test
        @DisplayName("With Sugar and Milk")
        void withSugarAndMilk() {
            Person personA = new Person();

            HotBeverage coffee = new HotBeverage(BeverageType.Coffee);
            coffee.addIngredients(IngredientType.Sugar);
            coffee.addIngredients(IngredientType.Milk);

            //assertEquals("This Coffee is made of water, coffee beans, sugar and milk.", personA.drink(coffee));
            assertTrue(coffee.hasMilk());
            assertTrue(coffee.hasSugar());

            assertEquals(BeverageTemperature.WARM, coffee.getTemperature());

        }

        @Test
        @DisplayName("Without Milk")
        void withSugar() {
            Person personA = new Person();

            HotBeverage coffee = new HotBeverage(BeverageType.Coffee);
            coffee.addIngredients(IngredientType.Sugar);

            //assertEquals("This Coffee is made of water, coffee beans and sugar.", personA.drink(coffee));

            assertFalse(coffee.hasMilk());
            assertTrue(coffee.hasSugar());
        }

        @Test
        @DisplayName("Without Sugar")
        void withMilk() {
            Person personA = new Person();

            HotBeverage coffee = new HotBeverage(BeverageType.Coffee);
            coffee.addIngredients(IngredientType.Milk);

            //assertEquals("This Coffee is made of water, coffee beans and milk.", personA.drink(coffee));
            assertTrue(coffee.hasMilk());
            assertFalse(coffee.hasSugar());
        }



    }

}