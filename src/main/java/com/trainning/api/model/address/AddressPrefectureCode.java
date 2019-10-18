package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.trainning.api.model.city.City;
import com.trainning.api.model.prefecture.Prefecture;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Address prefecture code model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressPrefectureCode {
    /**
     * City code.
     */
    @JsonProperty("code")
    private String cityCode;

    /**
     * City name.
     */
    @JsonProperty("city")
    private String cityName;

    /**
     * City name kana.
     */
    @JsonProperty("city_kana")
    private String cityKana;

    /**
     * Prefecture name.
     */
    @JsonProperty("prefecture")
    private String prefectureName;

    /**
     * Prefecture name kana.
     */
    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    /**
     * Prefecture code.
     */
    @JsonProperty("prefecture_code")
    private String prefectureCode;

    /**
     * Creates {@link AddressPrefectureCode} instance content collection.
     * @param city found of list city
     */
    public AddressPrefectureCode(City city) {
        Preconditions.checkNotNull(city,"Prefecture code not found.");
        Prefecture prefecture = city.getPrefecture();
        Preconditions.checkNotNull(prefecture,"Prefecture code not found.");
        this.cityCode = city.getCityCode();
        this.cityName = city.getCityName();
        this.cityKana = city.getCityKana();
        this.prefectureName = prefecture.getPrefectureName();
        this.prefectureKana = prefecture.getPrefectureKana();
        this.prefectureCode = prefecture.getPrefectureCode();
    }
}
