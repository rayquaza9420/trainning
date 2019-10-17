package com.trainning.api.model.area;

import com.trainning.api.model.city.City;
import com.trainning.api.model.oldpost.OldPost;
import com.trainning.api.model.post.Post;
import com.trainning.api.model.prefecture.Prefecture;

/**
 * Create area test data
 */
public class AreaFixtures {
    /**
     * Create area test data
     * @return area
     */
    public static Area createArea(){
        Prefecture prefecture = new Prefecture();
        prefecture.setPrefectureId(0);
        prefecture.setPrefectureName("秋田県");
        prefecture.setPrefectureCode("05");
        prefecture.setPrefectureKana("ｱｷﾀｹﾝ");

        City city = new City();
        city.setCityId(0);
        city.setCityName("湯沢市");
        city.setCityKana("ﾕｻﾞﾜｼ");
        city.setCityCode("05207");
        city.setPrefecture(prefecture);

        Post post = new Post();
        post.setPostId(0);
        post.setPostCode("0120833");
        post.setUpdateShow(0);
        post.setMultiArea(0);
        post.setChangeReason(0);

        OldPost oldPost = new OldPost();
        oldPost.setOldPostId(0);
        oldPost.setOldPostCode("012");

        Area area = new Area();
        area.setAreaId(0);
        area.setAreaName("カツクイ沢山");
        area.setAreaKana("ｶｯｸｲｻﾜﾔﾏ");
        area.setCity(city);
        area.setChomeArea(0);
        area.setKoazaArea(0);
        area.setMultiPostArea(0);
        area.setPost(post);
        area.setOldPost(oldPost);

        return area;
    }
}
