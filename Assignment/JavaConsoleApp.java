import java.util.Scanner;

public class JavaConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String reason = "I'm learning Java because it's a powerful, cross-platform language with high career demand, strong security, and is widely used in enterprise development.";
        String careerGoal = "Become a skilled Spring Boot developer using Java-based technologies to build secure, scalable, and efficient RESTful APIs and enterprise-level applications.";

        System.out.println("----------------------Student Information------------------------");
        System.out.println("\nName: " + name +" \n");
        System.out.println("Reason for learning Java: " + reason + "\n");
        System.out.println("Career Goal: " + careerGoal);
        System.out.println("\n----------------------------------------------------------------");
        scanner.close();
        System.out.println("\nThank you for sharing your information, " + name + "!");
        System.out.println("Best of luck on your journey to becoming a backend developer!\n");
        System.out.println("----------------------------------------------------------------");
    }
}