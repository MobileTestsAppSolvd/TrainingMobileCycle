<!-- PROJECT LOGO -->
<div align="center">
  <h1 align="center">Training Cycle</h1>
  <p align="center">Mobile App Testing Project</p>
</div>

<!-- TABLE OF CONTENTS -->
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#workflow">Workflow</a></li>
    <li><a href="#useful documentation">Useful Documentation</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

The project focuses on testing the MercadoLibre mobile app using core testing tools such as Java, the Carina framework, and Appium. The testing process is integrated with Jenkins and using TestRail to provide a comprehensive testing experience. The goal of the project is to improve testing skills and gain experience in mobile app testing.

### Built With

* Programming Language: Java
* CI Tools: Jenkins
* Frameworks: Carina by Zebrunner, Appium
* Test Management Tools: TestRail

<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

- [ ] Install Java +11
- [ ] Install Appium Server
- [ ] Install Appium Inspector
- [ ] Install AndroidStudio
- [ ] Install Jenkins

### Installation
- [ ] Install mercadolibre apk in the device.
- [ ] Clone the repo.
- [ ] Add a _testdata.properties file with TestRail's credentials data (testRailUrl, testRailUsername, testRailPassword).

<!-- USAGE EXAMPLES -->
## Usage

- [ ] Run tests from testng.xml files to create automatically a test run in TestRail.

<!-- WORKFLOW -->
## Workflow

1. Check tickets assigned to you defined in the Project Management Tool (e.g. Trello)
2. Check TestRail's test case: preconditions, steps, expected results
3. Create your Feature Branch following naming convention [TCXX]-testName
4. Add components and pages as needed, using Page Object Model Design Pattern
5. Commit your changes, push them to your branch and create a pull request assigning a reviewer 
6. Merge changes to master branch

<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [Carina Framework](https://zebrunner.github.io/carina/)
* [TestRail](https://support.gurock.com/hc/en-us)
* [Mercadolibre apk](https://mercadolibre.uptodown.com/android)
* [TestNG](https://testng.org/doc/documentation-main.html)
* [Appium](https://appium.io/docs/en/writing-running-appium/caps/)
