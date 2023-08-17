# Student Management System 📚

Welcome to the Student Management System project! 🚀 This project empowers you to efficiently manage student information, handle course registrations, and oversee administrative tasks. Developed in Java and integrated with a MySQL database, it ensures seamless data storage and retrieval.

## Table of Contents

- [Getting Started](#getting-started-)
  - [Prerequisites](#prerequisites-%EF%B8%8F)
  - [Setup Process](#setup-process-%EF%B8%8F)
- [Features](#features-)
  - [Connection Pool](#connection-pool-)
  - [ConfigLoader Utility](#configloader-utility-%EF%B8%8F)
  - [DAO Layer](#dao-layer-%EF%B8%8F)
  - [Query Constants](#query-constants-)
  - [MVC Design Pattern](#mvc-design-pattern-%EF%B8%8F)
  - [Testing with JUnit 5](#testing-with-junit-5-)
- [Project Structure Highlights](#project-structure-highlights-)
- [Acknowledgments](#acknowledgments-)
- [Contact](#contact-)

## Getting Started 🏁

Embark on your journey with the Student Management System by following these steps:

### Prerequisites 🛠️

Before diving in, ensure you have the following:

- **Java Development Kit (JDK):** Download the latest version from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

- **MySQL Database:** Set up a MySQL database using the [MySQL Community Server](https://dev.mysql.com/downloads/installer/).

### Setup Process ⚙️

1. **Clone the Repository:** Obtain your own copy of the project:

   ```sh
   git clone https://github.com/EhsanulHaqueSiam/StudentManagementSystem.git
   ```

2. **Database Configuration:** Configure the database connection:

   - Open `src/main/resources/config.properties`.
   - Update `db.url`, `db.username`, and `db.password` to match your MySQL setup.

3. **Library Dependencies:** Add the MySQL JDBC driver to the classpath:

   - Get the [MySQL JDBC driver](https://dev.mysql.com/downloads/connector/j/).

4. **Compile and Run:** Compile and launch the project:

   ```sh
   # Navigate to the project directory
   cd StudentManagementSystem

   # Compile the code
   javac -cp .:lib/* -d bin src/main/java/com/StudentManagementSystem/Main.java

   # Run the project
   java -cp .:lib/*:bin com.StudentManagementSystem.Main
   ```

## Features ✨

Discover the enhanced features of the Student Management System:

### Connection Pool 🌐

Effortlessly manage database connections using the `DatabaseManager` class. In complex applications, establishing a new connection to a database can be resource-intensive and slow. The Connection Pool mechanism in the Student Management System addresses this challenge by maintaining a reusable set of connections. This minimizes the overhead of creating and destroying connections for each interaction.

By utilizing the Singleton pattern, the `DatabaseManager` ensures that a single instance of the connection pool is maintained throughout the application's lifecycle. Whenever the application needs to interact with the database, it can borrow an available connection from the pool, perform the necessary operations, and then return the connection to the pool for future use.

This intelligent management of connections not only enhances the performance of the application but also ensures efficient utilization of system resources. The Connection Pool allows the Student Management System to handle multiple user requests simultaneously while maintaining optimal database interactions.

With the Connection Pool in place, you can focus on seamlessly retrieving and storing data without worrying about the complexities of managing individual database connections.

### ConfigLoader Utility ⚙️

Simplify configuration management with the `ConfigLoader` class. Fetch properties from files with ease, thanks to its Singleton pattern implementation. Experience enhanced code readability and intuitive methods for accessing configuration properties.

### DAO Layer 🏛️

Embrace a clear separation of concerns with the robust DAO (Data Access Object) layer. This essential component includes DAO interfaces and implementations, offering a structured approach to database interactions. Each entity, like `Authorities`, `Classes`, `Course`, boasts a dedicated DAO interface (e.g., `AuthoritiesDAO`, `ClassesDAO`) and corresponding implementation (e.g., `AuthoritiesDAOImpl`, `ClassesDAOImpl`).

### Query Constants 📜

Maintain structured database queries using dedicated query constants. DAO classes such as `AuthoritiesQueryConstants`, `ClassesQueryConstants` encapsulate well-named SQL query constants. This enhances code clarity and minimizes the risk of SQL injection vulnerabilities.

### MVC Design Pattern 🏛️

Experience the elegance of the MVC (Model-View-Controller) design pattern. Models include `Authorities`, `Classes`, `Course`, Views comprise `AuthoritiesView`, `ClassesView`, `CourseView`, and Controllers expertly manage interactions between Models and Views.

### Testing with JUnit 5 🧪

Ensure reliability with comprehensive JUnit 5 test cases. Validate controller behaviors with test classes like `AdminControllerTest`, `StudentControllerTest`. Verify utility functionalities using `ConfigLoaderTest` and `DatabaseManagerTest`.

## Project Structure Highlights 🌟

Explore the organized project structure:

- **Separate Test Resources:** The `test` directory holds essential resources like `expectedOutput.txt`, `testConfig.properties`, and `testData.json` for effective testing.

- **Library Dependencies:** The `lib` directory contains critical library JAR files, including `junit-platform-console-standalone-1.10.0.jar`, `ojdbc11.jar`, and `mysql-connector-j-8.1.0.jar`.

- **VSCode Settings:** Inside the `.vscode` directory, discover tailored configuration files like `launch.json` and `settings.json` designed for seamless integration with Visual Studio Code.

- **Clear Hierarchy:** Navigate the `src` directory, which boasts distinct subdirectories for various project aspects, such as:

  - **Main:** Home to the primary application code, including the pivotal entry point `Main.java`.
  - **Controller:** Manage user interface interactions and data orchestration, e.g., `AuthoritiesController`, `ClassesController`.
  - **Data:** Houses Data Access Object (DAO) classes, each comprising an interface and implementation, e.g., `AuthoritiesDAO`, `AuthoritiesDAOImpl`.
  - **Model:** Defines critical entities such as `Authorities`, `Classes`, `Course`.
  - **Util:** Hosts utility classes like `ConfigLoader`, `DatabaseManager`.
  - **View:** Provides intuitive user interfaces including `AuthoritiesView`, `ClassesView`.
  - **Resources:** Safeguard configuration files like `config.properties`, as well as assets like images stored within the `images` subdirectory.
  - **Test:** Dedicated to JUnit 5 test classes, fortifying the system's robustness and correctness.

- **Well-Documented Code:** Delve into the well-commented and documented Java source files, offering insights into functionality, usage, and design considerations. This comprehensive documentation eases comprehension, maintenance, and extension of the system.
  
- **Multi-Threading with Main Thread:** The application leverages multi-threading in the main thread to enhance user experience and database interaction. While the user interacts with the command line interface, the main thread concurrently establishes and maintains a database connection in the background. This design ensures that the user doesn't experience delays caused by database connections, leading to a seamless and responsive user experience.

- **Graceful Shutdown with Shutdown Hook:** To ensure proper closing of the database connection when the program ends, a shutdown hook is registered. The shutdown hook, implemented as a separate thread, closes the database connection gracefully, preventing any resource leaks or data corruption.

## Acknowledgments 🙏

We extend our sincere gratitude to our esteemed faculty:

🎓 **MD SAJID BIN-FAISAL**<br>
🎓 **Database Faculty, AIUB**

Your invaluable guidance has played a pivotal role in shaping this project, fostering a deep understanding of database management and software development principles.

## Contact 📬

For inquiries, suggestions, or feedback, please don't hesitate to reach out to us:

📧 [ehsanul.siamdev@gmail.com](mailto:ehsanul.siamdev@gmail.com)

Embark on this coding journey with confidence and wield your newfound skills to manage students with finesse! 🧙‍♂️✨
