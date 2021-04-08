package com.test.testapp.entity;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/7
 * Time: 15:07
 */
public class DataListBean {

    /**
     * code : 0
     * data : [{"imageLoad":"http://gank.io/images/ccf0316264d245018fc651cffa6e90de","imageHeight":500,"name":"天下第一","photoNumber":10,"videoNumber":12,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"1km","isOnline":true},{"imageLoad":"http://gank.io/images/e92911f5ff9446d5a899b652b1934b93","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":false,"age":20,"occupation":"护士","address":"昆明","distance":"1km","isOnline":true},{"imageLoad":"http://gank.io/images/f12526b3e9654a47842db6ce21222874","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":false,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":false},{"imageLoad":"http://gank.io/images/f08e8ab6030d41a0ada3e6cecea0e60c","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":false},{"imageLoad":"http://gank.io/images/fb1c315d54e1413494223aca31a9c47c","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/3fdbaffdf3374578a82313621123dace","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/6e57b254da79416bbe58248b570ea85f","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/92989b6a707b44dfb1c734e8d53d39a2","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/bdb35e4b3c0045c799cc7a494a3db3e0","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/f0c192e3e335400db8a709a07a891b2e","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true},{"imageLoad":"http://gank.io/images/19c99c447e0a40a6b3ff89951957cfb1","imageHeight":450,"name":"哈哈哈","photoNumber":20,"videoNumber":10,"isAuthentication":true,"age":20,"occupation":"护士","address":"昆明","distance":"10km","isOnline":true}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * imageLoad : http://gank.io/images/ccf0316264d245018fc651cffa6e90de
         * imageHeight : 500
         * name : 天下第一
         * photoNumber : 10
         * videoNumber : 12
         * isAuthentication : true
         * age : 20
         * occupation : 护士
         * address : 昆明
         * distance : 1km
         * isOnline : true
         */

        private String imageLoad;
        private int imageHeight;
        private String name;
        private int photoNumber;
        private int videoNumber;
        private boolean isAuthentication;
        private int age;
        private String occupation;
        private String address;
        private String distance;
        private boolean isOnline;

        public String getImageLoad() {
            return imageLoad;
        }

        public void setImageLoad(String imageLoad) {
            this.imageLoad = imageLoad;
        }

        public int getImageHeight() {
            return imageHeight;
        }

        public void setImageHeight(int imageHeight) {
            this.imageHeight = imageHeight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPhotoNumber() {
            return photoNumber;
        }

        public void setPhotoNumber(int photoNumber) {
            this.photoNumber = photoNumber;
        }

        public int getVideoNumber() {
            return videoNumber;
        }

        public void setVideoNumber(int videoNumber) {
            this.videoNumber = videoNumber;
        }

        public boolean isIsAuthentication() {
            return isAuthentication;
        }

        public void setIsAuthentication(boolean isAuthentication) {
            this.isAuthentication = isAuthentication;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public boolean isIsOnline() {
            return isOnline;
        }

        public void setIsOnline(boolean isOnline) {
            this.isOnline = isOnline;
        }
    }
}
