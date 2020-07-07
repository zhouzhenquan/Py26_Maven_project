package com.lemon.common;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 周振全
 * @Description: 等待元素
 * @date 2020/7/6 21:58
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Base_Page {

    //等待元素可见
    public WebElement waitElementVisible(AndroidDriver androidDriver, By by){
        WebDriverWait webDriverWait =  new WebDriverWait(androidDriver,10);
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webElement;
    }

    //等待元素被点击
    public WebElement waitElementClickable(AndroidDriver androidDriver,By by){
        WebDriverWait webDriverWait =  new WebDriverWait(androidDriver,10);
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        return webElement;
    }


}












