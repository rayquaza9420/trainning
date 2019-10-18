package com.trainning.api.utils;

public class Utils {
    /**
     * Address utils
     */
    public static class AddressUtils {
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
}
