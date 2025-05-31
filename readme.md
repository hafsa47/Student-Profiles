# 🎓 Student Registration & Result System

> A GUI-based JavaFX application for registering students, adding subject marks, calculating grades, and displaying results interactively.

---

## 🧰 Tools & Technologies Used

| Tool 🧪          | Purpose 📌                         |
|------------------|-------------------------------------|
| ☕ **Java 21**     | Core programming language           |
| 🧩 **JavaFX 24.0.1** | GUI framework                      |
| 🖥️ **VS Code**     | Code editing environment            |
| 🐱 **GitHub**      | Version control + project hosting   |

---

## 📂 Project Directory Structure

STUDENT_REGISTRATION/
├── .vscode/
│ └── launch.json
├── bin/
│ └── src/
│ ├── Displayable.class
│ ├── Person.class
│ ├── Student.class
│ └── StudentSystemFX.class
├── src/
│ └── StudentSystemFX.java
├── cmd.txt.txt
└── readme.md

```

---

## 📖 Introduction

This JavaFX project allows users to:
- 👥 Register students
- ✏️ Add subject marks with input validation
- 📊 Compute average and grades
- 📋 Display individual and collective results

🛡️ **Validations included**:
- Marks must be between **0–100**
- Students with the same name cannot have the **same roll number**

---

## 🔧 Installation & Setup Guide

### ✅ Step 1: Install Java 21

🔗 [Download Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

Ensure `java` and `javac` are added to your PATH:

```bash
java -version
javac -version
```

✅ Step 2: Install JavaFX SDK 24.0.1
🔗 Download JavaFX SDK

Unzip and place it in a known directory (e.g., C:\javafx-sdk-24.0.1)

✅ Step 3: Clone This GitHub Repository
bash
Copy
Edit
git clone https://github.com/yourusername/STUDENT_REGISTRATION.git
cd STUDENT_REGISTRATION
✅ Step 4: Configure VS Code
📦 Install Java Extension Pack (by Microsoft)

⚙️ Update your launch.json to include JavaFX VM arguments:

json
Copy
Edit
"vmArgs": "--module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls,javafx.fxml"
✅ Replace /path/to/... with your actual SDK path.

🚀 Running the Application
Compile the code:

bash
Copy
Edit
javac --module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls -d bin src/StudentSystemFX.java
Run the application:

bash
Copy
Edit
java --module-path /path/to/javafx-sdk-24.0.1/lib --add-modules javafx.controls -cp bin src.StudentSystemFX
🧠 Main Functional Sections
Section 🚪	Purpose 🎯
registerStudent()	Register new student with name & unique roll
addMarks()	Add multiple subject marks (validated 0–100)
showStudentResult()	Show detailed student report card
showAllStudents()	Display all registered students
findStudent()	Lookup students by roll number

🏁 Conclusion
This project is a 🔰 beginner-to-intermediate level JavaFX application that:

Reinforces OOP (Inheritance + Interface)

Practices GUI handling with dialogs

Applies input validation logic

Uses dynamic data structures (ArrayList, Pair)

✅ You can extend this with:

Database integration (e.g., SQLite)

Login/Auth system

RESTful backend or cloud sync

🔗 Resources
🧩 JavaFX Docs: https://openjfx.io

📘 JavaFX Tutorials: https://code.makery.ch/library/javafx-tutorial/

🐙 GitHub Repo: https://github.com/yourusername/STUDENT_REGISTRATION

📫 Maintainer: [Your Name or Handle]
📌 If you like it, give it a ⭐ on GitHub!

