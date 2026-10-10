# SampleCucumber

This project is a Selenium + Cucumber + JUnit automation framework for validating the login functionality of the SauceDemo application.

## Table of Contents
- [Overview](#overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Features Covered](#features-covered)
- [Prerequisites](#prerequisites)
- [How to Run the Tests](#how-to-run-the-tests)
- [Reports](#reports)
- [Test Data](#test-data)
- [Notes](#notes)

## Overview
SampleCucumber is a Maven-based test automation project that uses Cucumber BDD style for writing test scenarios and Selenium WebDriver for browser interaction. The framework is designed to validate various login scenarios, including successful and failed authentication attempts.

## Technology Stack
- Java 11
- Maven
- Selenium WebDriver
- Cucumber 7
- JUnit 5
- Extent Reports
- WebDriverManager
- Apache POI

## Project Structure
```text
SampleCucumber/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── Login/
│   │   │       ├── CucumberLogin.java
│   │   │       ├── DriverFactory.java
│   │   │       ├── ExtentReportListener.java
│   │   │       ├── Hooks.java
│   │   │       ├── LoginData.java
│   │   │       ├── LoginPage.java
│   │   │       └── Runner.java
│   │   ├── resources/
│   │   │   ├── Features/
│   │   │   │   └── login.feature
│   │   │   └── extent.properties
├── pom.xml
├── .classpath
├── .project
├── .gitignore
├── .gitattributes
└── README.md
```

## Features Covered
The project validates the following login scenarios:
- Valid login with standard user
- Valid login with performance glitch user
- Locked out user should fail login
- Invalid password should fail login

These scenarios are written in the feature file under:
- `src/test/resources/Features/login.feature`

## Prerequisites
Before running the tests, make sure you have the following installed:
- Java 11 or above
- Maven
- Chrome or compatible browser
- Internet access to open the SauceDemo site

## How to Run the Tests
Clone the repository and run the following command from the project root:

```bash
mvn test
```

You can also run only the Cucumber suite using the JUnit runner:

```bash
mvn -Dtest=Login.Runner test
```

## Reports
The project generates execution reports for both Cucumber and ExtentReports:
- `target/cucumber-reports/cucumber.html`
- `target/cucumber-reports/cucumber.json`
- `target/extent-reports/ExtentSpark.html`

## Test Data
The default login credentials used in the framework are based on the SauceDemo demo users, including:
- `standard_user` / `secret_sauce`
- `performance_glitch_user` / `secret_sauce`
- `locked_out_user` / `secret_sauce`

## Notes
- The framework uses the Cucumber scenario hooks to initialize the WebDriver and clean up after each test.
- Reports are generated automatically after the test execution.
- The design follows a Page Object Model approach for maintainability and reusability.

---

This README provides a quick overview of the project and the steps required to execute the automation suite successfully.
