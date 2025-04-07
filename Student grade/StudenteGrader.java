public class StudenteGrader {
    public int[][] scores; // 2D array to store scores for all students and subjects
    public String[] studentNames; // Array to store student names
    public int totalStudents;
    public int totalSubjects;

    // Method to set student names
    public void setStudentName(int studentIndex, String name) {
        studentNames[studentIndex] = name;
    }

    // Method to set scores
    public void setScore(int studentIndex, int subjectIndex, int score) {
        scores[studentIndex][subjectIndex] = score;
    }

    // Method to calculate the average score for a subject
    public double calculateSubjectAverage(int subjectIndex) {
        int totalScoreForSubject = 0;
        for (int student = 0; student < totalStudents; student++) {
            totalScoreForSubject += scores[student][subjectIndex];
        }
        return (double) totalScoreForSubject / totalStudents;
    }

    // Method to calculate total score for a student
    public int calculateStudentTotal(int studentIndex) {
        int totalScoreForStudent = 0;
        for (int subject = 0; subject < totalSubjects; subject++) {
            totalScoreForStudent += scores[studentIndex][subject];
        }
        return totalScoreForStudent;
    }

    // Auxiliary method to get the maximum possible integer value
    public int getMaximumIntegerValue() {
        int maximum = 1;
        for (int i = 0; i < 31; i++) {
            maximum = maximum * 2;
        }
        return maximum - 1;
    }

    // Method to find the hardest subject (subject with lowest average score)
    public int findHardestSubject() {
        double lowestAverageScore = Double.MAX_VALUE;
        int hardestSubjectIndex = -1;
        for (int subject = 0; subject < totalSubjects; subject++) {
            double averageScore = calculateSubjectAverage(subject);
            if (averageScore < lowestAverageScore) {
                lowestAverageScore = averageScore;
                hardestSubjectIndex = subject;
            }
        }
        return hardestSubjectIndex;
    }

    // Method to find the best graduating student
    public String findBestStudent() {
        int highestTotalScore = 0;
        String bestStudentName = "";
        for (int student = 0; student < totalStudents; student++) {
            int totalScore = calculateStudentTotal(student);
            if (totalScore > highestTotalScore) {
                highestTotalScore = totalScore;
                bestStudentName = studentNames[student];
            }
        }
        return bestStudentName;
    }

    // Method to find the worst graduating student
    public String findWorstStudent() {
        int lowestTotalScore = getMaximumIntegerValue();
        String worstStudentName = "";
        for (int student = 0; student < totalStudents; student++) {
            int totalScore = calculateStudentTotal(student);
            if (totalScore < lowestTotalScore) {
                lowestTotalScore = totalScore;
                worstStudentName = studentNames[student];
            }
        }
        return worstStudentName;
    }

    // Method to check if a student has failed any subject
    public boolean hasFailed(int studentIndex) {
        for (int subject = 0; subject < totalSubjects; subject++) {
            if (scores[studentIndex][subject] < 40) {
                return true;
            }
        }
        return false;
    }
}