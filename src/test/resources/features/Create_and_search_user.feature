Feature: Create a random user, using https://randomuser.me/.
  Search for this person's name and second name in Google.
  Validate the Facebook has a profile for this person.

  @Avengers
  Scenario: Create a user and search his name on Google. Validate that Facebook has a profile for this user name.
#    Given New user with parameters: 'name', 'pretty' was created
#    Then Verify that created user has first name and last name
#    And Save user`s full name
    Then Go to page: 'https://www.google.com/'
    And Search for user`s full name
#    Then Go to 'Facebook.com' from the results page
#    And As an unregistered user verify that current 'Facebook.com' page contains user`s full name