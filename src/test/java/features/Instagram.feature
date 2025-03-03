Feature: Bot Instagram

  Scenario: Auto komen via single link
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    And user click not now button notification
    Then verify user is on home page
    When user go to target link
    And user click button komen
    Then type komen "nice"
    And type emoji
    And user click post button

  Scenario: Auto like & komen get link from file
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    Then verify user is on home page
    When get link from file


  Scenario: Auto like & komen get link from two file
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    Then verify user is on home page
    When get link from file
    When get link from second file


  Scenario: Auto like only from file
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    Then verify user is on home page
    When get link from like file


  Scenario: Auto komen only from file
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    Then verify user is on home page
    When get link from komen file

  Scenario: Auto dm only from file
    Given user is on login page
    When user input log in username "yourUsername"
    And user input log in password "yourPass"
    And user click sign in button
    And user click not now button
    Then verify user is on home page
    When get link from dm file