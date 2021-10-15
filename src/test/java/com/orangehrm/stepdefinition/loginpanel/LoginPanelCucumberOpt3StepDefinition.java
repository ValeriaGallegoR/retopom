package com.orangehrm.stepdefinition.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginPanelCucumberOpt3StepDefinition extends WebUI {

    private LoginPanelModel loginPanelModel;
    private LoginPanel loginPanel;
    private static final String ASSERTION_MESSAGE = "Invalid credentials";

    @Given("el empleado esta en el inicio de sesion")
    public void elEmpleadoEstaEnElInicioDeSesion() {
        try {
            generalSetUp();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Valeria");
            loginPanelModel.setPassword("admin123");
        } catch (Exception e){
            quitDriver();
        }
    }

    @When("el empleado ingrese contraseña valida y usuario invalido")
    public void elEmpleadoIngreseContraseñaValidaYUsuarioInvalido() {
        try {
            loginPanel = new LoginPanel(driver, loginPanelModel);
            loginPanel.fillLogin();
        }catch (Exception e){
            quitDriver();
        }
    }

    @Then("el sistema deberá mostrar un mensaje de credenciales invalidos")
    public void elSistemaDeberáMostrarUnMensajeDeCredencialesInvalidos() {
        try {
            Assertions.assertEquals(loginPanel.expected(1), ASSERTION_MESSAGE);
        }catch (Exception e){
            quitDriver();
        }
        finally {
            quitDriver();
        }
    }
}
