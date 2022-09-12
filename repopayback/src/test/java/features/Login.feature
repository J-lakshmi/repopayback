Feature: User Login

User using the application should be able to login and use the software

Scenario: Login with valid crdential
Given User can click on login option in the home page
When User give valid credential to the phone number and pin field
And User clicks on captcha and login button
Then varify user successfully login


Scenario: Login with invalid crdential
Given  User can click on login option in the home page
When User give invalid credential to the phone number and pin field
And  User clicks on captcha and login button
Then varify userlogin is unsuccessfull 


Scenario: ForgotPin giving valid phonenumber
Given User can click on login option in the home page
When User give invalid credential to the phone number and pin field
And User click on ForgotPin button
Then varify user get an OTP through mobilenumber

Scenario: ForgotPin without giving anything
Given User can click on login option in the home page
And User click on ForgotPin button
Then varify user get a warning message

