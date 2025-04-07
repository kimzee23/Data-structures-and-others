import java.util.Scanner;  // Importing Scanner for user input
import java.util.regex.Pattern;  // Importing the regex package for name validation

/**
 * A program to collect and process student scores for class summary.
 * The app provides insights on the hardest and easiest subjects, best and worst graduating students,
 * and overall class statistics such as total score and class average.
 */
public class StudentGradeAppe {

    // Main method that runs the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner for input
        int numStudents;  // Number of students in the class
        int numSubjects;  // Number of subjects in the class

        // Asking teacher for the number of students
        System.out.print("Teacher, please enter the number of students in the class: ");
        numStudents = scanner.nextInt();

        // Asking teacher for the number of subjects
        System.out.print("Teacher, please enter the number of subjects for this class: ");
        numSubjects = scanner.nextInt();

        // 2D array to store student scores and array for storing student names
        int[][] studentScores = new int[numStudents][numSubjects];
        String[] studentNames = new String[numStudents];  // Array to store student names

        // Loop to input student names and their subject scores
        for (int student = 0; student < numStudents; student++) {
            scanner.nextLine();  // Consume newline character after nextInt()

            // Asking for student name with validation using regex (only alphabetic characters allowed)
            String studentName;
            do {
                System.out.print("Enter name for Student " + (student + 1) + " (Format: Firstname Lastname): ");
                studentName = scanner.nextLine();
                if (!Pattern.matches("^[A-Za-z]+(?: [A-Za-z]+)*$", studentName)) {
                    System.out.println("Error: Invalid name format. Please enter a valid name.");
                }
            } while (!Pattern.matches("^[A-Za-z]+(?: [A-Za-z]+)*$", studentName));  // Loop until valid name format

            studentNames[student] = studentName;  // Store student name

            // Asking for the subject scores for each student
            System.out.println("Enter the scores for " + studentName + ":");
            for (int subject = 0; subject < numSubjects; subject++) {
                int score;
                do {
                    System.out.print(" Score for Subject " + (subject + 1) + ": ");
                    score = scanner.nextInt();

                    // Validation: score must be between 0 and 100
                    if (score < 0 || score > 100) {
                        System.out.println("Error: Score must be between 0 and 100. Please try again.");
                    }
                } while (score < 0 || score > 100);  // Repeat until valid score is entered
                studentScores[student][subject] = score;  // Store the score
            }
        }

        // Arrays to store total scores, averages, and subject averages
        int[] totalScores = new int[numStudents];
        int[] averages = new int[numStudents];
        int[] subjectAverages = new int[numSubjects];
        int classTotal = 0;

        // Calculate total and average scores, as well as subject averages
        for (int student = 0; student < numStudents; student++) {
            int studentTotal = 0;
            for (int subject = 0; subject < numSubjects; subject++) {
                studentTotal += studentScores[student][subject];  // Sum up the scores for each student
            }
            totalScores[student] = studentTotal;
            averages[student] = studentTotal / numSubjects;
            classTotal += studentTotal;

            // Calculate subject averages
            for (int subject = 0; subject < numSubjects; subject++) {
                subjectAverages[subject] += studentScores[student][subject];
            }
        }

        // Calculate overall class average
        int classAverage = classTotal / (numStudents * numSubjects);

        // Calculate and display hardest and easiest subjects, highest and lowest scores
        int hardestSubject = 0;
        int easiestSubject = 0;
        int highestScore = 0;
        int lowestScore = 100;
        String highestStudent = "";
        String lowestStudent = "";
        int highestSubject = 0;
        int lowestSubject = 0;

        // Find hardest/easiest subject and overall highest/lowest scores
        for (int subject = 0; subject < numSubjects; subject++) {
            int failureCount = 0;
            int passCount = 0;

            for (int student = 0; student < numStudents; student++) {
                if (studentScores[student][subject] < 40) {
                    failureCount++;
                } else {
                    passCount++;
                }

                // Find overall highest and lowest scores
                if (studentScores[student][subject] > highestScore) {
                    highestScore = studentScores[student][subject];
                    highestStudent = studentNames[student];
                    highestSubject = subject + 1;
                }
                if (studentScores[student][subject] < lowestScore) {
                    lowestScore = studentScores[student][subject];
                    lowestStudent = studentNames[student];
                    lowestSubject = subject + 1;
                }
            }

            // Determine hardest and easiest subjects based on failure rates
            if (failureCount > passCount) {
                hardestSubject = subject;
            } else {
                easiestSubject = subject;
            }
        }

        // Display the first output: Hardest/easiest subjects, highest/lowest scores
        System.out.println("###########################################################################");
        System.out.println("The hardest Subject is Sub" + (hardestSubject + 1) + ", having the highest rate of failures.");
        System.out.println("The easiest subject is Sub" + (easiestSubject + 1) + ", having the lowest rate of failures.");
        System.out.println("The Overall Highest score is scored by " + highestStudent + " in Subject" + highestSubject + " scoring " + highestScore + ".");
        System.out.println("The Overall Lowest score is scored by " + lowestStudent + " in Subject" + lowestSubject + " scoring " + lowestScore + ".");
        System.out.println("###########################################################################");

        // Display the class summary
        System.out.println("CLASS SUMMARY");
        System.out.println("###########################################################################");

        // Find best and worst graduating students based on total scores
        int bestStudentIndex = 0;
        int worstStudentIndex = 0;
        for (int student = 1; student < numStudents; student++) {
            if (totalScores[student] > totalScores[bestStudentIndex]) {
                bestStudentIndex = student;
            }
            if (totalScores[student] < totalScores[worstStudentIndex]) {
                worstStudentIndex = student;
            }
        }

        System.out.println("Best Graduating Student Is: " + studentNames[bestStudentIndex] + ", scoring the total of " + totalScores[bestStudentIndex] + ".");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Lowest Graduating Student Is: " + studentNames[worstStudentIndex] + ", scoring the total of " + totalScores[worstStudentIndex] + ".");
        System.out.println("###########################################################################");
        System.out.println("The Class Total Score: " + classTotal);
        System.out.println("The Class Average Score: " + (double) classTotal / numStudents);
        System.out.println();

        // Display the second output: Class summary table
        System.out.println("==================================================================================");
        System.out.println("STUDENT    SUB1    SUB2    SUB3    TOTAL   AVERAGE   POSITION");
        System.out.println("==================================================================================");

        // Sorting students by their total scores in descending order
        for (int student = 0; student < numStudents; student++) {
            for (int i = student + 1; i < numStudents; i++) {
                if (totalScores[student] < totalScores[i]) {
                    // Swapping scores and names for sorting
                    int tempTotal = totalScores[student];
                    totalScores[student] = totalScores[i];
                    totalScores[i] = tempTotal;

                    int tempAverage = averages[student];
                    averages[student] = averages[i];
                    averages[i] = tempAverage;

                    String tempName = studentNames[student];
                    studentNames[student] = studentNames[i];
                    studentNames[i] = tempName;
                }
            }
        }

        // Displaying the sorted student scores and information
        for (int student = 0; student < numStudents; student++) {
            System.out.printf("%-12s%-8d%-8d%-8d%-8d%-10.2f%-10d\n", studentNames[student], studentScores[student][0], studentScores[student][1], studentScores[student][2], totalScores[student], (double)totalScores[student] / numSubjects, student + 1);
        }

        System.out.println("==================================================================================");
        System.out.println("Thank You For Choosing Student Grade App For Your School!");
        System.out.println("==================================================================================");
    }
}