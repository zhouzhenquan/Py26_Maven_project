package Appnium_Test.Day_27;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/6/26 14:05
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class BeiKe_Test {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        // 1.打开测试app
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // 1) deviceName
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        // 2) platformName
        desiredCapabilities.setCapability("platformName", "Android");
        // 3) appPackage
        desiredCapabilities.setCapability("appPackage", "com.lianjia.beike");
        // 4) appActivity
        desiredCapabilities.setCapability("appActivity", "com.homelink.android.SplashScreenActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);
        // 2.找到界面元素
        // 3.操作页面元素
        Thread.sleep(5000);
        androidDriver.findElementById("com.lianjia.beike:id/tv_authority_bottom").click();
        Thread.sleep(5000);
        androidDriver.findElementById("com.lianjia.beike:id/tv_right_btn").click();
        Thread.sleep(5000);
        androidDriver.findElementById("com.lianjia.beike:id/icon_del").click();
        Thread.sleep(5000);
        androidDriver.findElementByClassName("android.widget.RelativeLayout").click();

    }
}
