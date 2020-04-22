package drinks.hot;

import drinks.bar.BeverageType;
import drinks.bar.IngredientType;
import drinks.bar.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeaBeverageTest {

    @Nested
    @DisplayName("When you order Tea")
    class GetTea {

        @Test
        @DisplayName("Without Sugar and Milk")
        void withoutSugarAndMilk() {
            Person personA = new Person();
            HotBeverage tea = new HotBeverage(BeverageType.Tea);

            assertEquals("This Tea is made of water and teabag.", personA.drink(tea));
            assertFalse(tea.hasMilk());
            assertFalse(tea.hasSugar());
        }

        @Test
        @DisplayName("With Sugar and Milk")
        void withSugarAndMilk() {
            Person personA = new Person();

            HotBeverage tea = new HotBeverage(BeverageType.Tea);
            tea.addIngredients(IngredientType.Sugar);
            tea.addIngredients(IngredientType.Milk);


            assertEquals("This Tea is made of water, teabag, sugar and milk.", personA.drink(tea));
            assertTrue(tea.hasMilk());
            assertTrue(tea.hasSugar());

        }

        @Test
        @DisplayName("Without Milk")
        void withSugar() {
            Person personA = new Person();

            HotBeverage tea = new HotBeverage(BeverageType.Tea);
            tea.addIngredients(IngredientType.Sugar);

            assertEquals("This Tea is made of water, teabag and sugar.", personA.drink(tea));

            assertFalse(tea.hasMilk());
            assertTrue(tea.hasSugar());
        }

        @Test
        @DisplayName("Without Sugar")
        void withMilk() {
            Person personA = new Person();

            HotBeverage tea = new HotBeverage(BeverageType.Tea);
            tea.addIngredients(IngredientType.Milk);

            assertEquals("This Tea is made of water, teabag and milk.", personA.drink(tea));
            assertTrue(tea.hasMilk());
            assertFalse(tea.hasSugar());
        }
    }
}