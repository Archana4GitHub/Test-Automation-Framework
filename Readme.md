
# Test Automation Framework
This is a Java-based Selenium Test Automation Framework.

The framework supports:

- Local browser execution
- Headless execution
- LambdaTest cloud execution
- Data-driven testing using multiple data sources
- Dynamic test data generation
- Detailed HTML reports
- Logging
- Easy execution using Maven command line parameters
## 🚀 About Me
Hi, My Name is Archana and I have 5+ years of experience in Automation Testing using technologies like Selenium Webdriver, Java, RestAssured, Python, Playwright.

My major expertise is in Java, Python, API Testing and SQL.

## Author

- [@Archana4GitHub](https://github.com/Archana4GitHub)
- EmailAddress: jparchana22@gmail.com




## Tech Stack

**Programming Language:** Java 11

**Server:** Node, Express


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Archana4GitHub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/archana-b0b230118)



## Prerequisites

Before executing the project, ensure the following software is installed:

- **Java JDK 11**
- **Maven**
- **Git**
- **IDE** (Eclipse or IntelliJ)
- **Browser** (Chrome, Edge, Firefox)

**Download Link**: https://maven.apache.org/download.cgi

## Features:

- **Page Object Model (POM)** based framework design
- **Data-driven testing** using Excel, CSV, and JSON
- **Dynamic test data generation** using Java Faker
- **TestNG** based test execution
- **Cross-browser** testing support
- **LambdaTest** cloud execution integration
- **Headless browser** execution support
- **Maven command-line execution** with runtime parameters
- **Extent HTML reporting**
- **Log4j2** logging integration
- **Screenshot** capture on failures
- **CI/CD** ready framework structure

# Technology Stack

| **Technology** | **Version** |
|------------|---------|
| Java | 11 |
| Maven | Latest |
| Selenium WebDriver | 4.x |
| TestNG | 7.x |
| Apache POI | Excel Data |
| OpenCSV | CSV Data |
| Gson | JSON Data |
| Java Faker | Dynamic Test Data |
| Log4j2 | Logging |
| Extent Reports | HTML Reporting |
| LambdaTest | Cloud Execution |
## Setup Instructions

-  **Clone the Repository**:
---bash
    git clone <https://github.com/Archana4GitHub/Test-Automation-Framework.git>

   cd Test-Automation-Framework


-  **Running Tests on LambdaTest**:
---bash
    mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

     **Running Tests on  Chrome Browser Local Machine in Headless Mode**:
---bash
    mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X

    ## Reports and Logs

- **Extent Reports**
  - Generates detailed HTML execution reports after test execution at
    **./report.html.**

- The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed test.
   

- **Logs**
  - Generates framework execution logs for debugging and analysis at **./logs/**
    
## Integrated the project Github Actions 
This automation framework is integrated with github actions. The tests will be executed at 11:30 PM JST every single day.

The report will be archived in gh-pages branch 
You can view the html reports https://archana4github.github.io/Test-Automation-Framework/  
