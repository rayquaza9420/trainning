package com.trainning.api.model.city;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test for {@link CityRepository}
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application.properties")
public class CityRepositoryTest {
    @Autowired
    CityRepository sut;

    /**
     * Test find city by prefecture code
     */
    @Test
    public void testFindByPrefecturePrefectureCode() {
        // setup
        City city = CityFixtures.createCity();
        // exercise
        List<City> actual = sut.findByPrefecturePrefectureCode(city.getPrefecture().getPrefectureCode());
        // verify
        assertThat(actual.size()).isEqualTo(1);
        City cityActual = actual.get(0);
        assertThat(cityActual.getPrefecture().getPrefectureCode()).isEqualTo(city.getPrefecture().getPrefectureCode());
    }
}
