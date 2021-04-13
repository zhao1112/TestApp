package com.test.testapp.entity.dynamic;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/13
 * Time: 11:10
 */
public class DynamicBean {

    /**
     * code : 0
     * data : [{"age":21,"authentication":false,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":["http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f","http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","http://gank.io/images/6b2efa591564475fb8bc32291fb0007c","http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320"],"like":true,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"00","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":""},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"01","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"02","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":false,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":["http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f","http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","http://gank.io/images/6b2efa591564475fb8bc32291fb0007c","http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320"],"like":true,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"00","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":""},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"01","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"02","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":false,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":["http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f","http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","http://gank.io/images/6b2efa591564475fb8bc32291fb0007c","http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320"],"like":true,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"00","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":""},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"01","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"02","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":false,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":["http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f","http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","http://gank.io/images/6b2efa591564475fb8bc32291fb0007c","http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320"],"like":true,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"00","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":""},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"01","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"02","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"},{"age":21,"authentication":true,"conditionList":["#最近可约","#诚意可聊","#素质私聊"],"content":"看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···","heardLoader":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageList":[],"like":false,"likeNumber":120,"name":"什么是快了星球","occupation":"老师","participate":"","themeList":["线上陪聊"],"time":1258663241282,"timeList":["晚上","2020/12/25·昆明"],"videoCover":"http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","videoPath":"https://apd-vlive.apdcdn.tc.qq.com/vipzj.video.tc.qq.com/t31590kwfch.mp4?vkey=A08CA1C878D8432308F52FD939B3A0691232E39564583239B1EC28A1EC46938A46450B839F82CC6B8A52F563CC47DC537D09B9165875FD4479A012F3425F2BD79D865575BE08A38D625B09358E0ACF34FD1616A2D1C8FAE277EF90A000262EB9BDDD7000918E19D12AC3318BB494379C&level=0&fmt=hd&platform=10201&uid=155272813"}]
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
         * age : 21
         * authentication : false
         * conditionList : ["#最近可约","#诚意可聊","#素质私聊"]
         * content : 看过这样一个故事。有个刚入行的理发师第一次上手，一紧张剪得有点狠。顾客看了看镜子，撇了撇嘴，气氛格外尴尬。 旁边的老师傅心领神···
         * heardLoader : http://gank.io/images/ccf0316264d245018fc651cffa6e90de
         * imageList : ["http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","http://gank.io/images/25d3e3db2c1248bb917c09dc4f50a46f","http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b","http://gank.io/images/9fa43020cf724c69842eec3e13f6d21c","http://gank.io/images/d6bba8cf5b8c40f9ad229844475e9149","http://gank.io/images/6b2efa591564475fb8bc32291fb0007c","http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320"]
         * like : true
         * likeNumber : 120
         * name : 什么是快了星球
         * occupation : 老师
         * participate : 00
         * themeList : ["线上陪聊"]
         * time : 1258663241282
         * timeList : ["晚上","2020/12/25·昆明"]
         * videoCover : http://gank.io/images/d237f507bf1946d2b0976e581f8aab9b
         * videoPath :
         */

        private int age;
        private boolean authentication;
        private String content;
        private String heardLoader;
        private boolean like;
        private int likeNumber;
        private String name;
        private String occupation;
        private String participate;
        private long time;
        private String videoCover;
        private String videoPath;
        private List<String> conditionList;
        private List<String> imageList;
        private List<String> themeList;
        private List<String> timeList;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isAuthentication() {
            return authentication;
        }

        public void setAuthentication(boolean authentication) {
            this.authentication = authentication;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHeardLoader() {
            return heardLoader;
        }

        public void setHeardLoader(String heardLoader) {
            this.heardLoader = heardLoader;
        }

        public boolean isLike() {
            return like;
        }

        public void setLike(boolean like) {
            this.like = like;
        }

        public int getLikeNumber() {
            return likeNumber;
        }

        public void setLikeNumber(int likeNumber) {
            this.likeNumber = likeNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getParticipate() {
            return participate;
        }

        public void setParticipate(String participate) {
            this.participate = participate;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getVideoCover() {
            return videoCover;
        }

        public void setVideoCover(String videoCover) {
            this.videoCover = videoCover;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
            this.videoPath = videoPath;
        }

        public List<String> getConditionList() {
            return conditionList;
        }

        public void setConditionList(List<String> conditionList) {
            this.conditionList = conditionList;
        }

        public List<String> getImageList() {
            return imageList;
        }

        public void setImageList(List<String> imageList) {
            this.imageList = imageList;
        }

        public List<String> getThemeList() {
            return themeList;
        }

        public void setThemeList(List<String> themeList) {
            this.themeList = themeList;
        }

        public List<String> getTimeList() {
            return timeList;
        }

        public void setTimeList(List<String> timeList) {
            this.timeList = timeList;
        }
    }
}
