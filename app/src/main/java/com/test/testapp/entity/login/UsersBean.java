package com.test.testapp.entity.login;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/4/7
 * Time: 10:28
 */
public class UsersBean {

    private String usersHeard;
    private String usersName;
    private String age;
    private String city;
    private String occupation;
    private String cm;
    private String usersWeight;
    private String weixin;
    private String qq;
    private boolean authentication;
    private int lookingNumber;
    private int dynamicNumber;
    private double flowercoin;
    private List<AlbumList> albumLists;
    private int readingNumber;

    public String getUsersHeard() {
        return usersHeard;
    }

    public void setUsersHeard(String usersHeard) {
        this.usersHeard = usersHeard;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public String getUsersWeight() {
        return usersWeight;
    }

    public void setUsersWeight(String usersWeight) {
        this.usersWeight = usersWeight;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public int getLookingNumber() {
        return lookingNumber;
    }

    public void setLookingNumber(int lookingNumber) {
        this.lookingNumber = lookingNumber;
    }

    public int getDynamicNumber() {
        return dynamicNumber;
    }

    public void setDynamicNumber(int dynamicNumber) {
        this.dynamicNumber = dynamicNumber;
    }

    public double getFlowercoin() {
        return flowercoin;
    }

    public void setFlowercoin(double flowercoin) {
        this.flowercoin = flowercoin;
    }

    public List<AlbumList> getAlbumLists() {
        return albumLists;
    }

    public void setAlbumLists(List<AlbumList> albumLists) {
        this.albumLists = albumLists;
    }

    public int getReadingNumber() {
        return readingNumber;
    }

    public void setReadingNumber(int readingNumber) {
        this.readingNumber = readingNumber;
    }

    public static class AlbumList {
        private String userImage;
        private String userVideoPath;
        private String userVideo;
        private boolean isVideo;

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getUserVideoPath() {
            return userVideoPath;
        }

        public void setUserVideoPath(String userVideoPath) {
            this.userVideoPath = userVideoPath;
        }

        public String getUserVideo() {
            return userVideo;
        }

        public void setUserVideo(String userVideo) {
            this.userVideo = userVideo;
        }

        public boolean isVideo() {
            return isVideo;
        }

        public void setVideo(boolean video) {
            isVideo = video;
        }
    }
}
