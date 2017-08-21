# Lieferando Automation Assessment

**Scenario**
1. Search with address string and address code, should show list of restaurant options
2. Search with invalid strings (blank or junk data), should not show any options
 
Search functionality based on address or post code, the whole automation drafted in cucumber-jvm using Page Object Model.

**Features covered**
1. Simplified user journey in plan english (cucumber-gherkins) which helps gives insights to business team about automation
2. Covered different types of browsers firefox/chrome
3. Custom asserts which provide capabilities to capture screen shots on failure
4. Detailed execution logs (log4j2)
5. State of driver object has been maintained at context level, hence its status has been shared across step definitions

**Can be extended to**
1. Implemented to gradle, nice support for parallel execution for cucumber-jvm
    https://github.com/camiloribeiro/cucumber-gradle-parallel
2. To be leverage to CI(using JenkinsPipeline)

**Pre-requisite**
1. Download chrome driver
    https://chromedriver.storage.googleapis.com/index.html?path=2.31/
2. Download gecko driver
    https://github.com/mozilla/geckodriver/releases
3. Provide paths to Lieferando.properties
    `firefox.driver.path=<path/to/geckodriver>
     chrome.driver.path=<path/to/chromedriver>
    `
    
**Run**

`mvn clean test -Dbrowser.type=firefox`

**Reports**
HTML cucumber report will be created at `target/cucumber-html-reports/cucumber-html-reports/overview-features.html`
