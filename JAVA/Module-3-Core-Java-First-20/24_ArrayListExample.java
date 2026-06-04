import java.util.ArrayList;
import java.util.Scanner;

class ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("How many names do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            studentNames.add(scanner.nextLine());
        }

        System.out.println("Student names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
