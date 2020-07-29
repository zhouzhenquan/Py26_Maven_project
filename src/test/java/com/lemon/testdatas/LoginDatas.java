package com.lemon.testdatas;

import org.testng.annotations.DataProvider;

/**
 * @author 周振全
 * @Description: TODO
 * @date 2020/7/9 10:59
 * @Copyright:杭州盛和游戏网络技术有限公司. All rights reserved.
 */
public class LoginDatas {
    @DataProvider
    public Object[][] getLoginFailureDatas() {
        Object[][] datas = {{"13323234545", "123456", "错误的账号信息"},
                {"1332323454", "123456", "手机号码格式不正确"},
                {"", "123456", "手机号码或密码不能为空"}};
        return datas;
    }
}
