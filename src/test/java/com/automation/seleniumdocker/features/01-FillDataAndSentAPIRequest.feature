Feature: Submit Data to Form and Check API get method.

  Background:
    Given I am on app form page

    @apiNui
  Scenario Outline: As a user I should be able to login to application with valid api request.
    When I submitted data into the form as "<name>" , "<email>" , "<password>" , "<gender>" , "<dob>"
    And I wait for 5 seconds
    And I sent an api get request to "<endpoint>" with data param "<username>" and "<password>" and I should see status code "<code>"

    Examples:
      |name|email|password|gender|dob|endpoint|username|code|
      |Eranda Kodagoda|cambrians@gmail.com|123com|Male|12071991|/get|erandakodagoda|200|