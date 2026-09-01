# Swag Labs Playwright Automation

A UI test automation project built with **Java, Playwright, JUnit 5 and Maven**, using the Swag Labs e-commerce application for practice.

The purpose of this project is to develop practical experience in modern test automation, including the Page Object Model, reusable test setup, assertions, test data management and automated end-to-end testing.

## 🛠️ Technologies

* **Java**
* **Playwright**
* **JUnit 5**
* **Maven**
* **Git / GitHub**
* **GitHub Actions** *(planned)*

## 📁 Project Structure

```text
swag-labs-playwright/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── LoginPage.java
│   │           └── ProductsPage.java
│   │
│   └── test/
│       └── java/
│           ├── data/
│           │   └── TestData.java
│           │
│           └── tests/
│               ├── BaseTest.java
│               ├── LoginTests.java
│               └── ProductTests.java
│
├── pom.xml
└── README.md
```

## 🧪 Current Test Coverage

### Login

* Successful login with valid credentials
* Login with an invalid username
* Login with an invalid password
* Login without credentials
* Verification of login error messages

### Products

* Verify the Products page is displayed
* Verify products are displayed
* Add a product to the shopping cart
* Product sorting *(in progress)*

## 🏗️ Framework Design

The project uses the **Page Object Model (POM)** to separate test logic from page interactions.

```text
Tests
  │
  ├── LoginTests
  └── ProductTests
          │
          ↓
     Page Objects
          │
     ┌────┴────┐
     ↓         ↓
 LoginPage  ProductsPage
```

Page Objects contain the locators and actions required to interact with each page, while the test classes contain the scenarios and assertions.

## 🔧 Base Test

`BaseTest` provides common Playwright setup and teardown for all test classes.

It is responsible for:

1. Creating the Playwright instance
2. Launching Chromium
3. Creating a browser page
4. Creating the required Page Objects
5. Closing the browser after each test

Test classes extend `BaseTest`:

```java
public class LoginTests extends BaseTest {
    
}
```

This prevents browser setup code from being duplicated across test classes.

## 📊 Test Data

Test data is stored separately in `TestData.java`.

Example:

```java
public static final String VALID_USERNAME = "standard_user";
public static final String VALID_PASSWORD = "secret_sauce";
```

This keeps credentials and other reusable test data out of individual test cases.

## 🚀 Getting Started

### Prerequisites

Make sure you have installed:

* Java
* Maven
* IntelliJ IDEA or another Java IDE
* Git

### Clone the repository

```bash
git clone <repository-url>
```

Navigate into the project:

```bash
cd swag-labs-playwright
```

### Install dependencies

```bash
mvn clean install
```

### Install Playwright browsers

```bash
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
```

### Run the tests

```bash
mvn test
```

The tests currently run using Chromium in headed mode, allowing the browser interactions to be observed while the tests execute.

## 🎯 Project Goals

The project will be expanded to cover a complete e-commerce workflow:

```text
Login
  ↓
Products
  ↓
Add products to cart
  ↓
Shopping cart
  ↓
Checkout
  ↓
Order confirmation
```

Planned improvements include:

* [ ] Complete product test coverage
* [ ] Create `CartPage`
* [ ] Create `CheckoutPage`
* [ ] Add checkout tests
* [ ] Add more negative test scenarios
* [ ] Improve locator strategy
* [ ] Add parameterised tests
* [ ] Add screenshots on failure
* [ ] Add Playwright traces
* [ ] Add HTML test reporting
* [ ] Add GitHub Actions CI/CD
* [ ] Run tests in headless mode in CI
* [ ] Improve framework configuration

## 📚 What I'm Practising

This project is being used to develop practical skills in:

* UI test automation
* Playwright
* Java
* JUnit
* Page Object Model
* Locator strategies
* Assertions
* Test data management
* Positive and negative testing
* End-to-end testing
* Maven
* Git
* CI/CD

## 🌐 Application Under Test

**Swag Labs**

https://www.saucedemo.com/

Swag Labs is a demo e-commerce application used for practising automated software testing.

## 👤 Author

**Kacper Felczak**

Java Test Automation Engineer

This project is part of my continued development in software testing and test automation.
