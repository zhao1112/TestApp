package com.test.testapp.entity;

import com.contrarywind.interfaces.IPickerViewData;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/6
 * Time: 15:42
 */
public class AgeBean implements IPickerViewData {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPickerViewText() {
        return this.name;
    }
}
