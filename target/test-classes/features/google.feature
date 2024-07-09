Feature: google page


  @Google @Edge @Firefox
  Scenario: Google title check
  Given the user open the google browser
    Then the user verify the title of google page

  @Google @Edge @Firefox
  Scenario: Google logo check
    Given the user open the google browser
    Then the user verify the google logo