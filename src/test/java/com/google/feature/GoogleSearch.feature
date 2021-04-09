Feature: Validate Search feature
	Description: Purpose of this feature it to validate the google search results

Background: Search a Keyword in Google Homepage
	Given Navigate to Google Website
	|https://www.google.com/|
	And  Enter Search Keyword
	|covid 19 in Malaysia|
	When Click the GoogleSearch button
	Then Search results Should be displayed
	
@Regression
Scenario: Top stories section is available
	When Validate the Top Stories section is available
	Then Top Stories section should be available
	|Top stories|
@SMoke1
Scenario: Common questions section is available
	When Validate the Common questions is available
	|Testing|
	Then Common questiuons section should be available
	
@Smoke	
Scenario: Navigate to MOH Website
	When Click the link
	Then MOH Website should be launched
	