package com.lemon.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/8/1 11:46
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class RetryListsener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method method) {
        //1、得到注解@Test里面的属性retryAnalyzer对象
        //annotation--》注解

        IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
        // 判断retryAnalyzer属性有没有设置属性
        if (iRetryAnalyzer == null){
            //设置@Test里面的属性retryAnalyzer的值
            annotation.setRetryAnalyzer(TestngRetry.class);
        }
    }
}
