import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Riya");
        names.add("Aman");
        names.add("Neha");
        names.add("Kabir");

        Collections.sort(names, (first, second) -> first.compareTo(second));

        System.out.println("Sorted names: " + names);
    }
}
