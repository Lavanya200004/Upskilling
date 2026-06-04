class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        int groupedResult = (10 + 5) * 2;

        System.out.println("10 + 5 * 2 = " + result);
        System.out.println("Multiplication has higher precedence than addition.");
        System.out.println("(10 + 5) * 2 = " + groupedResult);
        System.out.println("Parentheses change the order of operations.");
    }
}

