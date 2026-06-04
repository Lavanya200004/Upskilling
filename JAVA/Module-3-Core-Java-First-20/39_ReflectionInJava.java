import java.lang.reflect.Method;

class ReflectionTarget {
    public void sayHello() {
        System.out.println("Hello from ReflectionTarget.");
    }
}

class ReflectionInJava {
    public static void main(String[] args) {
        try {
            Class<?> loadedClass = Class.forName("ReflectionTarget");
            Object object = loadedClass.getDeclaredConstructor().newInstance();

            System.out.println("Methods:");
            for (Method method : loadedClass.getDeclaredMethods()) {
                System.out.println(method.getName());
            }

            Method sayHello = loadedClass.getDeclaredMethod("sayHello");
            sayHello.invoke(object);
        } catch (Exception e) {
            System.out.println("Reflection error: " + e.getMessage());
        }
    }
}
