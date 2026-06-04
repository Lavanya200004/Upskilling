import java.util.List;

record PersonRecord(String name, int age) {
}

class Records {
    public static void main(String[] args) {
        List<PersonRecord> people = List.of(
                new PersonRecord("Aman", 20),
                new PersonRecord("Riya", 17),
                new PersonRecord("Neha", 24));

        System.out.println("All people:");
        people.forEach(System.out::println);

        System.out.println("People aged 18 or above:");
        people.stream()
                .filter(person -> person.age() >= 18)
                .forEach(System.out::println);
    }
}
