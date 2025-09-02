import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        scanner.nextLine(); 
        String height = scanner.nextLine().replaceAll("\\s+", "");

        double hightMeter = convertStringToMeter(height);

        print(weight, hightMeter);

    }

    static double convertStringToMeter(String height) {
        int feet =0;
        int inches = 0;
        if(height.contains("ft") && height.contains("in")) {
            feet = Integer.parseInt(height.split("ft")[0]);
            inches = Integer.parseInt(height.split("ft|in")[1]);
        } else if (height.contains("ft")) {
            feet = Integer.parseInt(height.split("ft")[0]);
        } else {
            inches = Integer.parseInt(height.split("in")[0]);
        }
        double meter = (feet*12+inches)*0.0254;
        return meter;
    }
    
    static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    static void print(double weight, double height) {
        double bmi = calculateBMI(weight, height);
        int star = (int) bmi;
        printStar(star);
        if (bmi < 18.5) {
            System.out.println("\nYour BMI is: " + bmi);
            System.out.println("Category: Underweight");
        } else if (bmi < 24.9) {
            System.out.println("\nYour BMI is: " + bmi);
            System.out.println("Category: Normal weight");
        } else if (bmi < 29.9) {
            System.out.println("\nYour BMI is: " + bmi);
            System.out.println("Category: Overweight");
        } else {
            System.out.println("\nYour BMI is: " + bmi);
            System.out.println("Category: Obesity");
        }
        printStar(star);
        System.out.println();
    }
    static void printStar(int star) {
        if(star < 1) return;
        System.out.print("*");
        printStar(star - 1);
    }
}
