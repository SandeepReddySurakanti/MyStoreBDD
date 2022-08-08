Feature: Login Page 

Background: Open Loginpage
Given user opens browser
When user enters url as "http://automationpractice.com/index.php"
Then user clicks signIn link


Scenario: Login page title
Given User gets title of page
Then Page title should be "Login - My Store"

Scenario: Forgot password Link
Given forgot password should be present

Scenario: Login with credentials
Given enter login detials
And user clicks login button
And user lands on home page and gets title of page
And title of the page should be "My account - My Store"
