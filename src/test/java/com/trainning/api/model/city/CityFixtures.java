package com.trainning.api.model.city;

import com.trainning.api.model.prefecture.Prefecture;

/**
 * Create city test data
 */
public class CityFixtures {
    /**
     * Create city test data
     * @return city
     */
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
