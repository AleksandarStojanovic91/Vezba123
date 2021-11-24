Feature: Login

#  Scenario Outline: Login
#
#    Given I am on SwagLabs page
#    When I enter username "<username>"
#    And I enter password "<password>"
#    And I click login button
#    Then I should see products
#
#    Examples:
#      | username      | password     |
#      | standard_user | secret_sauce |

  Scenario Outline: Login with excel data

    Given I have entered excel data in file "<file>" and sheet "<sheet>" and row "<row>"
    And I am on SwagLabs page
    When I enter username
    And I enter password
    And I click login button
    And I take allure screenshot
    Then I should see products

    Examples:
      | file     | sheet | row |
      | TestData | Data  | 1   |
      | TestData | Data  | 2   |