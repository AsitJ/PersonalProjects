Hi,
The above project is a complete framework from scratch consisting of Java, TestNG & Cucumber framework tests dedicated to automating "PUMA" website to add a sneaker product 
to the cart on product list page and proceed till payment page and select a payment option. I could only automate till payments page since need to provide valid information 
for the payment to go through and the order to be successfully submitted. First I developed a simple and straightforward code just testing the functionality from first page
till payments page in "RoughImplementation.java" class which can be executed using Java. Then I used the Page Object model and created different classes for each page and 
the main code sitting in "E2EPaymentPage.java" class which drives all the classes present in "pageObject" package and can be executed using TestNG framework. Then I 
implemented Cucumber BDD framework on the above tests and have created 3 feature files out of which 1 feature file represents a positive scenario navigating from first page
till Payments page. The remaining 2 feature files are error scenarios in different pages. "TestNGRunner" file is used to execute the cucumber feature files. 
