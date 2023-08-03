# Student Management System 📚

Welcome to the Student Management System project! 🚀 This project aims to provide a user-friendly interface for managing student information, course registration, and administration tasks. The system is built using Java Swing for the graphical user interface (GUI) and utilizes a MySQL database for data storage and retrieval.

## Getting Started 🏁

To start using the Student Management System, follow these steps:

### Prerequisites 🛠️

- **Java Development Kit (JDK):** Make sure you have the power of Java installed on your system. You can download the latest version from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- **MySQL Database:** Install and set up a MySQL database on your machine. You can download the MySQL Community Server from the [official MySQL website](https://dev.mysql.com/downloads/installer/).

### Setting up the Project ⚙️

1. **Clone the Repository:** Start by cloning this repository to your local machine:

   ```sh
   git clone https://github.com/EhsanulHaqueSiam/StudentManagementSystem.git
   ```

2. **Database Configuration:** Open the `src/main/resources/config.properties` file and configure the database connection:

   - Modify the `db.url`, `db.username`, and `db.password` properties to match your MySQL database configuration.

3. **Required Libraries:** The magic ingredients! Ensure that the JDBC driver is included in your project's classpath. You can find the JDBC driver for MySQL on the [official MySQL website](https://dev.mysql.com/downloads/connector/j/).

4. **Build and Run:** Now it's time to wield your compiler's magic wand:

   ```sh
   # Navigate to the project directory
   cd StudentManagementSystem

   # Compile the source code
   javac -cp .:lib/* -d bin src/main/java/com/StudentManagementSystem/Main.java

   # Run the project
   java -cp .:lib/*:bin com.StudentManagementSystem.Main
   ```

## Acknowledgments 🙏

A heartfelt thank you to our esteemed faculty:

🎓 **MD SAJID BIN-FAISAL**
🎓 **Database Faculty, AIUB**

Your guidance, wisdom, and support have been invaluable in shaping this project.

## Connection Pooling 🔗

The `DatabaseManager` class provides a centralized and efficient way to manage database connections using a connection pool. It follows the Singleton pattern to ensure a single instance of the connection pool is maintained throughout the application's lifecycle.

## ConfigLoader Utility ⚙️

The `ConfigLoader` class is a utility that magically loads configuration properties from a file. It follows the Singleton pattern to ensure only one instance of `ConfigLoader` is created.

## Contact 📬

If you have any questions, suggestions, or feedback, feel free to reach out:

📧 [ehsanul.siamdev@gmail.com](mailto:ehsanul.siamdev@gmail.com)

Now, you're all set to wield your coding spells and manage students with ease! 🧙‍♂️✨
