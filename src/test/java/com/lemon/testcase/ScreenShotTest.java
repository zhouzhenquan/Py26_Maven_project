package com.lemon.testcase;

import com.lemon.common.BaseTest;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/18 17:04
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class ScreenShotTest extends BaseTest {

    @Test
    public void taskScreenshot(){
        //返回一个file类型的图片
        File file = androidDriver.getScreenshotAs(OutputType.FILE);
        //保存至本地
        File descFile = new File("G:\\Py26_Maven_project\\Screenshots\\screenshot.png");
        try {
            FileUtils.copyFile(file,descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
