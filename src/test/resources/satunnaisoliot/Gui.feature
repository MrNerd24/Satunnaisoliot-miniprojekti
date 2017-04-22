Feature: As user can use the GUI
#
#Scenario: user can open main window
#Given Program is not running
#When User launches the program
#Then Main window opens

Scenario: user can add new article
Given Program is running
When User opens reference selection window
And User selects new article
And User inputs test values to new article
Then Values are added