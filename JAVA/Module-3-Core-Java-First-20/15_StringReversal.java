import java.util.Scanner;

class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String reversed = new StringBuilder(text).reverse().toString();

        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}

