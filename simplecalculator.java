import java.util.Scanner;

class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            double result = performOperation(choice);
            printResult(result);
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Choose Operation:\n" +
                "1. Addition\n" +
                "2. Subtraction\n" +
                "3. Multiplication\n" +
                "4. Division\n" +
                "5. Square Root\n" +
                "6. Exponentiation\n" +
                "0. Exit");

        System.out.print("Enter your choice: ");
    }

    private static double performOperation(int choice) {
        switch (choice) {
            case 1:
                return performBinaryOperation("Enter the first number: ", "Enter the second number: ", (x, y) -> x + y);
            case 2:
                return performBinaryOperation("Enter the first number: ", "Enter the second number: ", (x, y) -> x - y);
            case 3:
                return performBinaryOperation("Enter the first number: ", "Enter the second number: ", (x, y) -> x * y);
            case 4:
                return performBinaryOperation("Enter the dividend: ", "Enter the divisor: ",
                        (dividend, divisor) -> divisor != 0 ? dividend / divisor : Double.NaN);
            case 5:
                return performUnaryOperation("Enter the number: ", num -> num >= 0 ? Math.sqrt(num) : Double.NaN);
            case 6:
                return performBinaryOperation("Enter the base: ", "Enter the exponent: ", Math::pow);
            default:
                System.out.println("Invalid choice");
                return Double.NaN;
        }
    }

    private static double performBinaryOperation(String prompt1, String prompt2, BinaryOperator operation) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt1);
        double x = scanner.nextDouble();

        System.out.print(prompt2);
        double y = scanner.nextDouble();

        return operation.apply(x, y);
    }

    private static double performUnaryOperation(String prompt, UnaryOperator operation) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(prompt);
        double num = scanner.nextDouble();

        return operation.apply(num);
    }

    private static void printResult(double result) {
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        } else {
            System.out.println("Error: Invalid operation");
        }
        System.out.println();
    }

    @FunctionalInterface
    interface BinaryOperator {
        double apply(double x, double y);
    }

    @FunctionalInterface
    interface UnaryOperator {
        double apply(double num);
    }
}
