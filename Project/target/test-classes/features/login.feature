Feature: OrangeHRM Test

Scenario: Login and search employee

Given user launches browser
When user opens application
And user enters username and password
And user clicks login
Then user navigates to PIM and searches employee
And user navigates to Directory and searches employee
Then user logs out