package com.lemon.listener;
import com.lemon.common.BaseTest;
import com.lemon.common.Base_Page;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/25 16:41
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */

/*
测试结果监听类
 */
public class TestResultListener implements IHookable {

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        //run方法替换@Test注解标注的所有测试方法
        //得到测试结果，保证@Test注解标注的所有测试方法能够正常执行
        callBack.runTestMethod(testResult);
        //判断测试结果有没有异常 getThrowable()-->获取异常
        if(testResult.getThrowable() != null){
            //截图调用
            //为什么takeScreenshot得要是静态的，因为我们这里创建不了BasePage对象
            //androidDriver创建不了BaseTest对象
            //指定截图的路径在哪里
            //保证截图文件名字 每一次调用都不同
            saveScreenshot();

        }
    }

    @Attachment(value = "screenshot",type = "image/png")
    public byte[] saveScreenshot(){
        return Base_Page.takeScreenshot(BaseTest.androidDriver);
    }
}