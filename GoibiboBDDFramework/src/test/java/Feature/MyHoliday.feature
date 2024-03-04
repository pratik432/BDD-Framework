Feature: Book flight ticket
@Smoke
Scenario: One-Way Ticket Search
Given I go to Goibibo site
When I choose one way
And I type Mumbai and choose Mumbai,India(BOM) in the field From
And I type Delhi and choose Delhi,India(DEL) in the field To
And I choose 15/03/22 referring to Departure
And I click on Search
Then will be displayed Choose Flight
Then move to ticket summary
And close the browser

