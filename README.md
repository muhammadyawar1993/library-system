# Library System

This project is a Spring Boot-based library management system that provides APIs for managing books, borrowers, and loans.

## Table of Contents
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Using the API](#using-the-api)
  - [Books](#books)
  - [Borrowers](#borrowers)
  - [Loans](#loans)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Setup

### Prerequisites
- Java 21
- Maven
- PostgreSQL (or another relational database)

### Installation
1. Clone the repository:
   \`\`sh
   git clone https://github.com/yourusername/library-system.git
   cd library-system
   \`\`

2. Configure the database:
   - Update the \`application.properties\` file with your database settings:
     \`\`\`properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     \`\`\`

3. Build the project:
   \`\`\`sh
   mvn clean install
   \`\`\`

## Running the Application
Run the application using the following command:
\`\`\`sh
mvn spring-boot:run
\`\`\`
The application will start on the default port \`8282\`.

## API Documentation

### Accessing Swagger UI
Swagger UI provides a user-friendly interface for accessing the API documentation:
\`\`\`
http://localhost:8282/swagger-ui/index.html
\`\`\`

### Downloading API Documentation
You can download the OpenAPI documentation in JSON or YAML format:
- JSON: \`http://localhost:8282/v3/api-docs\`
- YAML: \`http://localhost:8282/v3/api-docs.yaml\`

## Using the API

### Books

#### Register a Book
- **URL:** \`/api/books\`
- **Method:** \`POST\`
- **Request Body:**
  \`\`\`json
  {
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "ISBN-123456"
  }
  \`\`\`
- **Responses:**
  - \`200 OK\`: Book registered successfully
  - \`400 Bad Request\`: Invalid input
  - \`500 Internal Server Error\`: Internal server error

#### Get All Books
- **URL:** \`/api/books\`
- **Method:** \`GET\`
- **Responses:**
  - \`200 OK\`: Books retrieved successfully
  - \`500 Internal Server Error\`: Internal server error

### Borrowers

#### Register a Borrower
- **URL:** \`/api/borrowers\`
- **Method:** \`POST\`
- **Request Body:**
  \`\`\`json
  {
    "name": "Borrower Name",
    "email": "borrower@example.com"
  }
  \`\`\`
- **Responses:**
  - \`200 OK\`: Borrower registered successfully
  - \`400 Bad Request\`: Invalid input
  - \`500 Internal Server Error\`: Internal server error

#### Get All Borrowers
- **URL:** \`/api/borrowers\`
- **Method:** \`GET\`
- **Responses:**
  - \`200 OK\`: Borrowers retrieved successfully
  - \`500 Internal Server Error\`: Internal server error

### Loans

#### Borrow a Book
- **URL:** \`/api/loans/borrow\`
- **Method:** \`POST\`
- **Parameters:**
  - \`borrowerId\` (Long): ID of the borrower
  - \`bookId\` (Long): ID of the book
- **Responses:**
  - \`200 OK\`: Book borrowed successfully
  - \`400 Bad Request\`: Invalid input
  - \`404 Not Found\`: Borrower or book not found
  - \`500 Internal Server Error\`: Internal server error

#### Return a Book
- **URL:** \`/api/loans/return\`
- **Method:** \`POST\`
- **Parameters:**
  - \`loanId\` (Long): ID of the loan
- **Responses:**
  - \`200 OK\`: Book returned successfully
  - \`400 Bad Request\`: Invalid input
  - \`404 Not Found\`: Loan not found
  - \`500 Internal Server Error\`: Internal server error

#### Get Borrowed Books by Borrower ID
- **URL:** \`/api/loans/borrowed-books/{borrowerId}\`
- **Method:** \`GET\`
- **Responses:**
  - \`200 OK\`: Books retrieved successfully
  - \`404 Not Found\`: Borrower not found
  - \`500 Internal Server Error\`: Internal server error

#### Get Returned Books by Borrower ID
- **URL:** \`/api/loans/returned-books/{borrowerId}\`
- **Method:** \`GET\`
- **Responses:**
  - \`200 OK\`: Books retrieved successfully
  - \`404 Not Found\`: Borrower not found
  - \`500 Internal Server Error\`: Internal server error

## Testing

### Running Unit Tests
To run the unit tests, use the following command:
\`\`\`sh
mvn test
\`\`\`

## Contributing
Contributions are welcome! Please open an issue or submit a pull request on GitHub.

## License
This project is licensed under the MIT License.
