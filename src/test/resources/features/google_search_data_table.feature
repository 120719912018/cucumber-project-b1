

 Feature: Passing multiple parameters to the same step
@kh
   Scenario: Searching multiple items
     Given user is on Google search page
     Then user search the following item
      |loop academy|
      |  java      |
      | selenium   |
      |cucumber bdd|
      |sql         |
     #  option + command + L - mac
     #    CTRL + ALT + L window
