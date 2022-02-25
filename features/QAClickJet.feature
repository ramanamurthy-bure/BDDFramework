@tag
Feature: QAClickJet Flight Booking

  @dropDownTests
  Scenario: To launch QAClickJet site and work with dropdowns
    Given user navigates to QAClick site "https://rahulshettyacademy.com/dropdownsPractise/"
    When user enters booking details
    Then capture screenshot
    And close browser
