package com.trainning.api.model.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Post model
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_post")
public class Post {
    @Getter
    @Setter
    @Id
    @Column(name = "post_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Getter
    @Setter
    @Column(name = "post_code")
    @JsonProperty("post_code")
    private String postCode;

    @Getter
    @Setter
    @Column(name = "update_show")
    @JsonProperty("update_show")
    private int updateShow;

    @Getter
    @Setter
    @Column(name = "change_reason")
    @JsonProperty("change_reason")
    private int changeReason;

    @Getter
    @Setter
    @Column(name = "multi_area")
    @JsonProperty("multi_area")
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
