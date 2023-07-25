
  Feature: sample feature to demo soft assertions
    @soft
    Scenario: Sample scenarios for soft assertions
      Given user is on Docuport login page
      When user enters credentials
        |username|b1g2_client@gmail.com|
        |password|Group2               |
      And user validates choose accdount pop up is visible
      And user chooses acount from drop down