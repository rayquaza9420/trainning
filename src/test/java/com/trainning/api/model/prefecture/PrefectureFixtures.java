package com.trainning.api.model.prefecture;

/**
 * Create prefecture test data
 */
public class PrefectureFixtures {
    /**
     * Create prefecture test data
     * @return prefecture
     */
    public static Prefecture createPrefecture(){
        Prefecture prefecture = new Prefecture();
        prefecture.setPrefectureName("秋田県");
        prefecture.setPrefectureCode("05");
        prefecture.setPrefectureKana("ｱｷﾀｹﾝ");

        return prefecture;
    }
}
