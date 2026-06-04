import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ExecutorServiceCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = new ArrayList<>();

        tasks.add(() -> "Task 1 completed");
        tasks.add(() -> "Task 2 completed");
        tasks.add(() -> "Task 3 completed");

        try {
            List<Future<String>> results = executorService.invokeAll(tasks);

            for (Future<String> result : results) {
                System.out.println(result.get());
            }
        } catch (Exception e) {
            System.out.println("Executor error: " + e.getMessage());
        } finally {
            executorService.shutdown();
        }
    }
}
