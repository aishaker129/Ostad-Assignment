package StudentRecordManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   

        System.out.print("Enter the number of students:");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        List<Student> studentList = new ArrayList<>();

        for(int i=0; i<n; i++){
            System.out.print("ID: ");
            long id = scanner.nextLong();
            scanner.nextLine(); 
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Blood Group: ");
            String bloodGroup = scanner.nextLine();
            System.out.print("CGPA: ");
            float cgpa = scanner.nextFloat();
            scanner.nextLine(); 
            System.out.println();
            studentList.add(new Student(id, fullName, bloodGroup, cgpa));
        }

        System.out.print("Enter a query (last name or blood group): ");
        String query = scanner.nextLine();
        boolean found = false;
        for(Student student : studentList){
            if(student.matchesQuery(query)){
                student.printInfo();
                found = true;
            }
        }

        if(!found){
            System.out.println("No matching student found.");
        }
        System.out.println("\nStudent with the lowest CGPA:");
        Student lowcgpa = lowCGPA(studentList);
        lowcgpa.printInfo();
        scanner.close();

    }

    public static Student lowCGPA(List<Student> students){
        Student low = students.get(0);
        for(Student student : students){
            if(student.getCgpa() < low.getCgpa()){
                low = student;  
            }
        }
        return low;
    }
}
