# new feature
# Tags: optional

Feature: como empleado de recursos humanos
  necesito loguearme a la plataforma orangeHRM
  para realizar la gestión adecuada de recursos humanos de la empresa


  Scenario: inicio de sesion exitoso
    Given el empleado se encuentra en la pagina login de la plataforma
    When el empleado ingrese contraseña y usuario valido
    Then el sistema deberá mostrar un mensaje de Welcome con el nombre del usuario


  Scenario: inicio de sesion password invalido
    Given el usuario esta en la pagina de inicio de sesion
    When el empleado ingrese contraseña invalida y usuario valido
    Then el sistema deberá mostrar un mensaje de invalid credentials


  Scenario: inicio de sesion password invalido
    Given el empleado esta en el inicio de sesion
    When el empleado ingrese contraseña valida y usuario invalido
    Then el sistema deberá mostrar un mensaje de credenciales invalidos

  Scenario: inicio de sesion no se introducen credenciales
    Given el empleado esta en login panel de orangehrm
    When el empleado no introduce el UserName ni el Password
    Then el sistema deberá mostrar un mensaje de Username cannot be empty
