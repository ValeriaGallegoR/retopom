package com.orangehrm.stepdefinition.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class LoginPanelCucumberOpt2StepDefinition extends WebUI {

    private LoginPanelModel loginPanelModel;
    private LoginPanel loginPanel;
    private static final String ASSERTION_MESSAGE = "Invalid credentials";

    @Given("el usuario esta en la pagina de inicio de sesion")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesion() {
        try {
            generalSetUp();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Admin");
            loginPanelModel.setPassword("admin12");
        } catch (Exception e){
            quitDriver();
        }
    }

    @When("el empleado ingrese contraseña invalida y usuario valido")
    public void elEmpleadoIngreseContraseñaInvalidaYUsuarioValido() {
        try {
            loginPanel = new LoginPanel(driver, loginPanelModel);
            loginPanel.fillLogin();
        }catch (Exception e){
            quitDriver();
        }
    }

    @Then("el sistema deberá mostrar un mensaje de invalid credentials")
    public void elSistemaDeberáMostrarUnMensajeDeInvalidCredentials() {
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
