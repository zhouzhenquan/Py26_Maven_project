package com.lemon.testcase;

import com.lemon.pageobject.Home_Page;
import com.lemon.pageobject.Login_Page;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/6 19:53
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Login_Test {
    public AndroidDriver androidDriver;

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

        Home_Page home_page = new Home_Page(androidDriver);
        home_page.clickMyLemon();
        home_page.clickPortraitLoginBy();

    }


    @Test
    public void test_login_failure() throws InterruptedException {

        Login_Page login_page = new Login_Page(androidDriver);
        login_page.inputMobilephone("12345678978");
        login_page.inputPassword("123456");
        login_page.clickLogin();

    }
}
































