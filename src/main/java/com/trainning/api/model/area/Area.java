package com.trainning.api.model.area;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trainning.api.model.city.City;
import com.trainning.api.model.oldpost.OldPost;
import com.trainning.api.model.post.Post;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Area model
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_area")
public class Area {
    /**
     * Area ID.
     */
    @Getter
    @Setter
    @Id
    @Column(name = "area_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaId;

    /**
     * Area name kana.
     */
    @Getter
    @Setter
    @Column(name = "area_kana", columnDefinition = "LONGTEXT")
    private String areaKana;

    /**
     * Area name.
     */
    @Getter
    @Setter
    @Column(name = "area", columnDefinition = "LONGTEXT")
    private String areaName;

    /**
     * City ID.
     */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    /**
     * Chome area.
     */
    @Getter
    @Setter
    @Column(name = "chome_area")
    @JsonProperty("chome_area")
    private int chomeArea;

    /**
     * Koaza area.
     */
    @Getter
    @Setter
    @Column(name = "koaza_area")
    private int koazaArea;

    /**
     * Multi post area.
     */
    @Getter
    @Setter
    @Column(name = "multi_post_area")
    private int multiPostArea;

    /**
     * Post ID.
     */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    /**
     * Old post ID.
     */
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "old_post_id")
    private OldPost oldPost;

    /**
     * Create instance.
     *
     * @param areaKana area kana
     * @param areaName area name
     * @param city city name
     * @param chomeArea chome area
     * @param koazaArea koaza area
     * @param multiPostArea multi post area
     * @param post post
     * @param oldPost old post
     */
    public Area(String areaKana, String areaName, City city, int chomeArea, int koazaArea, int multiPostArea, Post post, OldPost oldPost) {
        this.areaKana = areaKana;
        this.areaName = areaName;
        this.city = city;
        this.chomeArea = chomeArea;
        this.koazaArea = koazaArea;
        this.multiPostArea = multiPostArea;
        this.post = post;
        this.oldPost = oldPost;
    }
}
