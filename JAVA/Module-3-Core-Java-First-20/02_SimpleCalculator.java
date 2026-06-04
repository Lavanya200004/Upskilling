import java.util.Scanner;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();

        System.out.print("Choose operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        switch (operation) {
            case '+':
                System.out.println("Result: " + (first + second));
                break;
            case '-':
                System.out.println("Result: " + (first - second));
                break;
            case '*':
                System.out.println("Result: " + (first * second));
                break;
            case '/':
                if (second == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    System.out.println("Result: " + (first / second));
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }

        scanner.close();
    }
}

