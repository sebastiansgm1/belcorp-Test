#language: en

#  @device=GalaxyS20Ultra
#  @device=Iphone12pro
@device=Windows10
Feature: As a customer I would like to choose a product so that it purchases in the old checkout

  @checkout_regression @test_registration
  Scenario: test address registration at the old checkout
    Given I entered the page 'https://s1-esika.tiendabelcorp.com/pe' and entered 'Perfumes/Maderosa' section
    When I add the 'Magnat' product with 1 additional quanity
    And I register as a guest with the following information
      | Name   | LastName | Email                       |
      | Prueba | Invitado | prueba.invitado@belcorp.com |
    And add the shipping address 'Cra 75A 92-74'
    Then shipping address will be registered




