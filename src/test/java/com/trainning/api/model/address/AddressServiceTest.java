package com.trainning.api.model.address;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import com.trainning.api.model.area.Area;
import com.trainning.api.model.area.AreaFixtures;
import com.trainning.api.model.area.AreaRepository;
import com.trainning.api.model.city.City;
import com.trainning.api.model.city.CityFixtures;
import com.trainning.api.model.city.CityRepository;
import com.trainning.api.model.city.CityRepositoryTest;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for {@link AddressService}.
 */
@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    AreaRepository areaRepository;

    @Mock
    CityRepository cityRepository;

    AddressService sut;

    @BeforeEach
    public void setUp() {
        sut = new AddressService(areaRepository,cityRepository);
    }

    /**
     * Test post code
     */
    @Test
    public void findByPostCode() {
        // setup
        Area area = AreaFixtures.createArea();
        List<Area> listArea = new ArrayList<>();
        listArea.add(area);
        AddressPostCode addressPostCode = AddressPostCodeFixtures.createAddressPostCode();
        when(areaRepository.findByPostPostCode(area.getPost().getPostCode())).thenReturn(listArea);

        // exercise
        List<AddressPostCode> actual = sut.findByPostCode(area.getPost().getPostCode());

        // verify
        verify(areaRepository, times(1)).findByPostPostCode(area.getPost().getPostCode());
        assertThat(actual).isNotEmpty();
        assertThat(actual.get(0)).isEqualTo(addressPostCode);
    }

    /**
     * Test post code throws HttpNotFoundException
     */
    @Test
    public void findByPostCodeThrowsHFE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPostCode("01208371")).isInstanceOf(HttpNotFoundException.class)
                .hasMessage("Post code not found.");
    }

    /**
     * Test post code throws NullPointerException
     */
    @Test
    public void findByPostCodeThrowsNPE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPostCode(null)).isInstanceOf(NullPointerException.class)
                .hasMessage("Code must be not null.");
    }

    /**
     * Test post code throws IllegalArgumentException
     */
    @Test
    public void findByPostCodeTestThrowsIAE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPostCode("abc")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Code must be half size number.");
    }

    /**
     * Test prefecture code
     */
    @Test
    public void findByPrefectureCode() {
        // setup
        City city = CityFixtures.createCity();
        List<City> listCity = new ArrayList<>();
        listCity.add(city);
        AddressPrefectureCode addressPrefectureCode = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        when(cityRepository.findByPrefecturePrefectureCode(city.getPrefecture().getPrefectureCode())).thenReturn(listCity);

        // exercise
        List<AddressPrefectureCode> actual = sut.findByPrefectureCode(city.getPrefecture().getPrefectureCode());

        // verify
        verify(cityRepository, times(1)).findByPrefecturePrefectureCode(city.getPrefecture().getPrefectureCode());
        assertThat(actual).isNotEmpty();
        assertThat(actual.get(0)).isEqualTo(addressPrefectureCode);
    }

    /**
     * Test prefecture code throws HttpNotFoundException
     */
    @Test
    public void findByPrefectureCodeThrowsHFE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPrefectureCode("100")).isInstanceOf(HttpNotFoundException.class)
                .hasMessage("Prefecture code not found.");
    }

    /**
     * Test prefecture code throws NullPointerException
     */
    @Test
    public void findByPrefectureCodeThrowsNPE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPrefectureCode(null)).isInstanceOf(NullPointerException.class)
                .hasMessage("Code must be not null.");
    }

    /**
     * Test prefecture code throws IllegalArgumentException
     */
    @Test
    public void findByPrefectureCodeThrowsIAE(){
        // exercise
        assertThatThrownBy(()-> sut.findByPrefectureCode("abc")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Code must be half size number.");
    }
}
