
Feature: Create a random user, using https://randomuser.me/.
         Search for this person's name and second name in Google.
         Validate the Facebook has a profile for this person.

    @Avengers
    Scenario: Basic test for testing jUnit runner
#        Then  Transmit string 'avengers'
        Given Create new user with parameters: 'gender,name,location,email,nat', 'pretty'
