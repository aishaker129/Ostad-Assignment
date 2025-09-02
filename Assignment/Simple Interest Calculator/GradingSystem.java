import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        double number = scanner.nextDouble();
        String grade;
        String message;

        if(number >= 90) {
            grade = "A";
            message = "Well done";
        } else if(number >= 80 && number < 90) {
            grade = "B";
            message = "Well done";
        } else if(number >= 70 && number < 80) {
            grade = "C";
            message = "Needs improvement";
        } else if(number >= 60 && number < 70) {
            grade = "D";
            message = "Needs improvement";
        } else {
            grade = "F";
            message = "Failed";
        }

        System.out.println(grade + " : "+ message);
    }
}
