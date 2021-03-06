package com.trainning.api.model.address;

import com.trainning.api.utils.Utils;
import com.trainning.api.model.area.Area;
import com.trainning.api.model.area.AreaRepository;
import com.trainning.api.model.city.City;
import com.trainning.api.model.city.CityRepository;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Address service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AreaRepository areaRepository;

    private final CityRepository cityRepository;

    /**
     * Find list area by post code
     * @param postCode code of post at address
     * @return found of list address (to area)
     */
    public List<AddressPostCode> findByPostCode(String postCode) {
        Preconditions.checkNotNull(postCode,"Code must be not null.");
        postCode = Utils.AddressUtils.convertCode(postCode);
        Utils.AddressUtils.checkNumber(postCode);
        List<Area> areas = areaRepository.findByPostPostCode(postCode);
        if(areas.isEmpty()){
            throw new HttpNotFoundException("Post code not found.");
        }
        return areas.stream().map(AddressPostCode::new).collect(Collectors.toList());
    }

    /**
     * Find list city by prefecture code
     * @param prefectureCode the code of prefecture
     * @return all city of prefecture
     */
    public List<AddressPrefectureCode> findByPrefectureCode(String prefectureCode)  {
        Preconditions.checkNotNull(prefectureCode,"Code must be not null.");
        prefectureCode = Utils.AddressUtils.convertCode(prefectureCode);
        Utils.AddressUtils.checkNumber(prefectureCode);
        List<City> cities = cityRepository.findByPrefecturePrefectureCode(prefectureCode);
        if(cities.isEmpty()){
            throw new HttpNotFoundException("Prefecture code not found.");
        }
        return cities.stream().map(AddressPrefectureCode::new).collect(Collectors.toList());
    }
}
