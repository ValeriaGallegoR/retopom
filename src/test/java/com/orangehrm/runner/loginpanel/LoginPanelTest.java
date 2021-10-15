package com.orangehrm.runner.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.stepdefinition.setup.WebUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginPanelTest extends WebUI {

    private LoginPanel loginPanel;
    private LoginPanelModel loginPanelModel;
    private static final String ASSERTION_EXCEPTION_MESSSAGE = "Login exitoso";

    // For assertion test case
    private final By assertionwelcome = By.id("welcome");

    @BeforeEach
    public void setUp(){
        try {
            generalSetUp();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Admin");
            loginPanelModel.setPassword("admin123");
        } catch (Exception e){
           quitDriver();
        }
    }

    @Test
    public void loginPanelTestMandatoryFields(){
        try {
            //LoginPanel loginPanel = new LoginPanel(driver, loginPanelModel, SEVEN_SECONDS.getValue());
            loginPanel.fillLogin();
            if (driver.findElement(assertionwelcome).isDisplayed()) {
                System.out.println("LOGIN EXITOSO");
            }
            quitDriver();
        }catch (Exception e){
            quitDriver();
        }
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }
}
