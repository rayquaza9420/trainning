package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainning.api.model.city.City;
import com.trainning.api.model.prefecture.Prefecture;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * address prefecture code model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressPrefectureCode {
    @JsonProperty("code")
    private String cityCode;

    @JsonProperty("city")
    private String cityName;

    @JsonProperty("city_kana")
    private String cityKana;

    @JsonProperty("prefecture")
    private String prefectureName;

    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    @JsonProperty("prefecture_code")
    private String prefectureCode;

    /**
     * Creates {@link AddressPrefectureCode} instance content collection.
     * @param city found of list city
     */
    public AddressPrefectureCode(City city) {
        Prefecture prefecture = city.getPrefecture();
        this.cityCode = city.getCityCode();
        this.cityName = city.getCityName();
        this.cityKana = city.getCityKana();
        this.prefectureName = prefecture.getPrefectureName();
        this.prefectureKana = prefecture.getPrefectureKana();
        this.prefectureCode = prefecture.getPrefectureCode();
    }
}
