
public class Operation {
    double numOne;
    double numTwo;
    String operator;
    double result;

    public Operation(double numOne, double numTwo, String operator) {
        this.numOne = numOne;
        this.numTwo = numTwo;
        this.operator = operator;
        this.result = calculate();
    }

    private double calculate() {
        try {
            switch (operator) {
                case "+": return numOne + numTwo;
                case "-": return numOne - numTwo;
                case "*": return numOne * numTwo;
                case "/": return (numTwo == 0) ? Double.NaN : numOne / numTwo;
                default: return Double.NaN;
            }
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    // Convert object -> JSON string
    public String toJson() {
        return String.format(
            "{ \"numOne\": %.2f, \"numTwo\": %.2f, \"operator\": \"%s\", \"result\": %.2f }",
            numOne, numTwo, operator, result
        );
    }

    // Convert JSON string -> Object
    public static Operation fromJson(String json) {
        try {
            json = json.replaceAll("[{}\"]", ""); // remove braces and quotes
            String[] parts = json.split(",");
            double numOne = 0, numTwo = 0, result = 0;
            String operator = "";

            for (String part : parts) {
                String[] kv = part.trim().split(":");
                if (kv.length < 2) continue;
                switch (kv[0].trim()) {
                    case "numOne": numOne = Double.parseDouble(kv[1].trim()); break;
                    case "numTwo": numTwo = Double.parseDouble(kv[1].trim()); break;
                    case "operator": operator = kv[1].trim(); break;
                    case "result": result = Double.parseDouble(kv[1].trim()); break;
                }
            }
            Operation op = new Operation(numOne, numTwo, operator);
            op.result = result; 
            return op;
        } catch (Exception e) {
            return null; 
        }
    }

    @Override
    public String toString() {
        return numOne + " " + operator + " " + numTwo + " = " + result;
    }
}
