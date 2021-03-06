package com.lemon.pageobject;

import com.lemon.common.Base_Page;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 周振全
 * @Description: 首页对象
 * @date 2020/7/6 20:39
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Home_Page extends Base_Page {
    //实例化logger日志对象
    private Logger logger = Logger.getLogger(Home_Page.class);
    public AndroidDriver androidDriver;

    public Home_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    //点击我的柠檬
    private By myLemonBy = By.id("com.lemon.lemonban:id/navigation_my");
    //点击头像登录
    private By portraitLoginBy = By.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout");
    //用户名元素
    private By userNameBy = By.id("com.lemon.lemonban:id/fragment_my_lemon_avatar_title");

    //点击我的柠檬
    public void clickMyLemon() {
        click(androidDriver,myLemonBy);
    }

    //点击头像登录
    public void clickPortraitLogin() {
        click(androidDriver,portraitLoginBy);
    }

    //获取用户名
    public String getUserName() {
        String text = waitElementClickable(androidDriver, userNameBy).getText();
        logger.info("获取用户名：" + text);
        return text;
    }


}
