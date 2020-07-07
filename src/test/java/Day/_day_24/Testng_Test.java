package Day._day_24;

import org.testng.annotations.*;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/6/24 20:57
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class Testng_Test {

    @BeforeTest
    public void testBegin(){
        System.out.println("测试开始之前");
    }

    @BeforeMethod
    public void testBefore(){
        System.out.println("测试之前");
    }

    @Test
    public void testLogin(){
        System.out.println("登录测试！");
    }
    @Test
    public void testRegister(){
        System.out.println("注册测试！");
    }

    @AfterMethod
    public void testAfter(){
        System.out.println("测试之后");
    }

    @AfterTest
    public void TestAfter(){
        System.out.println("测试结束之后");
    }
}
