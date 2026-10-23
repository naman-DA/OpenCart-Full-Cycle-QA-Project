# OpenCart Full-Cycle QA Project

A software testing project focused on quality assurance for the OpenCart e-commerce application. The repository organizes testing activities across API testing, UI automation, database testing, manual testing, and test planning.

## Project Overview

The objective of this project is to validate key aspects of an e-commerce application through structured testing activities, identify defects, and improve application reliability.

## Project Structure

```text
OpenCart-Full-Cycle-QA-Project/
├── API-Testing/
├── Automation-Testing/
├── Database-Testing/
├── Manual-Testing/
├── Test-Planning/
├── .gitignore
└── README.md
```

### Testing Areas

- **API Testing:** API-level validation and verification.
- **Automation Testing:** Automated browser tests using Java, Selenium WebDriver, TestNG, and Maven.
- **Database Testing:** Database validation and testing activities.
- **Manual Testing:** Manual test scenarios and test cases.
- **Test Planning:** Test planning and supporting QA documentation.

Refer to the individual folders for the relevant scripts, test cases, and documentation.

## Technology Stack

The confirmed automation stack includes:

- Java
- Selenium WebDriver
- TestNG
- Apache Maven
- Google Chrome
- OpenCart local test environment

Other tools and technologies may be documented in their respective testing folders.

## Automation Testing Setup

### Prerequisites

Install the following:

- JDK compatible with the project's Maven compiler configuration
- Apache Maven
- Google Chrome
- A locally running OpenCart application

### Configure the Application

Update the application URL and test-account configuration in the automation project as required.

Do not commit real passwords, API keys, access tokens, or other sensitive credentials.

If the automation tests use environment variables for login credentials, configure them in your terminal before running the tests.

### Run Automated Tests

Open a terminal in the `Automation-Testing` directory and execute:

```bash
mvn clean test
```

Maven will clean previous build output, compile the project, and execute tests configured through the project's TestNG and Surefire setup.

### Test Reports

After execution, inspect the Maven Surefire reports under:

```text
Automation-Testing/target/surefire-reports/
```

The `target/` directory contains generated build artifacts and should not be committed to Git.

## Running the Application

The automation tests require a working OpenCart instance and valid test data. Configure the local application URL and test accounts according to the project's configuration before running the suite.

## Repository Guidelines

- Keep test scripts, test data, and documentation organized in their respective folders.
- Never commit credentials, private keys, API tokens, or local secret files.
- Exclude generated build output and IDE-specific files.
- Update the documentation when new testing scenarios or tools are added.

## Project Status

This repository brings together the testing activities organized under the five project areas listed above. Refer to the individual folders for implementation details and available test coverage.
