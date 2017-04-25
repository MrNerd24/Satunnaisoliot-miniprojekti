Feature: As user can use the GUI

  Scenario: user can add new article
    Given Program is running
    When User opens reference selection window
    And User selects new article
    And User inputs values: "ErkkiKalle", "Erkki", "1", "1", "1", "1" to a new article
    Then Values are added

  Scenario: user can clear values from article
    Given Program is running
    When User opens reference selection window
    And User selects new article
    And User inputs values: "ErkkiKalle", "Erkki", "1", "1", "1", "1" to a new article
    And User hits clear button on article form
    Then Values are cleared

  Scenario: user can add new book
    Given Program is running
    When User opens reference selection window
    And User selects new book
    And User inputs values: "ErkkiKalle", "Erkki", "1", "1", "1", "1" to a new book
    Then Values are added

  Scenario: user can clear values from book
    Given Program is running
    When User opens reference selection window
    And User selects new book
    And User inputs values: "ErkkiKalle", "Erkki", "1", "1", "1", "1" to a new book
    And User hits clear button on book form
    Then Values are cleared

  Scenario: user can add new proceeding
    Given Program is running
    When User opens reference selection window
    And User selects new proceeding
    And User inputs values: "ErkkiKalle", "Erkki", "1" to a new proceeding
    Then Values are added

  Scenario: user can clear values from proceeding
    Given Program is running
    When User opens reference selection window
    And User selects new proceeding
    And User inputs values: "ErkkiKalle", "Erkki", "1" to a new proceeding
    And User hits clear button on proceedings form
    Then Values are cleared
