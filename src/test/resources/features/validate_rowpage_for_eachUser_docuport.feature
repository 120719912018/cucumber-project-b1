@eachUser
Feature:  Validate row number for a each user in docuport
  Background:
    Given  User login  home page on Docuport
  Scenario Outline: Validate row number for a as each user in docuport
      Given  User login  home page each  "<username>" and "<password>"
      When User click "Leads" button for "<username>"
      Then Validate that Rows Per Page shows by default 10 for "<username>"
      And Change Rows Per Page to 5 for "<username>"
      When User click "Users" button for "<username>"
     Then Validate that Rows Per Page shows by default 10 for "<username>"
     And Change Rows Per Page to 5 for "<username>"
     Then Validate that after changing it is showing 5 for "<username>"

      Examples:
        | username                  | password |
        | b1g2_advisor@gmail.com    | Group2   |
        | b1g2_supervisor@gmail.com | Group2   |
        | b1g2_employee@gmail.com   | Group2   |
