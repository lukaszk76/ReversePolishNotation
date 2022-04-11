public class ReversePolishNotation {
    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        AdvancedCalculator advancedCalculator = new AdvancedCalculator();

        System.out.println(simpleCalculator.calculate("1 2 + 4 * 5 + 3 -"));
        System.out.println(advancedCalculator.calculate("1 2 + 4 * 5 + 3 -"));
    }
}
