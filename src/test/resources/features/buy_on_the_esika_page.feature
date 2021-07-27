#language: en

#language: en

#  @device=GalaxyS20Ultra
#  @device=Iphone12pro
@device=Windows10
Feature: test product purchase

  @test_registration
  Scenario: test address registration
    Given I entered the page 'https://www.esika.com/pe' and entered 'Perfumes/Maderosa' section
    When I add the 'Magnat' product with 1 additional quanity
    And I register as a guest with the following information
      | Name   | LastName | Email                       |
      | Prueba | Invitado | prueba.invitado@belcorp.com |
    And add the shipping address 'Cra 75A 92-74'
    Then shipping address will be registered

