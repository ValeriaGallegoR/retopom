package com.orangehrm.page.buzzmodule;

import com.orangehrm.model.buzzmodule.BuzzModuleModel;
import com.orangehrm.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuzzUpdateStatus extends CommonActionOnPages {

    private BuzzModuleModel buzzModuleModel;
    private static final Logger LOGGER = Logger.getLogger(BuzzUpdateStatus.class);

    //For inputs test cases
    private final By updatestatus = By.id("status-tab-label");
    private final By createpostcontent = By.xpath("//*[@id=\"createPost_content\"]");
    private final By postsubmit = By.id("postSubmitBtn");
    private final By likesubmit = By.xpath("//*[@id=\"postLike_21\"]");
    private final By expandsubmit = By.xpath("//*[@id=\"shareViewMore_21\"]");
    private final By closeexpandsubmit = By.xpath("//*[@id=\"shareViewMoreMod1_21\"]");
    private final By comentbox = By.xpath("//*[@id=\"commentBoxNew_listId21\"]");
    private final By comentsubmit = By.xpath("//*[@id=\"commentBoxNew_listId21\"]");
    private final By sharesubmit = By.xpath("//*[@id=\"postLike_21\"]");
    private final By confirmsharesubmit = By.xpath("//*[@id=\"btnShare_21_19\"]");

    // Asserts
    private final By assertpost = By.xpath("//*[@id=\"postContent_31\"]");

    public BuzzUpdateStatus(WebDriver driver, BuzzModuleModel buzzModuleModel) {
        super(driver);
        this.buzzModuleModel = buzzModuleModel;
    }

    //Page functions

    public void actionOnPage(){
        clickOn(updatestatus);

        clear(createpostcontent);
        type(createpostcontent, buzzModuleModel.getCreatepostcontent());

        javascriptExecutor("arguments[0].click();", postsubmit);

        javascriptExecutor("arguments[0].click();", likesubmit);

        javascriptExecutor("arguments[0].click();", expandsubmit);

        javascriptExecutor("arguments[0].click();", closeexpandsubmit);


        clear(comentbox);
        type(comentbox, buzzModuleModel.getComentbox());

        javascriptExecutor("arguments[0].click();", comentsubmit);

        javascriptExecutor("arguments[0].click();", sharesubmit);

        javascriptExecutor("arguments[0].click();", confirmsharesubmit);

    }

    public boolean postSucessful(){
        return displayed(assertpost);
    }
}
