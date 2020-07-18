package com.lemon.testcase;

import com.lemon.common.BaseTest;
import com.lemon.common.Base_Page;
import com.lemon.pageobject.Home_Page;
import com.lemon.pageobject.Login_Page;
import com.lemon.testdatas.Constants;
import com.lemon.testdatas.LoginDatas;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/6 19:53
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Login_Test extends BaseTest {


    @BeforeClass
    public void setUpClass(){
        Home_Page home_page = new Home_Page(androidDriver);
        home_page.clickMyLemon();
        home_page.clickPortraitLogin();
    }



    @Test(dataProviderClass = LoginDatas.class,dataProvider = "getLoginFailureDatas")
    public void test_login_failure(String mobilephone, String password, String toastText) throws InterruptedException {

        Login_Page login_page = new Login_Page(androidDriver);
        login_page.inputMobilephone(mobilephone);
        login_page.inputPassword(password);
        login_page.clickLogin();

        //断言 toast信息
        String actualValue = login_page.getToastText(androidDriver,toastText);
        String expectedValue = toastText;
        Assert.assertEquals(actualValue, expectedValue);

    }

    @Test
    public void test_login_success() throws InterruptedException {

        Login_Page login_page = new Login_Page(androidDriver);
        login_page.inputMobilephone(Constants.CORRECT_MOBILEPHONE);
        login_page.inputPassword(Constants.CORRECT_PASSWORD);
        login_page.clickLogin();

        Thread.sleep(5000);
        //断言1--根据跳转之后页面的页面名activityName
        String expectedValue01 = ".activity.MainActivity";
        String actualValue01 = androidDriver.currentActivity();
        Assert.assertEquals(actualValue01, expectedValue01);
        //断言2--根据跳转之后的页面是否有“歪歪”用户名
        Home_Page home_page =new Home_Page(androidDriver);
        String actualValue02 = home_page.getUserName();
        String expectedValue02 = "歪歪";
        Assert.assertEquals(actualValue02,expectedValue02);



    }


}
































