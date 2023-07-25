

  Feature: Create new client as an advisor
    @dp
    Scenario:
      Given User login as an advisor
      When   User create a new client
      Then  Validate that new client created
      Then  Log out as an advisor
      Then  Log as a new client

