package com.trainning.api.model.oldpost;

/**
 * Create old post test data
 */
public class OldPostFixtures {
    /**
     * Create old post test data
     * @return oldPost
     */
    public static OldPost createOldPost(){
        OldPost oldPost = new OldPost();
        oldPost.setOldPostCode("012");

        return oldPost;
    }
}
