package com.test.testapp.entity.news;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/16
 * Time: 11:00
 */
public class NewsListBean {

    /**
     * code : 0
     * data : [{"sendTime":"刚刚","userHeard":"http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","userMessage":"你好吗[你好]","userName":"青苔"},{"sendTime":"15:43","userHeard":"http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320","userMessage":"晚安[月亮]","userName":"伊诺"},{"sendTime":"15:30","userHeard":"http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","userMessage":"哈咯[可爱]","userName":"瞌睡虫"},{"sendTime":"15:28","userHeard":"http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","userMessage":"你好吗[你好]","userName":"青苔"},{"sendTime":"15:25","userHeard":"http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320","userMessage":"晚安[月亮]","userName":"伊诺"},{"sendTime":"15:10","userHeard":"http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","userMessage":"哈咯[可爱]","userName":"瞌睡虫"}]
     * msg : 请求成功
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sendTime : 刚刚
         * userHeard : http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c
         * userMessage : 你好吗[你好]
         * userName : 青苔
         */

        private String sendTime;
        private String userHeard;
        private String userMessage;
        private String userName;

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public String getUserHeard() {
            return userHeard;
        }

        public void setUserHeard(String userHeard) {
            this.userHeard = userHeard;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
