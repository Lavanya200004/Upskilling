class TypeCastingExample {
    public static void main(String[] args) {
        double decimalValue = 45.78;
        int convertedInt = (int) decimalValue;

        int wholeNumber = 25;
        double convertedDouble = wholeNumber;

        System.out.println("Original double value: " + decimalValue);
        System.out.println("After casting double to int: " + convertedInt);
        System.out.println("Original int value: " + wholeNumber);
        System.out.println("After casting int to double: " + convertedDouble);
    }
}

