package Appnium_Test.Day_26;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/6/26 10:14
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class FirstAppAutoTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // 1.打开测试app
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // 1) deviceName
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
        // 2) platformName
        desiredCapabilities.setCapability("platformName", "Android");
        // 3) appPackage
        desiredCapabilities.setCapability("appPackage", "com.lemon.lemonban");
        // 4) appActivity
        desiredCapabilities.setCapability("appActivity", "com.lemon.lemonban.activity.WelcomeActivity");


        // 与APPnium进行通讯  第一个参数：APPnium通讯地址  第二个参数：配置对象
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver androidDriver = new AndroidDriver(url,desiredCapabilities);
        // 2.找到界面元素
        // 3.操作页面元素
        Thread.sleep(5000);
        //点击 “我的柠檬”
        androidDriver.findElementById("com.lemon.lemonban:id/navigation_my").click();

        //点击 “头像登录”
        androidDriver.findElementById("com.lemon.lemonban:id/fragment_my_lemon_avatar_layout").click();

        Thread.sleep(1000);


        //选择 账号与密码
        androidDriver.findElementById("com.lemon.lemonban:id/et_mobile").sendKeys("13323234545");
        androidDriver.findElementById("com.lemon.lemonban:id/et_password").sendKeys("123456");

        // 点击 “登录”
        androidDriver.findElementById("com.lemon.lemonban:id/btn_login").click();


        // 坐标定位
        TouchAction touchAction = new TouchAction(androidDriver);
        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(625,648);
        touchAction.press(pointOption).perform();
    }
}
