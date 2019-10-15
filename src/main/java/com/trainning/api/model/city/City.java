package com.trainning.api.model.city;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainning.api.model.prefecture.Prefecture;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * City model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_city")
public class City {
    @Getter
    @Setter
    @Id
    @Column(name = "city_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Getter
    @Setter
    @Column(name = "code")
    @JsonProperty("code")
    private String cityCode;

    @Getter
    @Setter
    @Column(name = "city_kana")
    @JsonProperty("city_kana")
    private String cityKana;

    @Getter
    @Setter
    @Column(name = "city")
    @JsonProperty("city")
    private String cityName;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "prefecture_id")
    private Prefecture prefecture;

    /**
     * Create instance.
     *
     * @param cityCode city code
     * @param cityKana city kana
     * @param cityName city name
     * @param prefecture prefecture
     */
    public City(String cityCode, String cityKana, String cityName, Prefecture prefecture) {
        this.cityCode = cityCode;
        this.cityKana = cityKana;
        this.cityName = cityName;
        this.prefecture = prefecture;
    }
}
