package com.trainning.api.model.address;

/**
 * Create address post code test data
 */
public class AddressPostCodeFixtures {
    /**
     * Create address post code
     * @return addressPostCode
     */
    public static AddressPostCode createAddressPostCode(){
        AddressPostCode addressPostCode = new AddressPostCode();
        addressPostCode.setAreaName("カツクイ沢山");
        addressPostCode.setAreaKana("ｶｯｸｲｻﾜﾔﾏ");
        addressPostCode.setCityName("湯沢市");
        addressPostCode.setCityCode("05207");
        addressPostCode.setCityKana("ﾕｻﾞﾜｼ");
        addressPostCode.setPostCode("0120833");
        addressPostCode.setPrefectureCode("05");
        addressPostCode.setPrefectureName("秋田県");
        addressPostCode.setPrefectureKana("ｱｷﾀｹﾝ");
        addressPostCode.setOldPostCode("012");
        addressPostCode.setChangeReason(0);
        addressPostCode.setChomeArea(0);
        addressPostCode.setKoazaArea(0);
        addressPostCode.setMultiArea(0);
        addressPostCode.setMultiPostArea(0);
        addressPostCode.setUpdateShow(0);
        return addressPostCode;
    }
}
