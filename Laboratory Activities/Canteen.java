import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String[] food = {
                "Pancit Canton",
                "Lumpia",
                "Caldereta",
                "Adobo",
                "Buffalo Wings"
            };

            double[] prices = {30, 25, 50, 60, 135};

            int totalQuantity = 0;
            double totalAmount = 0;
            double totalDiscount = 0;

            String again = "Y";

            System.out.println("===== CANTEEN MENU =====");
            System.out.println("1. Pancit Canton  - Php 30.00");
            System.out.println("2. Lumpia         - Php 25.00");
            System.out.println("3. Caldereta      - Php 50.00");
            System.out.println("4. Adobo          - Php 60.00");
            System.out.println("5. Buffalo Wings  - Php 135.00");
            System.out.println("========================");

            while (again.equalsIgnoreCase("Y")) {

                System.out.print("\nEnter item number: ");
                int item = input.nextInt();

                if (item < 1 || item > 5) {
                    System.out.println(
                        "Invalid item number! Please choose from 1 to 5.");

                    while (true) {
                        System.out.print(
                            "\nDo you want to order again? (Y/N): ");
                        again = input.next();

                        if (again.equalsIgnoreCase("Y")
                                || again.equalsIgnoreCase("N")) {
                            break;
                        }

                        System.out.println(
                            "Invalid input! Please enter Y or N.");
                    }

                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = input.nextInt();

                if (quantity < 1 || quantity > 10) {
                    System.out.println(
                        "Invalid quantity! Please enter a quantity from 1 to 10.");

                    while (true) {
                        System.out.print(
                            "\nDo you want to order again? (Y/N): ");
                        again = input.next();

                        if (again.equalsIgnoreCase("Y")
                                || again.equalsIgnoreCase("N")) {
                            break;
                        }

                        System.out.println(
                            "Invalid input! Please enter Y or N.");
                    }

                    continue;
                }

                String answer;

                while (true) {
                    System.out.print("Are you a student? (Y/N): ");
                    answer = input.next();

                    if (answer.equalsIgnoreCase("Y")
                            || answer.equalsIgnoreCase("N")) {
                        break;
                    }

                    System.out.println(
                        "Invalid input! Please enter Y or N.");
                }

                boolean student = answer.equalsIgnoreCase("Y");

                double subtotal = prices[item - 1] * quantity;
                double discount;

                if (student && subtotal >= 500) {
                    discount = subtotal * 0.15;
                } else if (student) {
                    discount = subtotal * 0.10;
                } else if (subtotal >= 500) {
                    discount = subtotal * 0.05;
                } else {
                    discount = 0;
                }

                double orderTotal = subtotal - discount;

                System.out.printf("\nItem: %s%n", food[item - 1]);
                System.out.printf("Subtotal: Php %.2f%n", subtotal);
                System.out.printf("Discount: Php %.2f%n", discount);
                System.out.printf("Amount to Pay: Php %.2f%n", orderTotal);

                totalQuantity += quantity;
                totalAmount += subtotal;
                totalDiscount += discount;

                while (true) {
                    System.out.print(
                        "\nDo you want to order again? (Y/N): ");
                    again = input.next();

                    if (again.equalsIgnoreCase("Y")
                            || again.equalsIgnoreCase("N")) {
                        break;
                    }

                    System.out.println(
                        "Invalid input! Please enter Y or N.");
                }
            }

            double finalAmount = totalAmount - totalDiscount;

            System.out.println("\n===== ORDER SUMMARY =====");
            System.out.println("Total quantity: " + totalQuantity);
            System.out.printf(
                "Total amount before deductions: Php %.2f%n",
                totalAmount);
            System.out.printf(
                "Total deduction: Php %.2f%n",
                totalDiscount);
            System.out.printf(
                "Final amount to pay: Php %.2f%n",
                finalAmount);
            System.out.println("=========================");
            System.out.println("Thank you for ordering!");
        }
    }
}

