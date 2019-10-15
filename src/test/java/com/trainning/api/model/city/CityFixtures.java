package com.trainning.api.model.city;

import com.trainning.api.model.prefecture.Prefecture;

public class CityFixtures {
    public static City createCity(){
        Prefecture prefecture = new Prefecture();
        prefecture.setPrefectureCode("05");
        prefecture.setPrefectureName("秋田県");
        prefecture.setPrefectureKana("ｱｷﾀｹﾝ");

        City city = new City();
        city.setCityCode("05207");
        city.setCityName("湯沢市");
        city.setCityKana("ﾕｻﾞﾜｼ");
        city.setPrefecture(prefecture);

        return city;
    }
}
