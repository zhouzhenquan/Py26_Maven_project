package com.lemon.common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
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
    private Logger logger = Logger.getLogger(Base_Page.class);

    //等待元素可见
    public WebElement waitElementVisible(AndroidDriver androidDriver, By by){
        WebElement webElement = null;
        try {
            WebDriverWait webDriverWait =  new WebDriverWait(androidDriver,10);
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            //y异常处理
            logger.error("等待元素可见【"+by+"】可见失败！！！");
        }

        return webElement;
    }

    //等待元素被点击
    public WebElement waitElementClickable(AndroidDriver androidDriver,By by){
        WebElement webElement = null;
        try {
            WebDriverWait webDriverWait =  new WebDriverWait(androidDriver,10);
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.error("等待元素被点击【"+by+"】可被点击失败！！！");
        }

        return webElement;
    }

    //等待元素dom存在
    public WebElement waitElementExist(AndroidDriver androidDriver,By by){
        WebElement webElement = null;
        try {
            WebDriverWait webDriverWait = new WebDriverWait(androidDriver,10);
            webElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.error("等待元素dom存在【"+by+"】在当前页面存在失败！！！");
        }

        return webElement;
    }

    //获取toast文本值
    public String  getToastText(AndroidDriver androidDriver,String toastText){
        By by = By.xpath("//*[contains(@text,'" + toastText + "')]");
        return waitElementExist(androidDriver,by).getText();

    }

    //输入数据二次分装
    public void type(AndroidDriver androidDriver,By by,String data){
        logger.info("往元素【" + by + "】输入数据【" + data + "】");
        waitElementVisible(androidDriver, by).sendKeys(data);
    }

    //点击的二次分装
    public void click(AndroidDriver androidDriver,By by){
        logger.info("点击了元素【" + by + "】");
        waitElementClickable(androidDriver,by).click();
    }

    //获取元素文本二次分装
    public String getElementText(AndroidDriver androidDriver,By by){
        String text = waitElementVisible(androidDriver,by).getText();
        logger.info("获取元素【" + by + "】文本值【" + text + "】");
        return text;

    }


}












