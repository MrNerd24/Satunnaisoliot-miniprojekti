Feature: As user, can export the database to a file.

Scenario: user export to "test" file
Given Program is running
When User opens export window
And User inputs value: "FEST_Export_test_file" to export file path
