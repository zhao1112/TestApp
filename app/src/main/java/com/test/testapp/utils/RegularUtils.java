package com.test.testapp.utils;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/4
 * Time: 17:38
 */
public class RegularUtils {


    //验证是否正确手机号码
    public static boolean isPhoneNumber(String phoneNumber) {

        /**
         *  移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
         * 联通：130、131、132、152、155、156、185、186
         *  电信：133、153、180、189、（1349卫通）
         *   长城：177
         *  总结起来就是第一位必定为1，第二位必定为3或5或7或8，其他位置的可以为0-9*/
        String telRegex = "[1][3578]\\d{9}";
        //"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        return phoneNumber.matches(telRegex);
    }
}
