
Feature: Create a random user, using https://randomuser.me/.
         Search for this person's name and second name in Google.
         Validate the Facebook has a profile for this person.

    @Avengers
    Scenario: Create a user and search his name on Google.
              Validate that Facebook has a profile for this user name.
        Given New user with parameters: 'gender,name,location,email,nat', 'pretty' was created
        Then Verify that created user has First name, Last name, location, email, nationality
        Then Go to site: 'https://www.google.com/'
        And Search for user`s full name
        Then Go to 'Facebook.com' from the results page
        And As an unregistered user verify that 'Facebook.com' has a profile for the current user name
