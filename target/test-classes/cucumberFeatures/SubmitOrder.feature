
@tag
Feature: Proceeding till payment page after adding a product in PUMA website 
  
  
  Background:
  Given Landed on the PUMA website initial login page

  @Regression
  Scenario Outline: positive scenario of adding a product and successfully proceeding till payment page
    Given Logged in with email <email> and password <password>
    When Landing on product listing page and adding a product <productname> to the cart
    And Check if the product <productname> is successfully added to the cart and proceeding to Shipping page
    And Providing details in the Shipping page and proceeding to Payment page
    Then Validating that you land successfully on Payment page and select payment option

    Examples: 
      | email                  | password                 | productname             | 
      | pumatest130@gmail.com  | Seleniumautomation42@    | Smashic Unisex Sneakers | 
      
