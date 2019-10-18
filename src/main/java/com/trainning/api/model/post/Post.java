package com.trainning.api.model.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
 * Post model
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_post")
@Builder(toBuilder = true)
public class Post {
    /**
     * Post ID.
     */
    @Getter
    @Setter
    @Id
    @Column(name = "post_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    /**
     * Post code.
     */
    @Getter
    @Setter
    @Column(name = "post_code")
    private String postCode;

    /**
     * Update show.
     */
    @Getter
    @Setter
    @Column(name = "update_show")
    private int updateShow;

    /**
     * Change reason.
     */
    @Getter
    @Setter
    @Column(name = "change_reason")
    private int changeReason;

    /**
     * Multi area.
     */
    @Getter
    @Setter
    @Column(name = "multi_area")
    private int multiArea;

    /**
     * Create instance.
     * @param postCode post code
     * @param updateShow update show
     * @param changeReason change reason
     * @param multiArea multi area
     */
    public Post(String postCode, int updateShow, int changeReason, int multiArea) {
        this.postCode = postCode;
        this.updateShow = updateShow;
        this.changeReason = changeReason;
        this.multiArea = multiArea;
    }
}
