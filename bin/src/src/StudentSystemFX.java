package src;

import javafx.util.Pair;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.ArrayList;

// Base Interface for Displayable Entities
interface Displayable {
    String getDisplayInfo();
}

// Abstract base class for Person
abstract class Person {
    protected String name;
    protected int rollNumber;

    public Person(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public abstract String getName();
    public abstract int getRollNumber();
}

// Student class extends Person and implements Displayable
class Student extends Person implements Displayable {
    private ArrayList<Pair<String, Integer>> subjectMarks;

    public Student(String name, int rollNumber) {
        super(name, rollNumber);
        this.subjectMarks = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }

    public void addSubjectMark(String subject, int mark) {
        subjectMarks.add(new Pair<>(subject, mark));
    }

    public ArrayList<Pair<String, Integer>> getSubjectMarks() {
        return subjectMarks;
    }

    public double getAverage() {
        if (subjectMarks.isEmpty()) return 0;
        int total = 0;
        for (Pair<String, Integer> p : subjectMarks) {
            total += p.getValue();
        }
        return (double) total / subjectMarks.size();
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 50) return "C";
        else return "Fail";
    }

    @Override
    public String getDisplayInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
          .append(", Roll: ").append(rollNumber)
          .append(", Avg: ").append(String.format("%.2f", getAverage()))
          .append(", Grade: ").append(getGrade())
          .append(", Subjects: ");
        for (Pair<String, Integer> p : subjectMarks) {
            sb.append(p.getKey()).append(": ").append(p.getValue()).append("; ");
        }
        return sb.toString();
    }
}

public class StudentSystemFX extends Application {
    private ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Button registerBtn = createButton("Register Student");
        Button addMarksBtn = createButton("Add Marks");
        Button showResultBtn = createButton("Show Student Result");
        Button showAllBtn = createButton("Show All Students");
        Button exitBtn = createButton("Exit");

        root.getChildren().addAll(registerBtn, addMarksBtn, showResultBtn, showAllBtn, exitBtn);

        registerBtn.setOnAction(e -> registerStudent());
        addMarksBtn.setOnAction(e -> addMarks());
        showResultBtn.setOnAction(e -> showStudentResult());
        showAllBtn.setOnAction(e -> showAllStudents());
        exitBtn.setOnAction(e -> System.exit(0));

        Scene scene = new Scene(root, 500, 400);
        stage.setTitle("Student Registration & Result System");
        stage.setScene(scene);
        stage.show();
    }

    private Button createButton(String text) {
        Button btn = new Button(text);
        btn.setPrefWidth(250);
        btn.setPrefHeight(40);
        return btn;
    }

    private void registerStudent() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Register Student");

        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        TextField rollField = new TextField();

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Roll Number:"), 0, 1);
        grid.add(rollField, 1, 1);

        dialog.getDialogPane().setContent(grid);
        ButtonType okButtonType = new ButtonType("Register", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                return new Pair<>(nameField.getText(), rollField.getText());
            }
            return null;
        });

        dialog.showAndWait().ifPresent(result -> {
            try {
                String name = result.getKey().trim();
                int roll = Integer.parseInt(result.getValue().trim());

                for (Student s : students) {
                    if (s.getRollNumber() == roll) {
                        showAlert(Alert.AlertType.ERROR, "Roll number already used. Must be unique.");
                        return;
                    }
                }

                students.add(new Student(name, roll));
                showAlert(Alert.AlertType.INFORMATION, "Student registered!");
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid roll number.");
            }
        });
    }

    private void addMarks() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Enter Roll Number:");
        inputDialog.showAndWait().ifPresent(input -> {
            try {
                int roll = Integer.parseInt(input);
                Student student = findStudent(roll);
                if (student != null) {
                    TextInputDialog numDialog = new TextInputDialog();
                    numDialog.setHeaderText("Enter number of subjects:");
                    numDialog.showAndWait().ifPresent(n -> {
                        try {
                            int num = Integer.parseInt(n);
                            for (int i = 1; i <= num; i++) {
                                TextInputDialog subjDialog = new TextInputDialog();
                                subjDialog.setHeaderText("Enter name of subject " + i + ":");
                                String subject = subjDialog.showAndWait().orElse("").trim();
                                if (subject.isEmpty()) {
                                    showAlert(Alert.AlertType.ERROR, "Subject name cannot be empty.");
                                    return;
                                }

                                TextInputDialog markDialog = new TextInputDialog();
                                markDialog.setHeaderText("Enter mark for " + subject + ":");
                                int mark = Integer.parseInt(markDialog.showAndWait().orElse("0"));

                                if (mark < 0 || mark > 100) {
                                    showAlert(Alert.AlertType.ERROR, "Marks must be between 0 and 100.");
                                    return;
                                }

                                student.addSubjectMark(subject, mark);
                            }
                            showAlert(Alert.AlertType.INFORMATION, "Marks added successfully!");
                        } catch (NumberFormatException e) {
                            showAlert(Alert.AlertType.ERROR, "Invalid number entered.");
                        }
                    });
                } else {
                    showAlert(Alert.AlertType.ERROR, "Student not found.");
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input.");
            }
        });
    }

    private void showStudentResult() {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Enter Roll Number:");
        inputDialog.showAndWait().ifPresent(input -> {
            try {
                int roll = Integer.parseInt(input);
                Student student = findStudent(roll);
                if (student != null) {
                    StringBuilder result = new StringBuilder();
                    result.append("Name: ").append(student.getName()).append("\n");
                    result.append("Roll Number: ").append(student.getRollNumber()).append("\n");
                    result.append("Subjects and Marks:\n");
                    for (Pair<String, Integer> p : student.getSubjectMarks()) {
                        result.append(p.getKey()).append(": ").append(p.getValue()).append("\n");
                    }
                    result.append("Average: ").append(String.format("%.2f", student.getAverage())).append("\n");
                    result.append("Grade: ").append(student.getGrade());
                    showAlert(Alert.AlertType.INFORMATION, result.toString());
                } else {
                    showAlert(Alert.AlertType.ERROR, "Student not found.");
                }
            } catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input.");
            }
        });
    }

    private void showAllStudents() {
        if (students.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "No students registered.");
        } else {
            StringBuilder all = new StringBuilder();
            for (Student s : students) {
                all.append(s.getDisplayInfo()).append("\n");
            }
            showAlert(Alert.AlertType.INFORMATION, all.toString());
        }
    }

    private Student findStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) return s;
        }
        return null;
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
