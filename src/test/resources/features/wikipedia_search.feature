

Feature:
  @kh
  Scenario Outline:  Wikipedia Search Functionality Title Verification
      Given  User is on Wikipedia home page
      When User types "<name>" in the wiki search box
      And User clicks wiki search button
      Then User sees "<name>" is in the "<titleVerification>"

    Examples:
       |name       | titleVerification  |
       |Steve Jobs | wiki title|
       |Steve Jobs |main header |
       |Steve Jobs |image header |