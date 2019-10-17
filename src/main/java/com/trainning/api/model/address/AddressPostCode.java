package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.trainning.api.model.area.Area;
import com.trainning.api.model.city.City;
import com.trainning.api.model.oldpost.OldPost;
import com.trainning.api.model.post.Post;
import com.trainning.api.model.prefecture.Prefecture;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Address post code model
 */
@Data
@NoArgsConstructor
public class AddressPostCode {
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
     * Area name.
     */
    @JsonProperty("area")
    private String areaName;

    /**
     * Area name kana.
     */
    @JsonProperty("area_kana")
    private String areaKana;

    /**
     * Multi post area.
     */
    @JsonProperty("multi_post_area")
    private int multiPostArea;

    /**
     * Koaza_area.
     */
    @JsonProperty("koaza_area")
    private int koazaArea;

    /**
     * Chome area.
     */
    @JsonProperty("chome_area")
    private int chomeArea;

    /**
     * Old post code.
     */
    @JsonProperty("old_post_code")
    private String oldPostCode;

    /**
     * Post code.
     */
    @JsonProperty("post_code")
    private String postCode;

    /**
     * Multi area.
     */
    @JsonProperty("multi_area")
    private int multiArea;

    /**
     * Update show.
     */
    @JsonProperty("update_show")
    private int updateShow;

    /**
     * Change reason.
     */
    @JsonProperty("change_reason")
    private int changeReason;

    /**
     * Creat {@link AddressPostCode} instance content collection.
     * @param area found of area
     */
    public AddressPostCode(Area area) {
        AddressUtils.checkAddressPostCode(area);
        City city = area.getCity();
        AddressUtils.checkAddressPostCode(city);
        Prefecture prefecture = city.getPrefecture();
        AddressUtils.checkAddressPostCode(prefecture);
        Post post = area.getPost();
        AddressUtils.checkAddressPostCode(post);
        OldPost oldPost = area.getOldPost();
        AddressUtils.checkAddressPostCode(oldPost);
        this.cityCode = city.getCityCode();
        this.cityName = city.getCityName();
        this.oldPostCode = oldPost.getOldPostCode();
        this.cityKana = city.getCityKana();
        this.prefectureName = prefecture.getPrefectureName();
        this.prefectureKana = prefecture.getPrefectureKana();
        this.prefectureCode = prefecture.getPrefectureCode();
        this.areaName = area.getAreaName();
        this.areaKana = area.getAreaKana();
        this.multiPostArea = area.getMultiPostArea();
        this.koazaArea = area.getKoazaArea();
        this.chomeArea = area.getChomeArea();
        this.oldPostCode = area.getOldPost().getOldPostCode();
        this.postCode = post.getPostCode();
        this.multiArea = post.getMultiArea();
        this.updateShow = post.getUpdateShow();
        this.changeReason = post.getChangeReason();
    }
}
