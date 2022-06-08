package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String numInput;

        // Current coffee machine levels
        int waterLevel = 400;
        int milkLevel = 540;
        int coffeeLevel = 120;
        int cupLevel = 9;
        int moneyLevel = 550;

        while (!input.equals("exit")) {
            input = getAction(scanner);

            switch (input) {
                case "buy":
                    numInput = getNumInput(scanner);

                    if (numInput.equals("back")) {
                        break;
                    }

                    switch (Integer.parseInt(numInput)) {
                        case 1:
                            Coffee espresso = new Coffee(250, 0, 16, 4);
                            if (espresso.getWater() <= waterLevel && espresso.getMilk() <= milkLevel && espresso.getCoffee() <= coffeeLevel && cupLevel > 0) {
                                waterLevel -= espresso.getWater();
                                milkLevel -= espresso.getMilk();
                                coffeeLevel -= espresso.getCoffee();
                                moneyLevel += espresso.getCost();
                                cupLevel--;
                            }
                            else {
                                lowLevels(waterLevel, milkLevel, coffeeLevel, cupLevel, espresso);
                            }

                            break;
                        case 2:
                            Coffee latte = new Coffee(350, 75, 20, 7);
                            if (latte.getWater() <= waterLevel && latte.getMilk() <= milkLevel && latte.getCoffee() <= coffeeLevel && cupLevel > 0) {
                                waterLevel -= latte.getWater();
                                milkLevel -= latte.getMilk();
                                coffeeLevel -= latte.getCoffee();
                                moneyLevel += latte.getCost();
                                cupLevel--;
                            }
                            else {
                                lowLevels(waterLevel, milkLevel, coffeeLevel, cupLevel, latte);
                            }
                            break;
                        case 3:
                            Coffee cappuccino = new Coffee(200, 100, 12, 6);
                            if (cappuccino.getWater() <= waterLevel && cappuccino.getMilk() <= milkLevel && cappuccino.getCoffee() <= coffeeLevel && cupLevel > 0) {
                                waterLevel -= cappuccino.getWater();
                                milkLevel -= cappuccino.getMilk();
                                coffeeLevel -= cappuccino.getCoffee();
                                moneyLevel += cappuccino.getCost();
                                cupLevel--;
                            }
                            else {
                                lowLevels(waterLevel, milkLevel, coffeeLevel, cupLevel, cappuccino);
                            }
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    numInput = scanner.nextLine();
                    waterLevel += Integer.parseInt(numInput);
                    System.out.println("Write how many ml of milk you want to add:");
                    numInput = scanner.nextLine();
                    milkLevel += Integer.parseInt(numInput);
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    numInput = scanner.nextLine();
                    coffeeLevel += Integer.parseInt(numInput);
                    System.out.println("Write how many disposable cups you want to add:");
                    numInput = scanner.nextLine();
                    cupLevel += Integer.parseInt(numInput);
                    break;
                case "take":
                    giveMoney(moneyLevel);
                    moneyLevel = 0;
                    break;
                case "remaining":
                    showLevels(waterLevel, milkLevel, coffeeLevel, cupLevel, moneyLevel);
            }
        }
    }

    private static void lowLevels(int waterLevel, int milkLevel, int coffeeLevel, int cupLevel, Coffee drink) {
        if (drink.getWater() > waterLevel) {
            System.out.println("Sorry, not enough water!");
        }
        if (drink.getMilk() > milkLevel) {
            System.out.println("Sorry, not enough milk!");
        }
        if (drink.getCoffee() > coffeeLevel) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        if (cupLevel <= 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    private static void showLevels(int waterLevel, int milkLevel, int coffeeLevel, int cupLevel, int moneyLevel) {
        System.out.printf("The coffee machine has:\n" +
                "%s ml of water\n" +
                "%s ml of milk\n" +
                "%s g of coffee beans\n" +
                "%s disposable cups\n" +
                "$%s of money\n", waterLevel, milkLevel, coffeeLevel, cupLevel, moneyLevel);
    }

    private static void giveMoney(int moneyLevel) {
        System.out.printf("I gave you $%s\n", moneyLevel);
    }

    private static String getNumInput(Scanner scanner) {
        String numInput;
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        numInput = scanner.nextLine();
        return numInput;
    }

    private static String getAction(Scanner scanner) {
        String input;
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        input = scanner.nextLine();
        return input;
    }

}
