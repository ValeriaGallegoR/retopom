package com.orangehrm.stepdefinition.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class LoginPanelCucumberOpt4StepDefinition extends WebUI {

    private LoginPanelModel loginPanelModel;
    private LoginPanel loginPanel;
    private static final String ASSERTION_MESSAGE = "Username cannot be empty";

    @Given("el empleado esta en login panel de orangehrm")
    public void elEmpleadoEstaEnLoginPanelDeOrangehrm() {
        try {
            generalSetUp();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Admin");
            loginPanelModel.setPassword("admin12");
        } catch (Exception e){
            quitDriver();
        }
    }

    @When("el empleado no introduce el UserName ni el Password")
    public void elEmpleadoNoIntroduceElUserNameNiElPassword() {
        try {
            loginPanel = new LoginPanel(driver, loginPanelModel);
            loginPanel.fillLogin();
        }catch (Exception e){
            quitDriver();
        }
    }

    @Then("el sistema deberá mostrar un mensaje de Username cannot be empty")
    public void elSistemaDeberáMostrarUnMensajeDeUsernameCannotBeEmpty() {
        try {
            Assertions.assertEquals(loginPanel.expected(2), ASSERTION_MESSAGE);
        }catch (Exception e){
            quitDriver();
        }
        finally {
            quitDriver();
        }
    }

}
