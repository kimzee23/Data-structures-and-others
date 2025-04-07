import java.util.Scanner;

public class StudenterGradeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGrade studentGrade = new StudenterGradeApp();

        while (true) {
            System.out.println("\n===== CLASS GRADE SYSTEM =====");
            System.out.println("1. Set Class Details");
            System.out.println("2. Enter Student Data");
            System.out.println("3. Display Class Summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter the number of students: ");
                    studentGrade.totalStudents = scanner.nextInt();
                    System.out.print("Enter the number of subjects: ");
                    studentGrade.totalSubjects = scanner.nextInt();

                    studentGrade.scores = new int[studentGrade.totalStudents][studentGrade.totalSubjects];
                    studentGrade.studentNames = new String[studentGrade.totalStudents];
                    System.out.println("Class details set successfully!");
                    break;

                case 2:
                    scanner.nextLine(); // Clear buffer
                    for (int student = 0; student < studentGrade.totalStudents; student++) {
                        System.out.print("Enter the name of Student " + (student + 1) + ": ");
                        String studentName = scanner.nextLine();
                        studentGrade.setStudentName(student, studentName);

                        for (int subject = 0; subject < studentGrade.totalSubjects; subject++) {
                            int score;
                            do {
                                System.out.print("Score for Subject " + (subject + 1) + ": ");
                                score = scanner.nextInt();
                                if (score < 0 || score > 100) {
                                    System.out.println("Invalid score! Enter a value between 0 and 100.");
                                }
                            } while (score < 0 || score > 100);
                            studentGrade.setScore(student, subject, score);
                        }
                        scanner.nextLine(); // Clear buffer after scores
                    }
                    System.out.println("Student data entered successfully!");
                    break;

                case 3:
                    System.out.println("\nClass Summary:");
                    System.out.println("Hardest Subject: Subject " + (studentGrade.findHardestSubject() + 1));
                    for (int student = 0; student < studentGrade.totalStudents; student++) {
                        if (studentGrade.hasFailed(student)) {
                            System.out.println(studentGrade.studentNames[student] + " has failed one or more subjects.");
                        }
                    }
                    System.out.println("Best Student: " + studentGrade.findBestStudent());
                    System.out.println("Worst Student: " + studentGrade.findWorstStudent());
                    break;

                case 4:
                    System.out.println("Thank you for using the Class Grade System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        }
    }
}