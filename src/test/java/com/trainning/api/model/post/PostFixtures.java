package com.trainning.api.model.post;

/**
 * Create post test data
 */
public class PostFixtures {
    /**
     * Create post test data
     */
    public static Post createPost(){
        Post post = new Post();
        post.setPostCode("0120833");
        post.setUpdateShow(0);
        post.setMultiArea(0);
        post.setChangeReason(0);

        return post;
    }
}
