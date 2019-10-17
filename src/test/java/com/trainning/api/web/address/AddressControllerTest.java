package com.trainning.api.web.address;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.trainning.api.model.address.AddressPostCode;
import com.trainning.api.model.address.AddressPostCodeFixtures;
import com.trainning.api.model.address.AddressPrefectureCode;
import com.trainning.api.model.address.AddressPrefectureCodeFixtures;
import com.trainning.api.model.address.AddressService;
import jp.xet.sparwings.spring.web.httpexceptions.HttpNotFoundException;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for {@link AddressController}
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    AddressService addressService;

    /**
     * Test GET "/post_offices/post/{postcode}"
     * @throws Exception exception
     */
    @Test
    public void SearchByPostCode() throws Exception {
        // setup
        AddressPostCode area = AddressPostCodeFixtures.createAddressPostCode();
        List<AddressPostCode> listArea = new ArrayList<>();
        listArea.add(area);
        given(addressService.findByPostCode(area.getPostCode())).willReturn(listArea);
        // exercise
        mvc.perform(get("/post_offices/post/{postcode}", area.getPostCode()))
                // verify
                .andExpect(status().isOk())
                .andExpect(jsonPath("@.data[0].post_code").value(is(area.getPostCode())))
                .andExpect(jsonPath("@.data[0].prefecture_code").value(is(area.getPrefectureCode())))
                .andExpect(jsonPath("@.data[0].code").value(is(area.getCityCode())));
    }

    /**
     * Test GET "/post_offices/post/{postcode}" @throws HttpNotFoundException
     */
    @Test
    public void SearchByPostCodeThrowsHNFE() throws Exception {
        // setup
        doThrow(HttpNotFoundException.class).when(addressService).findByPostCode("01208371");
        // exercise
        mvc.perform(get("/post_offices/post/{postcode}", "01208371"))
                // verify
                .andExpect(status().isNotFound());
    }

    /**
     * Test GET "/post_offices/post/{postcode}" @throws IllegalArgumentException
     */
    @Test
    public void SearchByPostCodeThrowsHBRE() throws Exception {
        // setup
        doThrow(IllegalArgumentException.class).when(addressService).findByPostCode("abc");
        // exercise
        mvc.perform(get("/post_offices/post/{postcode}", "abc"))
                // verify
                .andExpect(status().isBadRequest());
    }

    /**
     * Test GET "/post_offices/prefectures/{prefectureCode}"
     * @throws Exception
     */
    @Test
    public void SearchByPrefectureCode() throws Exception {
        // setup
        AddressPrefectureCode city = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        List<AddressPrefectureCode> listCity = new ArrayList<>();
        listCity.add(city);
        given(addressService.findByPrefectureCode(city.getPrefectureCode())).willReturn(listCity);
        // exercise
        mvc.perform(get("/post_offices/prefectures/{prefectureCode}", city.getPrefectureCode()))
                // verify
                .andExpect(status().isOk())
                .andExpect(jsonPath("@.data[0].code").value(is(city.getCityCode())))
                .andExpect(jsonPath("@.data[0].prefecture_code").value(is(city.getPrefectureCode())))
                .andExpect(jsonPath("@.data[0].prefecture").value(is(city.getPrefectureName())))
                .andExpect(jsonPath("@.data[0].prefecture_kana").value(is(city.getPrefectureKana())));
    }

    /**
     * Test GET "/post_offices/prefectures/{prefectureCode}" @throws HttpNotFoundException
     */
    @Test
    public void SearchByPrefectureCodeThrowsHNFE() throws Exception {
        // setup
        doThrow(HttpNotFoundException.class).when(addressService).findByPrefectureCode("100");
        // exercise
        mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "100"))
                // verify
                .andExpect(status().isNotFound());
    }

    /**
     * Test GET "/post_offices/prefectures/{prefectureCode}" @throws IllegalArgumentException
     */
    @Test
    public void SearchByPrefectureCodeThrowsHBRE() throws Exception {
        // setup
        doThrow(IllegalArgumentException.class).when(addressService).findByPrefectureCode("abc");
        // exercise
        mvc.perform(get("/post_offices/prefectures/{prefectureCode}", "abc"))
                // verify
                .andExpect(status().isBadRequest());
    }
}
