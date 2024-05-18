
@tag
Feature: 2nd Negative Scenario
  
Background:
  Given Landed on the PUMA website initial login page
  

  @tag2
  Scenario Outline: Verifying error message is displayed when shoe size is not selected
    Given Logged in with email <email> and password <password>
    When Landing on product listing page and adding a product <productname> to the cart without selecting shoe size
    Then "Please select a size" error message is displayed

    Examples: 
      | email                  | password              | productname             |
      | pumatest130@gmail.com  | Seleniumautomation42@ | Smashic Unisex Sneakers |
