

Feature: Login Page of OrangeHRM
Background: Common step for login page
    Given Launch the Chrome Browser and login Orange HRM 
    When Open the URL_Orange HRM
    
    Scenario: Login is Successfull with valid credentials
    And Enter the Username as "Admin"
    And Enter the Password as "admin123"
    And Clock on Login 
    Then Verify the PageTitle
    And Navigate to Home Page
    And Click on Logout 

  Scenario Outline: Login is Successfull with valid credentials
    And Enter the Username "<username>"
    And Enter the Password "<password>"
    And Clock on Login 
    And Close Browser

    Examples: 
      | username  | password  |  
      | Admin     | admin123  |  
      | Admin     | admin456  |   
