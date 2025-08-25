# PeepLog: Your Ultimate Friend Management API

[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/your-username/PeepLog/actions)
[![License](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

## 🚀 Overview

Welcome to **PeepLog**, a robust and efficient backend API designed for seamless friend management. Built with the power of Kotlin and the Spring Boot framework, PeepLog provides a clean, RESTful interface to handle all your friend-related operations, from adding new connections to managing existing ones.

This project serves as a foundational example for building scalable and maintainable microservices with modern JVM technologies.

## ✨ Features

*   **Comprehensive Friend Management**: Easily add, retrieve, update, and delete friend records.
*   **RESTful API Design**: Intuitive and well-structured endpoints for easy integration.
*   **Spring Boot Powered**: Leverages Spring Boot's conventions for rapid development and deployment.
*   **Kotlin First**: Written entirely in Kotlin, ensuring conciseness, safety, and expressiveness.
*   **Database Agnostic**: Configured for H2 (in-memory) for development and testing, with seamless integration for MySQL in production environments.
*   **Insightful Logging**: Detailed logging provides visibility into application behavior and aids in debugging.

## 🛠️ Technologies Used

*   **Language**: Kotlin
*   **Framework**: Spring Boot (Web, Data JPA)
*   **Build Tool**: Gradle
*   **Databases**:
    *   H2 Database (for development/testing)
    *   MySQL (via `mysql-connector-j` for production)
*   **Logging**: SLF4J with Logback (default Spring Boot logging)
*   **JVM**: Java 11+

## 🚦 Getting Started

Follow these steps to get PeepLog up and running on your local machine.

### Prerequisites

*   Java Development Kit (JDK) 11 or higher
*   Gradle (usually bundled with the project, so `gradlew` command should work)

### Installation

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/PeepLog.git
    cd PeepLog
    ```
2.  **Configure Application Properties**:
    The application uses `src/main/resources/application.properties` for configuration.
    You can adjust settings like the server port and database connection details here.

    ```properties
    # Example properties
    app.name=PeepLogApplication
    server.port=8081

    # Application Info
    app.version=1.0.0
    app.description=A simple friend management application.

    # Server Settings
    server.max-connections=100

    # H2 Database (Development)
    spring.h2.console.enabled=true
    spring.datasource.url=jdbc:h2:mem:peepdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

    # MySQL Database (Production - Uncomment and configure as needed)
    # spring.datasource.url=jdbc:mysql://localhost:3306/peepdb
    # spring.datasource.username=your_mysql_user
    # spring.datasource.password=your_mysql_password
    # spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    # spring.jpa.hibernate.ddl-auto=update
    ```

### Running the Application

Navigate to the project root directory and execute the following Gradle command:

```bash
./gradlew bootRun
```

The application will start on the port configured in `application.properties` (default: `8081`).

## 🤝 Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
