package com.trainning.api.model.address;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Test for {@link AddressPrefectureCode}
 */
public class AddressPrefectureCodeTest {
    JacksonTester<AddressPrefectureCode> json;

    private ObjectMapper mapper;

    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        JacksonTester.initFields(this, mapper);
        assert json != null; // required for FindBugs NP_UNWRITTEN_FIELD
    }

    private String createResourceCityJsonString() {
        return ""
                + "{"
                + "	 'prefecture_code': '05',"
                + "	 'prefecture': '秋田県',"
                + "	 'prefecture_kana': 'ｱｷﾀｹﾝ',"
                + "	 'city_kana': 'ﾕｻﾞﾜｼ',"
                + "	 'city': '湯沢市',"
                + "	 'code': '05207'"
                + "}";
    }

    @Test
    public void testOK() {
        // setup
        AddressPrefectureCode sut = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        // exercise
        Set<ConstraintViolation<AddressPrefectureCode>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }

    @Test
    public void testNotNullConstraints() {
        // setup
        AddressPrefectureCode sut = new AddressPrefectureCode();
        // exercise
        Set<ConstraintViolation<AddressPrefectureCode>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }

    @Test
    public void testJsonToValueCity() throws Exception {
        // setup
        String CityJson = createResourceCityJsonString();
        AddressPrefectureCode addressPrefectureCode = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        // exercise
        ObjectContent<AddressPrefectureCode> actual = json.parse(CityJson);
        // verify
        actual.assertThat().isEqualTo(addressPrefectureCode);
    }

    @Test
    public void testValueToJson() throws Exception {
        // setup
        AddressPrefectureCode addressPrefectureCode = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        // exercise
        JsonContent<AddressPrefectureCode> actual = json.write(addressPrefectureCode);
        // verify
        assertThat(actual).extractingJsonPathStringValue("@.code").isEqualTo("05207");
        assertThat(actual).extractingJsonPathStringValue("@.city").isEqualTo("湯沢市");
        assertThat(actual).extractingJsonPathStringValue("@.city_kana").isEqualTo("ﾕｻﾞﾜｼ");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture").isEqualTo("秋田県");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture_kana").isEqualTo("ｱｷﾀｹﾝ");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture_code").isEqualTo("05");
    }

    @Test
    public void testValueToTree() throws Exception {
        // setup
        AddressPrefectureCode addressPrefectureCode = AddressPrefectureCodeFixtures.createAddressPrefectureCode();
        // exercise
        JsonNode actualNode = mapper.valueToTree(addressPrefectureCode);
        // verify
        assertThat(actualNode.path("code").isTextual()).isTrue();
        assertThat(actualNode.path("code").textValue()).isEqualTo("05207");
        assertThat(actualNode.path("city").isTextual()).isTrue();
        assertThat(actualNode.path("city").textValue()).isEqualTo("湯沢市");
        assertThat(actualNode.path("city_kana").isTextual()).isTrue();
        assertThat(actualNode.path("city_kana").textValue()).isEqualTo("ﾕｻﾞﾜｼ");
        assertThat(actualNode.path("prefecture").isTextual()).isTrue();
        assertThat(actualNode.path("prefecture").textValue()).isEqualTo("秋田県");
        assertThat(actualNode.path("prefecture_kana").isTextual()).isTrue();
        assertThat(actualNode.path("prefecture_kana").textValue()).isEqualTo("ｱｷﾀｹﾝ");
        assertThat(actualNode.path("prefecture_code").isTextual()).isTrue();
        assertThat(actualNode.path("prefecture_code").textValue()).isEqualTo("05");
    }
}
