Feature: Sign up and create Issue

  Scenario: Test case 1 - Sign up an web app account
    Given User open web app https://webapp.test.bitmark.com/
    Then User verify Sign In page is displayed
    And User verify Continue button is disabled
    When User enter email bittractor@gmail.com
    And User verify Continue button is enabled
    When User click Continue button
    Then User verify email is submit successful
    When User click on the received sign-in magic link
    Then User is signed in Bitmark Web app

  Scenario: Test case 2 - Issue new asset
    Given User sign in to the Bitmark Web app
    When User click Add Issue Bitmark button
    Then User verify Upload Asset page opens
    When User select a file which has never been selected to issue before
    Then User verify Asset page opens
    When User enter the required information
    And User click Issue button
    Then User verify the text Submitting your request to the network for confirmation... is displayed
    And User verify Issue button is disabled
    And User verify Your Properties page appears after few seconds
    And User verify the new issued bitmarks are added on top of the Properties list
    Then User verify the bitmarks are confirmed after few minutes (3 minutes)
