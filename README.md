# Banking Balance File Processing

Process flat files (doc, docx, csv) containing banking records like client name, payment card type, transaction amount, transaction date, real balance, and fictitious balance using batch processing.

## Description

This project processes banking records using Spring Batch to store the resulting data in an object-based database. The input data includes client information, payment card types, transaction details, and balances (real and fictitious). The batch program is based on a single job comprising multiple independent steps, each consisting of:

- **Reader**: Reads lines from the flat file.
- **Processor**: Performs ORM mapping.
- **Writer**: Saves records to the target relational database.

## Topics

- java
- spring-boot
- eclipse-ide
- h2-in-memory-database
- maven
- restful-api
- spring-batch
- spring-mvc

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/haddouguihamza/Banking-BalanceFileProcessing.git
    cd Banking-BalanceFileProcessing
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Usage

1. To run the batch process, execute the following command:
    ```bash
    mvn spring-boot:run
    ```

2. Place your input files in the specified directory (update the configuration if necessary).

3. Check the output directory for the processed files.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
