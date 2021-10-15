package com.orangehrm.page.buzzmodule;

import com.orangehrm.model.buzzmodule.BuzzModuleModel;
import com.orangehrm.page.common.CommonActionOnPages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriaBuzzMenuPrincipal extends CommonActionOnPages {

    private final BuzzModuleModel buzzModuleModel;
    private final By categoriabuzz = By.id("menu_buzz_viewBuzz");
    private final By assertioncategoria = By.id("status-tab-label");

    public CategoriaBuzzMenuPrincipal(WebDriver driver, BuzzModuleModel buzzModuleModel) {
        super(driver);
        this.buzzModuleModel = buzzModuleModel;
    }
    public void categoriaBuzz(){
         clickOn(categoriabuzz);
    }
    public boolean categoriaSucessful (){
        return displayed(assertioncategoria);
    }
}
