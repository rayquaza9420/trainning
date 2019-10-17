package com.trainning.api.model.address;

/**
 * Create address prefecture code test data
 */
public class AddressPrefectureCodeFixtures {
    /**
     * Create address prefecture code test data
     * @return addressPrefectureCode
     */
    public static AddressPrefectureCode createAddressPrefectureCode(){
        AddressPrefectureCode addressPrefectureCode = new AddressPrefectureCode();
        addressPrefectureCode.setPrefectureCode("05");
        addressPrefectureCode.setPrefectureName("秋田県");
        addressPrefectureCode.setPrefectureKana("ｱｷﾀｹﾝ");
        addressPrefectureCode.setCityCode("05207");
        addressPrefectureCode.setCityName("湯沢市");
        addressPrefectureCode.setCityKana("ﾕｻﾞﾜｼ");
        return addressPrefectureCode;
    }
}
