# new feature
# Tags: optional

Feature: como usuario de la plataforma orangeHRM
  necesito actualizar mi estatus en la red de la plataforma
  para poder interactuar con mis compañeros

  Scenario: Update status
    Given el usuario se encuentra en la pagina Buzz
    When el empleado actualice su estado en la red social
    Then el sistema permitira interactuar con los compañeros