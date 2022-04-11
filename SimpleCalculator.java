import java.util.Stack;

public class SimpleCalculator {

    public Double calculate(String input) {
        String[] items = input.split(" ");
        Stack<Double> stack = new Stack<Double>();

        for (String item : items) {

            switch (item) {
                case "+": {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "-": {
                    Double a = stack.pop();
                    Double b = stack.pop();
                    stack.push(b - a);
                    break;
                }
                case "*": {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case "/": {
                    Double a = stack.pop();
                    Double b = stack.pop();
                    stack.push(b / a);
                    break;
                }
                default:
                    stack.push(Double.parseDouble(item));
            }
        }
        return stack.pop();
    }
}
