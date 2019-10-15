package com.trainning.api.model.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.trainning.api.model.area.Area;
import com.trainning.api.model.city.City;
import com.trainning.api.model.oldpost.OldPost;
import com.trainning.api.model.post.Post;
import com.trainning.api.model.prefecture.Prefecture;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Address post code model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressPostCode {
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

    @JsonProperty("area")
    private String areaName;

    @JsonProperty("area_kana")
    private String areaKana;

    @JsonProperty("multi_post_area")
    private int multiPostArea;

    @JsonProperty("koaza_area")
    private int koazaArea;

    @JsonProperty("chome_area")
    private int chomeArea;

    @JsonProperty("old_post_code")
    private String oldPostCode;

    @JsonProperty("post_code")
    private String postCode;

    @JsonProperty("multi_area")
    private int multiArea;

    @JsonProperty("update_show")
    private int updateShow;

    @JsonProperty("change_reason")
    private int changeReason;

    /**
     * Creat {@link AddressPostCode} instance content collection.
     * @param area found of area
     */
    public AddressPostCode(Area area) {
        City city = area.getCity();
        Prefecture prefecture = city.getPrefecture();
        Post post = area.getPost();
        OldPost oldPost = area.getOldPost();
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
