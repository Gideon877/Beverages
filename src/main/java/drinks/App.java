package drinks;

import drinks.bar.BeverageType;
import drinks.bar.CommandExtractor;
import drinks.bar.CommandProcessor;
import drinks.bar.IngredientType;
import drinks.cold.ColdBeverage;
import drinks.hot.HotBeverage;
import java.util.Scanner;

/**
 * todo: create a menu, command extractor, output display
 * date: 22 Apr 2020
 * author: TG Magaola
 * */

public class App {

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public static void main(String[] args) {
        System.out.println("Thee Bev Bar");


        boolean start = true;
        while (start) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter command to order: ");
            String command = scanner.nextLine();
            if(command.equals("exit") || command.startsWith("exit")) {
                start = false;
                return;
            }
//
            Beverage beverage = new CommandProcessor(new CommandExtractor(command)).getBeverage();

            System.out.println("Preparing your beverage. This might take 5s");
            setTimeout(() -> System.out.println("Your order is done. Below is beverage info:\n\n" + beverage.getDrinkTips()), 5000);
            return;
        }


//            System.out.println("Would you like to order? Y/N");
//            String input = scanner.nextLine();
//            String[] userInput = input.split(" ");
//
//            String command = userInput[0];
//            if(command.equals("exit")) {
//                start = false;
//                return;
//            }
//
//            if(command.equalsIgnoreCase("Y")) {
//                Beverage beverage;
//                System.out.println("What would you like? \n * Select Number Below\n\t1) Hot beverage \n\t2) Cold beverage\n");
//                String drinkType = scanner.nextLine().split(" ")[0];
//
//                if(drinkType.equals("1")) {
//                    System.out.println("Choose your poison.\n\t1) Coffee \n\t2) Tea\n");
//                    String drink = scanner.nextLine().split(" ")[0];
//
//                    System.out.println("Want more? \n * Add extras\n\t1) Milk \n\t2) Sugar \n\t3) Both\n\t4) No");
//                    String addsOn = scanner.nextLine().split(" ")[0];
//
//                    if(drink.equals("1")) {
////                        Coffee
//                        beverage = new HotBeverage(BeverageType.Coffee);
//                        addAddsOn(beverage, addsOn);
//
//                    } else if(drink.equals("2")) {
////                        Tea
//                        beverage = new HotBeverage(BeverageType.Tea);
//                        addAddsOn(beverage, addsOn);
//                    } else {
//                        return;
//                    }
//                    System.out.println("Preparing your hot drink. This will take 5s");
//
//                } else if (drinkType.equals("2")) {
//                    System.out.println("Preparing your cold drink. This will take 5s");
//                    beverage = new ColdBeverage(BeverageType.Soda);
//                } else {
//                    System.out.println("Wrong selection");
//                    return;
//                }
//                setTimeout(() -> System.out.println("Drink is done \n" + beverage.getDrinkTips()), 5000);
//                return;
//
//            } else if (command.equalsIgnoreCase("N")) {
////                System.out.println("Waiting for 3 seconds");
//                setTimeout(()-> System.out.println("Goodbye..."), 3000);
//            } else {
////                System.out.println("Waiting for 3 seconds");
//                setTimeout(()-> System.out.println("Goodbye...."), 2000);
//            }
//
//        }
    }

//    private static void addAddsOn(Beverage beverage, String addsOn) {
//        if(addsOn.equals("1")) {
////            Milk
//            beverage.addIngredients(IngredientType.Milk);
//        }
//
//        if(addsOn.equals("2")) {
////            Sugar
//            beverage.addIngredients(IngredientType.Sugar);
//        }
//
//        if(addsOn.equals("3")) {
////            Both
//            beverage.addIngredients(IngredientType.Sugar);
//            beverage.addIngredients(IngredientType.Milk);
//        }
//
//        if(addsOn.equals("4")) {
////        None
//        }
//
//    }
}
