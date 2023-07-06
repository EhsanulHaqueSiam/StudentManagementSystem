# Student Management System

Welcome to the Student Management System project! This project aims to provide a user-friendly interface for managing student information, course registration, and administration tasks. The system is built using Java Swing for the graphical user interface (GUI) and utilizes a MySQL database for data storage and retrieval.

## Getting Started

To get started with the project, follow the instructions below:

### Prerequisites

- Java Development Kit (JDK): Make sure you have JDK installed on your system. You can download the latest version from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- MySQL Database: Install and set up a MySQL database on your machine. You can download the MySQL Community Server from the [official MySQL website](https://dev.mysql.com/downloads/installer/).

### Setting up the Project

1. Clone the repository:

   ```
   git clone https://github.com/EhsanulHaqueSiam/student-management-system.git
   ```

2. Open the project in your Java IDE.

3. Configure the MySQL database connection:

   - Open the `src/main/resources/config.properties` file.
   - Modify the `db.url`, `db.username`, and `db.password` properties to match your MySQL database configuration.

4. Import the required libraries:

   - The project uses JDBC for database connectivity. Make sure the JDBC driver is included in your project's classpath. You can find the JDBC driver for MySQL on the [official MySQL website](https://dev.mysql.com/downloads/connector/j/).

5. Build and run the project:
   - Build the project using your IDE's build tools.
   - Run the project to launch the Student Management System.

## Features

### Login Page

- The system provides a simple login page for students and admin. Users can enter their credentials to access the system.

### Student Dashboard

- Students can view the courses they are enrolled in for the current semester. This information is retrieved from the MySQL database and displayed in a user-friendly format.

### Course Registration

- Students can register for courses on a designated registration day, as determined by the admin. They can select from the available courses and submit their registration.

### Admin Panel

- The admin has access to a comprehensive admin panel to manage various aspects of the system.
- Admin can manage students, including adding new students, updating their information, and removing students if necessary.
- Admin can manage teachers, assign them courses, and update their details.
- Admin can create and manage courses, including adding new courses, modifying course information, and deleting courses.
- Admin can define the registration day and manage the course registration process.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code as per the terms of the license.

## Acknowledgments

We would like to acknowledge the following resources and libraries that helped in the development of this project:

- Java Swing: Java's GUI toolkit for creating desktop applications.
- MySQL: An open-source relational database management system.
- JDBC: Java Database Connectivity API for connecting Java applications to databases.

## Contact

If you have any questions, suggestions, or feedback, please contact the project maintainer

at [ehsanul.siamdev@gmail.com](mailto:ehsanul.siamdev@gmail.com).
