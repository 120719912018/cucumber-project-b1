
@adv
 Feature:  Validate row number for a advisor in docuport
    Scenario: User should login  as a advisor in docuport
      Given User is Docuport login page
      When  User enter credential as advisor
         |username| b1g2_advisor@gmail.com |
         |password| Group2                 |
      When User click "Leads" button
      Then Validate that Rows Per Page shows by default 10
      And Change Rows Per Page to 5
      When User click "Users" button
      Then Validate that Rows Per Page shows by default 10
      And Change Rows Per Page to 5
      Then Validate that after changing it is showing 5