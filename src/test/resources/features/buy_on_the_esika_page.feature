#language: en

Feature: test product purchase

  Scenario: test address registration
    Given 'Sebastian' entered the page esika and entered 'Perfumes/Maderosa' section
    When He adds the 'Magnat' product with 1 additional quanity
    And he registers as a guest with the following information
      | Name   | LastName | Email                       |
      | Prueba | Invitado | prueba.invitado@belcorp.com |
    And adds the shipping address
      | Department | Province | District  | Address       | Additional Info | Reference           | PhoneNumber |
      | AMAZONAS   | BAGUA    | ARAMANGO | Cra 75A 92-74 | Apto 102        | Frente a la iglesia | 3217524785  |
    Then shipping address is registered

