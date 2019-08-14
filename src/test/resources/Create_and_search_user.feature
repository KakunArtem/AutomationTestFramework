
Feature: Create a random user, using https://randomuser.me/.
         Search for this person's name and second name in Google.
         Validate the Facebook has a profile for this person.

    @Avengers
    Scenario: Create a user and search him on Google.
              Validate that the user has a Facebook page.
        Given Create new user with parameters: 'gender,name,location,email,nat', 'pretty'
        Then Verify that created user has First name, Last name, location, email, nationality
