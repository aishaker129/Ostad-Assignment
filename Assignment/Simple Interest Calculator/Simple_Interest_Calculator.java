import java.util.Scanner;

public class Simple_Interest_Calculator {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int principal = scanner.nextInt(); // Principal amount
        double rate = scanner.nextDouble(); // Interest rate in percentage
        String time = scanner.next(); // Time in years in years or months (e.g., "2y" or "6m")

        double timeInYears=0.0;

        // Convert time to integer years
        if(time.contains("m")){
            time = time.replace("m", "");
            timeInYears = Double.parseDouble(time)/ 12.0;
        }
        else{
            time = time.replace("y", "");
            timeInYears = Double.parseDouble(time);
        }

        // Calculate simple interest
        double simpleInterest = (principal * rate * timeInYears) / 100.0;

        // Print the result
        System.out.printf("The Simple Interest is: %.3f\n", simpleInterest); // format to 3 decimal places

        scanner.close();
    }
}
