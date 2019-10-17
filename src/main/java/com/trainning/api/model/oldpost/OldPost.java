package com.trainning.api.model.oldpost;

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
 * Old post model
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_old_post")
public class OldPost {
    /**
     * Old post ID.
     */
    @Getter
    @Setter
    @Id
    @Column(name = "old_post_id")
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oldPostId;

    /**
     * Old post code.
     */
    @Getter
    @Setter
    @Column(name = "old_post_code")
    private String oldPostCode;

    /**
     * Create instance.
     * @param oldPostCode old post
     */
    public OldPost(String oldPostCode) {
        this.oldPostCode = oldPostCode;
    }
}
