Feature: Searching on Google using Scenario Outline

  Scenario Outline: Search Google from Scenario Outline

    Given launch browser '<browserName>'
    When user navigates to '<url>'
    Then user enters search term '<search>'
    And clicks on search button

    Examples:
      |browserName|url              |search                 |
      |chrome     |http://google.com|Way2Automation         |
      |firefox    |http://google.com|Way2Automation Selenium|