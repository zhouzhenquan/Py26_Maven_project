package com.lemon.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/8/1 11:15
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */

/*
TestNG失败重试机制
 */
public class TestngRetry implements IRetryAnalyzer {
    private Logger logger = Logger.getLogger(TestngRetry.class);
    //最大重试次数
    private int maxRetryCount = 2;
    //当前重试次数
    private int currentRetryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        //执行失败后，执行到这里的retry方法中
        //默认返回false就不会执行重试机制
        // 控制/限制重试次数，不让他进入死循环

        //注意：如果重试的时候有运行成功的话，那么它就不会再继续运行余下的重试了，统计的结果：用例pass
        //例如：登录用例执行失败-->运行第一次重试（失败）-->运行第二次重试（失败）,统计的结果：用例fail
        //例如：登录用例执行失败-->运行第一次重试（成功）-->不会运行第二次重试,统计的结果：用例pass

        //如果为false 表示不执行重试机制
        if (currentRetryCount < maxRetryCount){
            //执行一次重试机制，当前重试次数就  + 1
            currentRetryCount++;
            logger.info("================开始执行第【"+currentRetryCount+"】次重试==============");
            return true;
        }else{
            return false;
        }
0.0
    }
}

