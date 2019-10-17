package com.trainning.api.model.address;

/**
 * Address utils
 */
public class AddressUtils {

    /**
     * Check null object AddressPostCode
     * @param object object
     */
    public static void checkAddressPostCode(Object object){
        if(object == null){
            throw new NullPointerException("Post code not found.");
        }
    }

    /**
     * Check null object AddressPrefectureCode
     * @param object
     */
    public static void checkAddressPrefectureCode(Object object){
        if(object == null){
            throw new NullPointerException("Prefecture code not found.");
        }
    }

    /**
     * Check null code
     * @param code code
     */
    public static void checkNullCode(String code) {
        if(code == null || code.isEmpty()) {
            throw new NullPointerException("Code must be not null.");
        }
    }

    /**
     * Check number code
     * @param code code
     */
    public static void checkNumber(String code) {
        if(!code.matches("\\d+")) {
            throw new IllegalArgumentException("Code must be half size number.");
        }
    }

    /**
     * Convert code
     * @param code code
     * @return code
     */
    public static String convertCode(String code) {
        return code.replaceAll(" ", "").replaceAll("-", "");
    }
}
