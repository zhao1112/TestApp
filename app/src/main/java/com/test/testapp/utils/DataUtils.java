package com.test.testapp.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.test.testapp.entity.AgeBean;
import com.test.testapp.entity.CitysBean;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: Administrator
 * Date: 2021/2/6
 * Time: 15:33
 */
public class DataUtils {
    private static DataUtils mInstance;

    private DataUtils() {

    }

    /**
     * 初始化MMKV,只需要初始化一次，建议在Application中初始化
     */
    public static DataUtils getInstance() {
        if (mInstance == null) {
            synchronized (DataUtils.class) {
                if (mInstance == null) {
                    mInstance = new DataUtils();
                }
            }
        }
        return mInstance;
    }

    public void initJsonData(Context context, List<CitysBean> options1Items, ArrayList<ArrayList<String>> options2Items, ArrayList<ArrayList<ArrayList<String>>> options3Items) {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = new GetJsonDataUtil().getJson(context, "province.json");//获取assets目录下的json文件数据

        ArrayList<CitysBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items.addAll(jsonBean);

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）
            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }
    }

    public ArrayList<CitysBean> parseData(String result) {//Gson 解析
        ArrayList<CitysBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                CitysBean entity = gson.fromJson(data.optJSONObject(i).toString(), CitysBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    public ArrayList<AgeBean> initAgeData() {
        ArrayList<AgeBean> ageBeans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            AgeBean ageBean = new AgeBean();
            ageBean.setName(i + "岁");
            ageBeans.add(ageBean);
        }
        return ageBeans;
    }

    public ArrayList<AgeBean> initOccupationData() {
        ArrayList<AgeBean> ageBeans = new ArrayList<>();
        AgeBean ageBean = new AgeBean();
        ageBean.setName("护士");
        ageBeans.add(ageBean);
        AgeBean ageBean1 = new AgeBean();
        ageBean1.setName("空姐");
        ageBeans.add(ageBean1);
        AgeBean ageBean2 = new AgeBean();
        ageBean2.setName("模特");
        ageBeans.add(ageBean2);
        AgeBean ageBean3 = new AgeBean();
        ageBean3.setName("音乐家");
        ageBeans.add(ageBean3);
        AgeBean ageBean4 = new AgeBean();
        ageBean4.setName("老师");
        ageBeans.add(ageBean4);
        AgeBean ageBean5 = new AgeBean();
        ageBean5.setName("设计师");
        ageBeans.add(ageBean5);
        AgeBean ageBean6 = new AgeBean();
        ageBean6.setName("主播");
        ageBeans.add(ageBean6);
        AgeBean ageBean7 = new AgeBean();
        ageBean7.setName("医生");
        ageBeans.add(ageBean7);
        AgeBean ageBean8 = new AgeBean();
        ageBean8.setName("会计");
        ageBeans.add(ageBean8);
        AgeBean ageBean9 = new AgeBean();
        ageBean9.setName("司机");
        ageBeans.add(ageBean9);
        AgeBean ageBean10 = new AgeBean();
        ageBean10.setName("厨师");
        ageBeans.add(ageBean10);
        return ageBeans;
    }

    public ArrayList<AgeBean> initCMData() {
        ArrayList<AgeBean> ageBeans = new ArrayList<>();
        for (int i = 100; i < 250; i++) {
            AgeBean ageBean = new AgeBean();
            ageBean.setName(i + "cm");
            ageBeans.add(ageBean);
        }
        return ageBeans;
    }

    public ArrayList<AgeBean> initWeightData() {
        ArrayList<AgeBean> ageBeans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            AgeBean ageBean = new AgeBean();
            ageBean.setName(i + "kg");
            ageBeans.add(ageBean);
        }
        return ageBeans;
    }


}
