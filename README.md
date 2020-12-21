## Demo Challenge

Test automation solution is written on macos system and checked only for this OS
To run test automation suite execute `mvn clean test -DsuiteXmlFile=/src/test/resources/testng.xml`
To show allure report for the run execute `mvn allure:serve` 

#### Instructions
1. Complete the project setup as listed below
2. Complete the Excerise
3. Email a synopsis of your work and the link to your git repo containing the completed exercise to: sqedemonstrationchallenge@nbcuni.com

#### Technologies
1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Project Setup
1. Clone this project to your git account in a public repo
2. Setup the project in your IDE
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches.  You may need to update the chromedriver in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/

#### Expectations
We will be evaluating
1. Quality of test cases
2. Variety  of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity

#### Exercise
1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Test Cases section below:
  - List all of the test cases you think are necessary to test the sample page
  - Note any defects or issues observed
4. Code up a few examples of:
  - At least one happy path case placing an order
  - At least one error case
5. When complete please check your code into your public git repo

#### Test Cases

 1. Check correct cost calculation test;
 2. Check validation for mandatory fields to proceed the order test('Name' and 'Phone' fields).
 3. Check behavior of Payment Information pickers test.
 4. Check placing the order functionality test.
 5. Check quantity and cost fields validation test.
 6. Check reset order form functionality test.
 
 #### Issues
 
 1. 'Credit Card' and 'Cash on Pickup' options can be picked both in the same time.
 2. Need to verify expected behavior. No validation for input value for 'Phone' field, can be set characters.
 3. Need to verify expected behavior. No validation for input value for 'Email' field, type='TEXT'.
 4. 'Toppings 1' and 'Toppings2' fields does not return to the initial field after click on 'Reset' button.
 5. Typo in 'Toppings2' name of field, should be 'Toppings 2' similarly to 'Toppings 1' field.
 6. No validation for 'Quantity' field. Field can be filled with negative values, letters, special characters.
 7. Quantity field does not fit entered value with length more than 3 numbers. The value is clipped by field borders.
 8. Need to verify expected behavior. It's possible to select both toppings if selected pizza type without toppings or with only one topping.
