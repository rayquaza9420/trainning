package com.trainning.api.model.prefecture;

public class PrefectureFixtures {
    public static Prefecture createPrefecture(){
        Prefecture prefecture = new Prefecture();
        prefecture.setPrefectureName("秋田県");
        prefecture.setPrefectureCode("05");
        prefecture.setPrefectureKana("ｱｷﾀｹﾝ");

        return prefecture;
    }
}
