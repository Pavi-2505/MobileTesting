Feature: Verify Wizz Air Login Page

  Scenario Outline: Verify Login With Valid Credentials
    Given User is on Wizz Air Login Screen
    When User enters username "<username>" and password "<password>" and click on singin Button
    Then User Verify Home Page is Displayed

    Examples: 
      | username       | password |
      | bala@gmail.com | bala@123 |
