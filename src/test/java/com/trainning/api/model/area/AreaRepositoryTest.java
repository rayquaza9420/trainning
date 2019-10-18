package com.trainning.api.model.area;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link AreaRepository}
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AreaRepositoryTest {
    @Autowired
    AreaRepository sut;

    @Test
    public void testFindByPostPostCode() {
        // setup
        Area area = AreaFixtures.createArea();
        sut.save(area);
        // exercise
        List<Area> actual = sut.findByPostPostCode("0120833");
        // verify
        assertThat(actual.size()).isEqualTo(1);
        Area areaActual = actual.get(0);
        assertThat(areaActual.getPost().getPostCode()).isEqualTo(area.getPost().getPostCode());
    }
}
