import java.util.HashMap;
import java.util.Scanner;

class HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();

        System.out.print("How many students do you want to add? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            students.put(id, name);
        }

        System.out.print("Enter ID to search: ");
        int searchId = scanner.nextInt();

        if (students.containsKey(searchId)) {
            System.out.println("Student name: " + students.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
