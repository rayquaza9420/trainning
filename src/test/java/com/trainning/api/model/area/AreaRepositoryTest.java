package com.trainning.api.model.area;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test for {@link AreaRepository}
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application.properties")
public class AreaRepositoryTest {
    @Autowired
    AreaRepository sut;

    /**
     * Test find area by post code
     */
    @Test
    public void testFindByPostPostCode() {
        // setup
        Area area = AreaFixtures.createArea();
        // exercise
        List<Area> actual = sut.findByPostPostCode(area.getPost().getPostCode());
        // verify
        assertThat(actual.size()).isEqualTo(1);
        Area areaActual = actual.get(0);
        assertThat(areaActual.getPost().getPostCode()).isEqualTo(area.getPost().getPostCode());
    }
}
