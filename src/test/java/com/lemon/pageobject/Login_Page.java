package com.lemon.pageobject;

import com.lemon.common.Base_Page;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 周振全
 * @Description: 登录界面
 * @date 2020/7/6 20:38
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Login_Page extends Base_Page {
    public AndroidDriver androidDriver;

    public Login_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    //登录账号
    private By mobilephoneBy = By.id("com.lemon.lemonban:id/et_mobile");
    //登录密码
    private By passwordBy = By.id("com.lemon.lemonban:id/et_password");
    //点击登录
    private By loginBy = By.id("com.lemon.lemonban:id/btn_login");

    // 输入手机号码
    public void inputMobilephone(String data) {
        waitElementVisible(androidDriver,mobilephoneBy).sendKeys(data);
    }

    //输入登录密码
    public void inputPassword(String data) {
        waitElementVisible(androidDriver,passwordBy).sendKeys(data);
    }

    //点击登录
    public void clickLogin() {
        waitElementClickable(androidDriver,loginBy).click();
    }


}
