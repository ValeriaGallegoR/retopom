package com.orangehrm.stepdefinition.buzzmodule;

import com.orangehrm.model.buzzmodule.BuzzModuleModel;
import com.orangehrm.model.loginpanel.LoginPanelModel;
import com.orangehrm.page.buzzmodule.BuzzUpdateStatus;
import com.orangehrm.page.buzzmodule.CategoriaBuzzMenuPrincipal;
import com.orangehrm.page.loginpanel.LoginPanel;
import com.orangehrm.page.loginpanel.MenuPrincipalLogin;
import com.orangehrm.stepdefinition.loginpanel.LoginPanelCucumberOpt1StepDefinition;
import com.orangehrm.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static com.orangehrm.util.Seconds.SEVEN_SECONDS;

public class BuzzModuleCucumberStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginPanelCucumberOpt1StepDefinition.class);
    private LoginPanel loginPanel;
    private LoginPanelModel loginPanelModel;
    private MenuPrincipalLogin menuPrincipalLogin;
    private BuzzModuleModel buzzModuleModel;
    private BuzzUpdateStatus buzzUpdateStatus;
    private CategoriaBuzzMenuPrincipal categoriaBuzzMenuPrincipal;

    @Given("el usuario se encuentra en la pagina Buzz")
    public void elUsuarioSeEncuentraEnLaPaginaBuzz() {
        try {
            generalSetUpBuzz();
            loginPanelModel = new LoginPanelModel();
            loginPanelModel.setUsername("Admin");
            loginPanelModel.setPassword("admin123");
            loginPanel = new LoginPanel(driver, loginPanelModel);
            loginPanel.fillLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado actualice su estado en la red social")
    public void elEmpleadoActualiceSuEstadoEnLaRedSocial() {
        try {
            dataConfiguration();
            loginPanelModel = new LoginPanelModel();
            categoriaBuzzMenuPrincipal = new CategoriaBuzzMenuPrincipal(driver,buzzModuleModel);
            buzzUpdateStatus = new BuzzUpdateStatus(driver,buzzModuleModel);
            categoriaBuzzMenuPrincipal.categoriaBuzz();
            buzzUpdateStatus.actionOnPage();
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema permitira interactuar con los compañeros")
    public void elSistemaPermitiraInteractuarConLosCompañeros() {
        try {
            Assertions.assertTrue(buzzUpdateStatus.postSucessful(),
                    "Se publico exitosamente el comentario");
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
        finally {
            quitDriver();
        }
    }
    private void dataConfiguration() {
        buzzModuleModel = new BuzzModuleModel();
        buzzModuleModel.setComentbox("Esto es un segundo comentario");
        buzzModuleModel.setCreatepostcontent("Hola, esto es un comentario");
    }
}
