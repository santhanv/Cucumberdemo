#Author: santhan@your.domain.com

Feature: validation for add customer flow

  Scenario: add customer validation
    Given user launches telecom application
		And user click on add customer button
		When user need to fill up the fields
		And user click on submit button
		Then user verify customer id is generated
