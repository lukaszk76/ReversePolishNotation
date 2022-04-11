import java.util.Stack;

public class SimpleCalculator {

    public Double calculate(String input){
        String[] items = input.split(" ");
        Stack<Double> stack = new Stack<Double>();

        for (String item: items) {
            // try/catch makes the solution shorter and cleaner - although it can be solved another way too
            try {
                stack.push(Double.parseDouble(item));
            } catch(Exception e) {      // a fit person should know it is NumberFormatException and use it instead of the generic Exception class
                Double a = stack.pop();
                Double b = stack.pop();
                switch(item) {          // if/else solution would do the job too but the code would be more difficult to follow
                    case "+": {
                        stack.push(a+b);
                        break;
                    }
                    case "-": {
                        stack.push( b-a);
                        break;
                    }
                    case "*": {
                        stack.push(a*b);
                        break;
                    }
                    case "/": {
                        stack.push( b/a);
                        break;
                    }
                    default:    // this is to handle cases if the input string contains invalid character
                        System.out.println("not a number or operator: " + item);
                }
            }
        }
        return stack.pop();
    }
}
