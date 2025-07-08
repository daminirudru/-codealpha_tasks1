import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class studentgradetracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println(" Welcome to Student Grade Tracker ");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Show summary report");
            System.out.println("4. Exit");
            System.out.print("👉 Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student marks (0-100): ");
                    int marks = sc.nextInt();
                    students.add(new Student(name, marks));
                    System.out.println("Student added!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students added yet.");
                    } else {
                        System.out.println(" \nStudent List:");
                        for (Student s : students) {
                            System.out.println("Name: " + s.name + " | Marks: " + s.marks);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No data to show.");
                    } else {
                        int total = 0;
                        int highest = Integer.MIN_VALUE;
                        int lowest = Integer.MAX_VALUE;
                        for (Student s : students) {
                            total += s.marks;
                            if (s.marks > highest) highest = s.marks;
                            if (s.marks < lowest) lowest = s.marks;
                        }
                        double average = (double) total / students.size();
                        System.out.println("\nSummary Report:");
                        System.out.println("Average Score: " + average);
                        System.out.println("Highest Score: " + highest);
                        System.out.println("Lowest Score : " + lowest);
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
