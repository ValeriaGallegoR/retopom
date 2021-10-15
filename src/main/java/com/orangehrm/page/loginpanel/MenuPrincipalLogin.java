package com.orangehrm.page.loginpanel;

import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.common.CommonActionOnPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPrincipalLogin extends CommonActionOnPages {

    private final LoginPanelModel loginPanelModel;
    private final By assertionwelcomemenu = By.id("welcome");

    public MenuPrincipalLogin(WebDriver driver, LoginPanelModel loginPanelModel) {
        super(driver);
        this.loginPanelModel = loginPanelModel;
    }
    public boolean loginSucessful(){ return displayed(assertionwelcomemenu);
    }
}
