import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StudentGradeAppGUI extends JFrame {

    private JTextField numStudentsField, numSubjectsField;
    private JButton startButton;
    private JPanel dataEntryPanel;
    private int numStudents, numSubjects;
    private int currentStudent = 0;
    private List<String> studentNames = new ArrayList<>();
    private List<int[]> studentScores = new ArrayList<>();
    private JLabel studentNameLabel;
    private JTextField studentNameField;
    private JLabel[] scoreLabels;
    private JTextField[] scoreFields;
    private JButton nextStudentButton;
    private JTextArea outputTextArea;
    private JTable studentTable;
    private JLabel subjectResultsLabel;

    // Theme Colors
    private final Color PRIMARY_COLOR = new Color(74, 171, 239);
    private final Color SECONDARY_COLOR = new Color(220, 230, 250);
    private final Color TEXT_COLOR = Color.DARK_GRAY;
    private final Font APP_FONT = new Font("Arial", Font.PLAIN, 14);
    private final Border INPUT_BORDER = BorderFactory.createLineBorder(PRIMARY_COLOR, 1);
    private final Border PANEL_BORDER = BorderFactory.createEmptyBorder(10,10,10,10);
    public StudentGradeAppGUI() {
        setTitle("Student Grade App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLayout(new BorderLayout());
        
        //Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBorder(PANEL_BORDER);
        JLabel numStudentsLabel = new JLabel("Number of Students:");
        numStudentsField = new JTextField(5);
        JLabel numSubjectsLabel = new JLabel("Number of Subjects:");
        numSubjectsField = new JTextField(5);
        startButton = new JButton("Start Data Entry");

        // Apply Styles
        applyCommonStyles(inputPanel);
        applyCommonStyles(numStudentsLabel);
        applyCommonStyles(numSubjectsLabel);
        numStudentsField.setBorder(INPUT_BORDER);
        numSubjectsField.setBorder(INPUT_BORDER);
        startButton.setBackground(PRIMARY_COLOR);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(APP_FONT);
        startButton.setFocusPainted(false);

        inputPanel.add(numStudentsLabel);
        inputPanel.add(numStudentsField);
        inputPanel.add(numSubjectsLabel);
        inputPanel.add(numSubjectsField);
        inputPanel.add(startButton);
        mainPanel.add(inputPanel, BorderLayout.NORTH);

        // Data Entry Panel
        dataEntryPanel = new JPanel(new GridBagLayout());
        dataEntryPanel.setVisible(false);
        dataEntryPanel.setBorder(PANEL_BORDER);
         mainPanel.add(dataEntryPanel, BorderLayout.CENTER);

        // Output Panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        subjectResultsLabel = new JLabel("");
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(APP_FONT);
        outputPanel.add(subjectResultsLabel, BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        // Table
        studentTable = new JTable();
        JScrollPane tableScroll = new JScrollPane(studentTable);
        outputPanel.add(tableScroll, BorderLayout.SOUTH);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        startButton.addActionListener(e -> {
            try {
                numStudents = Integer.parseInt(numStudentsField.getText());
                numSubjects = Integer.parseInt(numSubjectsField.getText());
                studentNames.clear();
                studentScores.clear();
                currentStudent = 0;
                buildDataEntryPanel();
                dataEntryPanel.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        nextStudentButton = new JButton("Next Student");
        nextStudentButton.addActionListener(e -> processStudentData());

        setVisible(true);
    }

    private void buildDataEntryPanel() {
        dataEntryPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        studentNameLabel = new JLabel("Enter Name for Student " + (currentStudent + 1) + " (Format: Firstname Lastname): ");
        studentNameField = new JTextField(20);
        applyCommonStyles(studentNameLabel);
        studentNameField.setBorder(INPUT_BORDER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        dataEntryPanel.add(studentNameLabel, gbc);
        gbc.gridx = 1;
        dataEntryPanel.add(studentNameField, gbc);

        scoreLabels = new JLabel[numSubjects];
        scoreFields = new JTextField[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            scoreLabels[i] = new JLabel("Score for Subject " + (i + 1) + ": ");
            scoreFields[i] = new JTextField(5);
             applyCommonStyles(scoreLabels[i]);
            scoreFields[i].setBorder(INPUT_BORDER);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            dataEntryPanel.add(scoreLabels[i], gbc);
            gbc.gridx = 1;
            dataEntryPanel.add(scoreFields[i], gbc);
        }
        gbc.gridx = 0;
        gbc.gridy = numSubjects + 1;
        nextStudentButton.setBackground(PRIMARY_COLOR);
        nextStudentButton.setForeground(Color.WHITE);
        nextStudentButton.setFont(APP_FONT);
        nextStudentButton.setFocusPainted(false);
        dataEntryPanel.add(nextStudentButton, gbc);


        dataEntryPanel.revalidate();
        dataEntryPanel.repaint();
    }


    private void processStudentData() {
        String studentName = studentNameField.getText();
        if (!Pattern.matches("^[A-Za-z]+(?: [A-Za-z]+)*$", studentName)) {
            JOptionPane.showMessageDialog(this, "Error: Invalid Name format. Please enter valid name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        studentNames.add(studentName);

        int[] scores = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            try {
                int score = Integer.parseInt(scoreFields[i].getText());
                if (score < 0 || score > 100) {
                    JOptionPane.showMessageDialog(this, "Error: Score must be between 0 and 100.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                scores[i] = score;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid scores.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        studentScores.add(scores);
        currentStudent++;

        if (currentStudent < numStudents) {
            buildDataEntryPanel();
        } else {
            dataEntryPanel.setVisible(false);
            calculateAndDisplayResults();
        }

    }

    private void calculateAndDisplayResults() {
        int[] totalScores = new int[numStudents];
        int[] averages = new int[numStudents];
        int[] subjectAverages = new int[numSubjects];
        int classTotal = 0;

        for (int student = 0; student < numStudents; student++) {
            int studentTotal = 0;
            for (int subject = 0; subject < numSubjects; subject++) {
                studentTotal += studentScores.get(student)[subject];
            }
            totalScores[student] = studentTotal;
            averages[student] = studentTotal / numSubjects;
            classTotal += studentTotal;

            for (int subject = 0; subject < numSubjects; subject++) {
                subjectAverages[subject] += studentScores.get(student)[subject];
            }
        }

        int classAverage = classTotal / (numStudents * numSubjects);
        int hardestSubject = 0;
        int easiestSubject = 0;
        int highestScore = 0;
        int lowestScore = 100;
        String highestStudent = "";
        String lowestStudent = "";
        int highestSubject = 0;
        int lowestSubject = 0;

        for (int subject = 0; subject < numSubjects; subject++) {
            int failureCount = 0;
            int passCount = 0;

            for (int student = 0; student < numStudents; student++) {
                if (studentScores.get(student)[subject] < 40) {
                    failureCount++;
                } else {
                    passCount++;
                }

                if (studentScores.get(student)[subject] > highestScore) {
                    highestScore = studentScores.get(student)[subject];
                    highestStudent = studentNames.get(student);
                    highestSubject = subject + 1;
                }
                if (studentScores.get(student)[subject] < lowestScore) {
                    lowestScore = studentScores.get(student)[subject];
                    lowestStudent = studentNames.get(student);
                    lowestSubject = subject + 1;
                }
            }

            if (failureCount > passCount) {
                hardestSubject = subject;
            } else {
                easiestSubject = subject;
            }
        }
         outputTextArea.append("###########################################################################\n");
        outputTextArea.append("The hardest Subject is Sub" + (hardestSubject + 1) + ", having the highest rate of failures.\n");
        outputTextArea.append("The easiest subject is Sub" + (easiestSubject + 1) + ", having the lowest rate of failures.\n");
        outputTextArea.append("The Overall Highest score is scored by " + highestStudent + " in Subject" + highestSubject + " scoring " + highestScore + ".\n");
        outputTextArea.append("The Overall Lowest score is scored by " + lowestStudent + " in Subject" + lowestSubject + " scoring " + lowestScore + ".\n");
        outputTextArea.append("###########################################################################\n");



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

         outputTextArea.append("CLASS SUMMARY\n");
        outputTextArea.append("###########################################################################\n");
         outputTextArea.append("Best Graduating Student Is: " + studentNames.get(bestStudentIndex) + ", scoring the total of " + totalScores[bestStudentIndex] + ".\n");
        outputTextArea.append("-------------------------------------------------------------------------------------------------\n");
         outputTextArea.append("Lowest Graduating Student Is: " + studentNames.get(worstStudentIndex) + ", scoring the total of " + totalScores[worstStudentIndex] + ".\n");
         outputTextArea.append("###########################################################################\n");
        outputTextArea.append("The Class Total Score: " + classTotal + "\n");
        outputTextArea.append("The Class Average Score: " + (double) classTotal / numStudents + "\n");
        outputTextArea.append("\n");
         outputTextArea.append("==================================================================================\n");
        outputTextArea.append("STUDENT    SUB1    SUB2    SUB3    TOTAL   AVERAGE    POSITION\n");
        outputTextArea.append("==================================================================================\n");

        for (int student = 0; student < numStudents; student++) {
            for (int i = student + 1; i < numStudents; i++) {
                if (totalScores[student] < totalScores[i]) {

                    int tempTotal = totalScores[student];
                    totalScores[student] = totalScores[i];
                    totalScores[i] = tempTotal;


                    int tempAverage = averages[student];
                    averages[student] = averages[i];
                    averages[i] = tempAverage;


                    String tempName = studentNames.get(student);
                    studentNames.set(student, studentNames.get(i));
                    studentNames.set(i, tempName);
                }
            }
        }

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("STUDENT");
        for (int i = 1; i <= numSubjects; i++) {
            model.addColumn("SUB" + i);
        }
        model.addColumn("TOTAL");
        model.addColumn("AVERAGE");
        model.addColumn("POSITION");

        for (int student = 0; student < numStudents; student++) {
            Object[] row = new Object[numSubjects + 4];
            row[0] = studentNames.get(student);
            for (int i = 0; i < numSubjects; i++) {
                row[i + 1] = studentScores.get(student)[i];
            }
            row[numSubjects + 1] = totalScores[student];
            row[numSubjects + 2] = (double) totalScores[student] / numSubjects;
            row[numSubjects + 3] = student + 1;

            model.addRow(row);
        }
        studentTable.setModel(model);
        outputTextArea.append("==================================================================================\n");
        outputTextArea.append("Thank You For Choosing Student Grade App For Your School!\n");
        outputTextArea.append("==================================================================================\n");

        subjectResultsLabel.setText("Calculation Complete");
    }


    // Common Styles
    private void applyCommonStyles(JComponent component) {
        component.setFont(APP_FONT);
        component.setForeground(TEXT_COLOR);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGradeAppGUI::new);
    }
}