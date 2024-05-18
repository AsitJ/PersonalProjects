
@tag
Feature: Negative scenario
  

 

  @ErrorValidation
  Scenario Outline: Incorrect Email or password
    Given Landed on the PUMA website initial login page
    When Logged in with email <email> and password <password>
    Then "Invalid login or password. Remember that login names and passwords are case-sensitive. Please try again." displays in login page

    Examples: 
      | email           | password            | 
      | test@gmail.com  | Learningselenium90@ |
     
