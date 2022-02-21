$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("QAClickJet.feature");
formatter.feature({
  "line": 2,
  "name": "QAClickJet Tests",
  "description": "",
  "id": "qaclickjet-tests",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Testing Components of DemoQA page",
  "description": "",
  "id": "qaclickjet-tests;testing-components-of-demoqa-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigates to \"https://rahulshettyacademy.com/dropdownsPractise/\" site",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enters booking details",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "capture screenshot",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://rahulshettyacademy.com/dropdownsPractise/",
      "offset": 19
    }
  ],
  "location": "HomePageSteps.user_navigates_to_site(String)"
});
formatter.result({
  "duration": 8136141364,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_enters_booking_details()"
});
formatter.result({
  "duration": 5056550372,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.capture_screenshot()"
});
formatter.result({
  "duration": 1495811191,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.close_browser()"
});
formatter.result({
  "duration": 205134296,
  "status": "passed"
});
});