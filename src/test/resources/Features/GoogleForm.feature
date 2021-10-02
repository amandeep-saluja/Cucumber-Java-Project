Feature: Google Form Feature

  Scenario Outline: Validate Google Form Working
    Given user is navigating to <URL> google form page
    When user is viewing google form
    And user fills <name>, <dob>, <address>, <gender>, <phone> and <comments> details
    Then user clicks on submit button
    And response save successfully

    Examples: 
      | URL                                 | address | name         | dob        | gender | phone     | comments              |
      | https://forms.gle/cprt7zakWnch7vq27 | Delhi   | Akshay Singh | 25-11-1976 | Male   | 956543210 | Testing another field |
