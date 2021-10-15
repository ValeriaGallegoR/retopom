package com.orangehrm.page.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.common.CommonActionOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPanel extends CommonActionOnPages {

    private final LoginPanelModel loginPanelModel;

    //For inputs test cases
    private final By username = By.id("txtUsername");
    private final By password = By.id("txtPassword");
    private final By submitlogin = By.id("btnLogin");
    private final By assertioncredentials = By.id("spanMessage");
    private final By assertiontUserEmpty = By.id("spanMessage");

    public LoginPanel(WebDriver driver, LoginPanelModel loginPanelModel) {
        super(driver);
        this.loginPanelModel = loginPanelModel;
    }

    //Page functions
    public void fillLogin(){
        clear(username);
        type(username, loginPanelModel.getUsername());

        clear(password);
        type(password, loginPanelModel.getPassword());

        doSubmit(submitlogin);
    }


    public String expected(int casos) {
        switch (casos) {
            case 1:
                return "Invalid credentials";
            case 2:
                return "Username cannot be empty";
            default:
                return "Default";
        }
    }
}
