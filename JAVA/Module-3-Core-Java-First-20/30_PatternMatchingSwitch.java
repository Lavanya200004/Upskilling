class PatternMatchingSwitch {
    static String checkType(Object value) {
        return switch (value) {
            case Integer number -> "Integer value: " + number;
            case String text -> "String value: " + text;
            case Double decimal -> "Double value: " + decimal;
            case null -> "Null value";
            default -> "Unknown type: " + value.getClass().getSimpleName();
        };
    }

    public static void main(String[] args) {
        System.out.println(checkType(25));
        System.out.println(checkType("Core Java"));
        System.out.println(checkType(99.5));
        System.out.println(checkType(true));
    }
}
