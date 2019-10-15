package com.trainning.api.model.address;

import com.trainning.api.model.area.Area;
import com.trainning.api.model.area.AreaRepository;
import com.trainning.api.model.city.City;
import com.trainning.api.model.city.CityRepository;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for {@link AddressPostCode} and {@link AddressPrefectureCode}
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AddressService {

    private final AreaRepository areaRepo;

    private final CityRepository cityRepo;

    /**
     * Find list address by post code
     * @param postCode code of post at address
     * @return found of list address (to area)
     */
    public List<AddressPostCode> findByPostCode(String postCode) {
        postCode = validateCode(postCode);
        List<Area> areas = areaRepo.findByPostPostCode(postCode);
        if(areas.isEmpty()){
            throw new HttpNotFoundException("Post code not found.");
        }
        return areas.stream().map(AddressPostCode::new).collect(Collectors.toList());
    }

    /**
     * Find list address by prefecture code
     * @param prefectureCode the code of prefecture
     * @return all city of prefecture
     */
    public List<AddressPrefectureCode> findByPrefectureCode(String prefectureCode)  {
        prefectureCode = validateCode(prefectureCode);
        List<City> cities = cityRepo.findByPrefecturePrefectureCode(prefectureCode);
        if(cities.isEmpty()){
            throw new HttpNotFoundException("Prefecture code not found.");
        }
        return cities.stream().map(AddressPrefectureCode::new).collect(Collectors.toList());
    }

    /**
     * check null and half size code
     * @param code postCode or prefectueCode
     * @return code
     */
    private String validateCode(String code){
        if(code == null || code.isEmpty()) {
            throw new NullPointerException("Code must be not null.");
        }
        code = code.replaceAll(" ", "").replaceAll("-", "");
        if(!code.matches("\\d+")) {
            throw new IllegalArgumentException("Code must be half size number.");
        }
        return code;
    }
}
