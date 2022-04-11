import java.util.HashMap;
import java.util.Stack;
import java.util.function.Function;

public class AdvancedCalculator {

    // functions managing the operations accept whole stack. For basic operations it could be only 2 items pop from the stack but transfering the whole stack makes possible implementation of more sophisticated operations which require another than 2 number of input arguments.
    private Double add(Stack<Double> stack) {
        return stack.pop() + stack.pop();
    }

    private Double subtract(Stack<Double> stack) {
        Double a = stack.pop();
        Double b = stack.pop();
        return b - a;
    }

    private Double multiply(Stack<Double> stack) {
        return stack.pop() * stack.pop();
    }

    private Double divide(Stack<Double> stack) {
        Double a = stack.pop();
        Double b = stack.pop();
        return b / a;
    }

    public Double calculate(String input) {

        String[] items = input.split(" ");
        Stack<Double> stack = new Stack<Double>();

        HashMap<String, Function<Stack<Double>, Double>> operators = new HashMap<>();
        operators.put("+", this::add);
        operators.put("-", this::subtract);
        operators.put("*", this::multiply);
        operators.put("/", this::divide);

        for (String item : items) {
            try {
                stack.push(Double.parseDouble(item));
            } catch (NumberFormatException exc1) {
                try {
                    stack.push(operators.get(item).apply(stack));
                } catch (NullPointerException exc2) {
                    System.out.println("Not a number or operator: " + item);
                }

            }
        }
        return stack.pop();
    }
}
