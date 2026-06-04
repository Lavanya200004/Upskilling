class JavapBytecode {
    static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        System.out.println("Square of 5: " + square(5));
        System.out.println("After compiling, inspect bytecode with:");
        System.out.println("javap -c JavapBytecode");
    }
}
