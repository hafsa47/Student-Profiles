# 🎓 Student Registration & Result System

A user-friendly **JavaFX** application for managing student registrations, recording subject marks, calculating grades, and displaying results interactively. Perfect for academic institutions or learning OOP with a practical project! 🚀

---

## 🛠️ Tools & Technologies Used

![Java](https://img.shields.io/badge/Java-24-blue?style=flat-square)
![JavaFX](https://img.shields.io/badge/JavaFX-24.0.1-green?style=flat-square)
![VS Code](https://img.shields.io/badge/VS_Code-IDE-blue?style=flat-square)
![GitHub](https://img.shields.io/badge/GitHub-Version_Control-yellow?style=flat-square)

---

## 📂 Project Directory Structure

```
STUDENT_REGISTRATION/
├── .vscode/
│   └── launch.json
├── bin/
│   └── src/
│       ├── Displayable.class
│       ├── Person.class
│       ├── Student.class
│       └── StudentSystemFX.class
├── src/
│   └── StudentSystemFX.java
├── cmd.txt
└── README.md
```

---

## 📚 Project Overview

This **JavaFX-based** application simplifies student management with the following features:

- 👩‍🎓 **Register Students**: Add students with unique roll numbers and names.
- ✍️ **Record Marks**: Input subject marks with validation (0–100 range).
- 📈 **Calculate Grades**: Automatically compute averages and assign grades.
- 📋 **Display Results**: View individual report cards or a list of all students.

### 🛡️ Input Validations
- Marks must be between **0–100**.
- No duplicate roll numbers for students with the same name.

---

## 🚀 Installation & Setup Guide

Follow these steps to get the project up and running on your machine! 🖥️

### 1️⃣ Install Java 24
- Download and install **Java JDK 24** from [Oracle's official site](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html).
- Verify installation:
  ```bash
  java -version
  javac -version
  ```

### 2️⃣ Install JavaFX SDK 24.0.1
- Download the **JavaFX SDK** from [openjfx.io](https://openjfx.io).
- Unzip to a directory (e.g., `C:\javafx-sdk-24.0.1` or `/opt/javafx-sdk-24.0.1`).

### 3️⃣ Clone the Repository
- Clone this project to your local machine:
  ```bash
  git clone https://github.com/yourusername/STUDENT_REGISTRATION.git
  cd STUDENT_REGISTRATION
  ```

### 4️⃣ Configure VS Code
- Install the **Java Extension Pack** by Microsoft in VS Code.
- Update `.vscode/launch.json` to include JavaFX VM arguments:
  ```json
  {
    "vmArgs": "--module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls,javafx.fxml"
  }
  ```
  Replace `/path/to/javafx-sdk-24.0.1` with the actual path to your JavaFX SDK.

### 5️⃣ Compile and Run
- Compile the application:
  ```bash
  javac --module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls -d bin src/StudentSystemFX.java
  ```
- Run the application:
  ```bash
  java --module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls -cp bin src.StudentSystemFX
  ```

---

## 🧠 Core Features

| **Function**          | **Purpose**                                      |
|-----------------------|--------------------------------------------------|
| `registerStudent()`   | Register a new student with a unique roll number. |
| `addMarks()`          | Add subject marks with 0–100 validation.         |
| `showStudentResult()` | Display a detailed report card for a student.    |
| `showAllStudents()`   | List all registered students and Oto the system. |
| `findStudent()`       | Search for a student by roll number.             |

---

## 🌟 Why This Project?

This project is a fantastic way to learn **JavaFX** and **OOP** concepts! It covers:
- **Inheritance**: Using the `Person` and `Student` classes.
- **Interfaces**: Implementing `Displayable` for result formatting.
- **Dynamic Data Structures**: Leveraging `ArrayList` and `Pair`.
- **GUI Design**: Building interactive interfaces with JavaFX dialogs.

### Example Scenario
Imagine a teacher registering a student named "Alice" with roll number 101. They input marks (e.g., Math: 85, Science: 90). The system validates the marks, calculates an average (87.5), assigns a grade (e.g., B+), and displays a neat report card in a dialog box! 😎

---

## 🔮 Future Enhancements

Take this project to the next level with:
- 🗄️ **Database Integration**: Store data in SQLite or MySQL.
- 🔒 **Authentication**: Add a login system for teachers/admins.
- ☁️ **Cloud Sync**: Integrate with a RESTful API for online access.

---

## 📚 Resources

- [JavaFX Documentation](https://openjfx.io)
- [JavaFX Tutorials](https://code.makery.ch/library/javafx-tutorial/)
- [GitHub Repository](https://github.com/yourusername/STUDENT_REGISTRATION)

---

## 🙌 Contributing

Got ideas to improve the project? Fork the repo, make changes, and submit a pull request! Let’s make this project even better together. 😄

⭐ **Star the repo** on GitHub if you find it helpful!

---

## 📬 Contact

**Maintainer**: [Your Name or Handle]  
Reach out for questions, feedback, or just to say hi! 👋

---

💡 **Pro Tip**: Running into JavaFX setup issues? Double-check your SDK path and VM arguments. If the GUI doesn’t pop up, it’s probably a sneaky classpath error! 😜
