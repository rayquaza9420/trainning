package com.trainning.api.web.address;

import static com.jayway.jsonassert.JsonAssert.with;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.trainning.api.model.area.Area;
import com.trainning.api.model.area.AreaFixtures;
import com.trainning.api.model.city.City;
import com.trainning.api.model.city.CityFixtures;
import com.trainning.api.web.AbstractIntegrationTest;

/**
 * Integration test for API.
 *
 */
@TestPropertySource("classpath:application-integrationtest.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressIntegrationTest extends AbstractIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    /**
     * Test GET /post_offices/post/{postCode}
     */
    @Test
    public void testGetAreaByPostCode() {
        // setup
        HttpHeaders headers = createHeaders();
        Area area = AreaFixtures.createArea();
        String postCode = area.getPost().getPostCode();

        // exercise
        ResponseEntity<String> actual =
                restTemplate.exchange("/post_offices/post/{postcode}", HttpMethod.GET,
                        new HttpEntity<>(headers),
                        String.class, postCode);
        // verify
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        with(actual.getBody())
                .assertThat("$.data[0].code", is(area.getCity().getCityCode()))
                .assertThat("$.data[0].city", is(area.getCity().getCityName()))
                .assertThat("$.data[0].city_kana", is(area.getCity().getCityKana()));
    }

    /**
     * Test GET /post_offices/prefectures/{prefectureCode}
     */
    @Test
    public void testGetCityByPrefectureCode() {
        // setup
        HttpHeaders headers = createHeaders();
        City city = CityFixtures.createCity();
        String prefectureCode = city.getPrefecture().getPrefectureCode();
        // exercise
        ResponseEntity<String> actual =
                restTemplate.exchange("/post_offices/prefectures/{prefectureCode}", HttpMethod.GET,
                        new HttpEntity<>(headers),
                        String.class, prefectureCode);
        // verify
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        with(actual.getBody())
                .assertThat("$.data[0].prefecture", is(city.getPrefecture().getPrefectureName()))
                .assertThat("$.data[0].prefecture_kana", is(city.getPrefecture().getPrefectureKana()))
                .assertThat("$.data[0].code", is(city.getCityCode()));
    }
}
