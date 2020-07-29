package com.lemon.common;

import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/9 10:35
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class BaseTest {
    public Logger logger = Logger.getLogger(BaseTest.class);

    public static AndroidDriver androidDriver;

    @Parameters({"deviceName", "platformName", "appPackage", "appActivity", "appiumUrl"})
    @BeforeTest
    public void setUp(String deviceName, String platformName, String appPackage, String appActivity, String appiumUrl) throws MalformedURLException, InterruptedException {


        //前置条件：1、打开测试App 2、进入到登录页面
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);

        URL url = new URL(appiumUrl);
        androidDriver = new AndroidDriver(url, desiredCapabilities);
        logger.info("========打开测试APP==========");
        logger.info("deviceName" + deviceName);
        logger.info("platformName" + platformName);
        logger.info("appPackage" + appPackage);
        logger.info("appActivity" + appActivity);

    }
}