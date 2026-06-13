Feature: Instagram Automation

  Scenario: Scrape and execute automation
    Given user start the bot
    And user login to Instagram
    When user scrape targets by hashtag with min 20 likes and 0 comments
    Then user selects action mode
    And execute selected action
    Then finish bot task