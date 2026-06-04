class MethodOverloading {
    static int add(int first, int second) {
        return first + second;
    }

    static double add(double first, double second) {
        return first + second;
    }

    static int add(int first, int second, int third) {
        return first + second + third;
    }

    public static void main(String[] args) {
        System.out.println("Sum of two integers: " + add(10, 20));
        System.out.println("Sum of two doubles: " + add(10.5, 20.5));
        System.out.println("Sum of three integers: " + add(10, 20, 30));
    }
}

