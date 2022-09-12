Feature: New User SignUp

New user can SignUp the PayBack Application and create a profile

Scenario: SignUp with valid credential
Given NewUser navigate to SignUp Page
When NewUser  select salutation and enter valid credential to the FirstName, LastName, MobileNumber,EmailID,DOB fields
And clicks on privacy policy and generate OTP
Then varify user get an OTP and successfully SignUP

Scenario: SignUp with invalid credential
Given NewUser is able to navigate to SignUp Page
When NewUser  select salutation and enter invalidvalid credential to the FirstName, LastName, MobileNumber,EmailID,DOB fields
And NewUser clicks on privacy policy and generate OTP
Then varify user is not able to successfully SignUP and get a warning message

