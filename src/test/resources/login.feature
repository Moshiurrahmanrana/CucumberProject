Feature: Login to an e-commerce website

  Scenario Outline: Verify users can login to portal with valid credentials
    Given User visits e-commerce website
    When User enters valid "<username>" and "<password>"
    Then User can logged in successfully

    Examples:
      | username           | password |
      | moshiur.rahman14m@gmail.com | p@ssword123  |
      | testuser412@grr.la | 2t8zmqzL |