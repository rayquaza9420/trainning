package com.trainning.api.model.prefecture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Prefecture model
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_prefecture")
public class Prefecture {
    /**
     * Prefecture ID.
     */
    @Getter
    @Setter
    @Id
    @Column(name = "prefecture_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prefectureId;

    /**
     * Prefecture name kana.
     */
    @Getter
    @Setter
    @Column(name = "prefecture_kana")
    private String prefectureKana;

    /**
     * Prefecture name.
     */
    @Getter
    @Setter
    @Column(name = "prefecture")
    private String prefectureName;

    /**
     * Prefecture code.
     */
    @Getter
    @Setter
    @Column(name = "prefecture_code")
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
