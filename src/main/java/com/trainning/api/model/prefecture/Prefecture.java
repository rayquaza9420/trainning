package com.trainning.api.model.prefecture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.Table;

/**
 * Prefecture model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tbl_prefecture")
public class Prefecture {
    @Getter
    @Setter
    @Id
    @Column(name = "prefecture_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prefectureId;

    @Getter
    @Setter
    @Column(name = "prefecture_kana")
    @JsonProperty("prefecture_kana")
    private String prefectureKana;

    @Getter
    @Setter
    @Column(name = "prefecture")
    @JsonProperty("prefecture")
    private String prefectureName;

    @Getter
    @Setter
    @Column(name = "prefecture_code")
    @JsonProperty("prefecture_code")
    private String prefectureCode;

    /**
     * Create instance.
     * @param prefectureKana prefecture kana
     * @param prefectureName prefecture name
     * @param prefectureCode prefecture code
     */
    public Prefecture(String prefectureKana, String prefectureName, String prefectureCode) {
        this.prefectureKana = prefectureKana;
        this.prefectureName = prefectureName;
        this.prefectureCode = prefectureCode;
    }
}
