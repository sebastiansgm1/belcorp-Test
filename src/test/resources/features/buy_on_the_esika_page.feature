#language: en

Feature: test product purchase

  Scenario: test address registration
    Given I enter the page 'https://www.esika.com/pe' and enter 'Perfumes/Maderosa' section
    When I add the 'Magnat' product with 1 additional quanity
    And I register as a guest with the following information
      | Name   | LastName | Email                       |
      | Prueba | Invitado | prueba.invitado@belcorp.com |
    And add the shipping address
      | Department | Province | District | Address       | Additional Info | Reference           | PhoneNumber |
      | AMAZONAS   | BAGUA    | ARAMANGO | Cra 75A 92-74 | Apto 102        | Frente a la iglesia | 3217524785  |
    Then shipping address is registered

