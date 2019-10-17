package com.trainning.api.model.city;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trainning.api.model.prefecture.Prefecture;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_city")
public class City {
    /**
     * City ID.
     */
    @Getter
    @Setter
    @Id
    @Column(name = "city_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    /**
     * City code.
     */
    @Getter
    @Setter
    @Column(name = "code")
    private String cityCode;

    /**
     * City name kana.
     */
    @Getter
    @Setter
    @Column(name = "city_kana")
    private String cityKana;

    /**
     * City name.
     */
    @Getter
    @Setter
    @Column(name = "city")
    private String cityName;

    /**
     * Prefecture ID.
     */
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
