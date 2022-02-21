@tag
Feature: QAClickJet Flight Booking

  @tag1
  Scenario: To launch QAClickJet site and work with dropdowns
    Given user navigates to "https://rahulshettyacademy.com/dropdownsPractise/" site
    When user enters booking details
    Then capture screenshot
    And close browser
