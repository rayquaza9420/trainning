package com.trainning.api.model.city;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for {@link City}.
 */
public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * Find list of city by prefecture code
     * @param prefectureCode the code of prefecture
     * @return all city of prefecture
     */
    List<City> findByPrefecturePrefectureCode(String prefectureCode);
}
