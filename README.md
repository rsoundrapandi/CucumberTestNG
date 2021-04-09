# BDD Automation Interview Assignment ![Java CI with Maven](https://github.com/pos-my/java-bdd-interview/workflows/Java%20CI%20with%20Maven/badge.svg)
BDD automated application that will be used by our candidates.

## Pre-requisite
  - Java 11 or later
  - Editor of your choice. E.g. IDEA, Eclipse, Netbeans, VS Code, Notepad, etc.
  
## Dependencies
The following dependencies are included inside [pom.xml][2]:
  - Cucumber JVM
  - JUnit Jupiter
  - Selenium WebDriver
  - WebDriverManager

### Modify dependencies
Candidates are allowed to add or remove any dependencies _except_ Cucumber JVM and Selenium WebDriver.
  
## Requirement
  - Candidates should implement required scenario(s) with Cucumber and Selenium
  - Implementation should:
    - demonstrate understanding of Cucumber and Selenium best practices
    - demonstrate understanding of Object Oriented Programming concepts
  
### Required scenario(s)
  - [ ] Search "covid 19 in Malaysia" on Google and will see search results page
  - [ ] Top stories section is available
  - [ ] Common questions section is available
  - [ ] Click on MOH website in the search result will lead to MOH's website

## Nice to Have
  - Demonstrate understanding of [SOLID Principle][1]
  - Demonstrate understanding of Design Patterns
  
## Submission
Candidates can submit their work via:
  - [Pull Request][3] (preferred)
  - Cloud storage of their choice
  - E-mail
  
[1]: https://en.wikipedia.org/wiki/SOLID
[2]: ./pom.xml#L24
[3]: https://github.com/pos-my/java-bdd-interview/pulls
