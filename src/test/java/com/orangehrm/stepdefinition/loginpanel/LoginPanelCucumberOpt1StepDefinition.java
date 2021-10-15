package com.orangehrm.stepdefinition.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.page.loginpanel.MenuPrincipalLogin;
import com.orangehrm.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class LoginPanelCucumberOpt1StepDefinition extends WebUI {

    private LoginPanelModel loginPanelModel;
    private LoginPanel loginPanel;
    private MenuPrincipalLogin menuPrincipalogin;
    private static final String ASSERTION_MESSAGE = "El usuario ingresó exitosamente al menú Welcome";

    @Given("el empleado se encuentra en la pagina login de la plataforma")
    public void elEmpleadoSeEncuentraEnLaPaginaLoginDeLaPlataforma() {
        try {
            generalSetUp();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Admin");
            loginPanelModel.setPassword("admin123");
        } catch (Exception e){
            quitDriver();
        }
    }

    @When("el empleado ingrese contraseña y usuario valido")
    public void elEmpleadoIngreseContraseñaYUsuarioValido() {
        try {
            loginPanel = new LoginPanel(driver, loginPanelModel);
            loginPanel.fillLogin();
        }catch (Exception e){
            quitDriver();
        }
    }

    @Then("el sistema deberá mostrar un mensaje de Welcome con el nombre del usuario")
    public void elSistemaDeberáMostrarUnMensajeDeWelcomeConElNombreDelUsuario() {
        try {
            Assertions.assertTrue(menuPrincipalogin.loginSucessful(),ASSERTION_MESSAGE);
        }catch (Exception e){
            quitDriver();
        }
        finally {
            quitDriver();
        }
    }
}
