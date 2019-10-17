package com.trainning.api.model.area;

import static org.assertj.core.api.Assertions.assertThat;

import com.trainning.api.model.city.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Test for {@link AreaRepository}
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AreaRepositoryTest {
    @Autowired
    AreaRepository sut;

    @Autowired
    CityRepository cityRepository;

    /**
     * Test find area
     */
    @Test
    public void testFindByPostPostCode() {
        // setup
        Area area = AreaFixtures.createArea();
        sut.save(area);
        // exercise
        List<Area> actual = sut.findByPostPostCode(area.getPost().getPostCode());
        // verify
        assertThat(actual).isNotEmpty();
        assertThat(actual.get(0).getPost().getPostCode()).isEqualTo(area.getPost().getPostCode());
    }
}
