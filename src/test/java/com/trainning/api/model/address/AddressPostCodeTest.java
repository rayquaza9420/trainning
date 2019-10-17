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

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Test for {@link AddressPostCode}
 */
public class AddressPostCodeTest {
    JacksonTester<AddressPostCode> json;

    private ObjectMapper mapper;

    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        JacksonTester.initFields(this, mapper);
        assert json != null; // required for FindBugs NP_UNWRITTEN_FIELD
    }

    private String createResourceAddressJsonString() {
        return ""
                + "{"
                + "  'prefecture_code': '05',"
                + "  'prefecture': '秋田県',"
                + "  'prefecture_kana': 'ｱｷﾀｹﾝ',"
                + "  'city_kana': 'ﾕｻﾞﾜｼ',"
                + "  'city': '湯沢市',"
                + "  'code': '05207',"
                + "  'area_kana': 'ｶｯｸｲｻﾜﾔﾏ',"
                + "  'area': 'カツクイ沢山',"
                + "  'koaza_area': 0,"
                + "  'chome_area': 0,"
                + "  'multi_post_area': 0,"
                + "  'post_code': '0120833',"
                + "  'old_post_code': '012',"
                + "  'multi_area': 0,"
                + "  'update_show': 0,"
                + "  'change_reason': 0"
                + "}";
    }

    @Test
    public void testOK() {
        // setup
        AddressPostCode sut = AddressPostCodeFixtures.createAddressPostCode();
        // exercise
        Set<ConstraintViolation<AddressPostCode>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }

    @Test
    public void testNotNullConstraints() {
        // setup
        AddressPostCode sut = new AddressPostCode();
        // exercise
        Set<ConstraintViolation<AddressPostCode>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }

    @Test
    public void testJsonToValueCity() throws Exception {
        // setup
        String AddressJson = createResourceAddressJsonString();
        AddressPostCode addressPostCode = AddressPostCodeFixtures.createAddressPostCode();
        // exercise
        ObjectContent<AddressPostCode> actual = json.parse(AddressJson);
        // verify
        actual.assertThat().isEqualTo(addressPostCode);
    }

    @Test
    public void testValueToJson() throws Exception {
        // setup
        AddressPostCode addressPostCode = AddressPostCodeFixtures.createAddressPostCode();
        // exercise
        JsonContent<AddressPostCode> actual = json.write(addressPostCode);
        // verify
        assertThat(actual).extractingJsonPathStringValue("@.code").isEqualTo("05207");
        assertThat(actual).extractingJsonPathStringValue("@.city").isEqualTo("湯沢市");
        assertThat(actual).extractingJsonPathStringValue("@.city_kana").isEqualTo("ﾕｻﾞﾜｼ");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture").isEqualTo("秋田県");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture_kana").isEqualTo("ｱｷﾀｹﾝ");
        assertThat(actual).extractingJsonPathStringValue("@.prefecture_code").isEqualTo("05");
        assertThat(actual).extractingJsonPathStringValue("@.area").isEqualTo("カツクイ沢山");
        assertThat(actual).extractingJsonPathStringValue("@.area_kana").isEqualTo("ｶｯｸｲｻﾜﾔﾏ");
        assertThat(actual).extractingJsonPathNumberValue("@.multi_post_area").isEqualTo(0);
        assertThat(actual).extractingJsonPathNumberValue("@.koaza_area").isEqualTo(0);
        assertThat(actual).extractingJsonPathNumberValue("@.chome_area").isEqualTo(0);
        assertThat(actual).extractingJsonPathStringValue("@.old_post_code").isEqualTo("012");
        assertThat(actual).extractingJsonPathStringValue("@.post_code").isEqualTo("0120833");
        assertThat(actual).extractingJsonPathNumberValue("@.multi_area").isEqualTo(0);
        assertThat(actual).extractingJsonPathNumberValue("@.update_show").isEqualTo(0);
        assertThat(actual).extractingJsonPathNumberValue("@.change_reason").isEqualTo(0);
    }

    @Test
    public void testValueToTree() throws Exception {
        // setup
        AddressPostCode addressPostCode = AddressPostCodeFixtures.createAddressPostCode();
        // exercise
        JsonNode actualNode = mapper.valueToTree(addressPostCode);
        // verify
        assertThat(actualNode.path("area").isTextual()).isTrue();
        assertThat(actualNode.path("area").textValue()).isEqualTo("カツクイ沢山");
        assertThat(actualNode.path("area_kana").isTextual()).isTrue();
        assertThat(actualNode.path("area_kana").textValue()).isEqualTo("ｶｯｸｲｻﾜﾔﾏ");
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
        assertThat(actualNode.path("old_post_code").isTextual()).isTrue();
        assertThat(actualNode.path("old_post_code").textValue()).isEqualTo("012");
        assertThat(actualNode.path("post_code").isTextual()).isTrue();
        assertThat(actualNode.path("post_code").textValue()).isEqualTo("0120833");
        assertThat(actualNode.path("multi_post_area").isNumber()).isTrue();
        assertThat(actualNode.path("multi_post_area").numberValue()).isEqualTo(0);
        assertThat(actualNode.path("koaza_area").isNumber()).isTrue();
        assertThat(actualNode.path("koaza_area").numberValue()).isEqualTo(0);
        assertThat(actualNode.path("chome_area").isNumber()).isTrue();
        assertThat(actualNode.path("chome_area").numberValue()).isEqualTo(0);
        assertThat(actualNode.path("multi_area").isNumber()).isTrue();
        assertThat(actualNode.path("multi_area").numberValue()).isEqualTo(0);
        assertThat(actualNode.path("update_show").isNumber()).isTrue();
        assertThat(actualNode.path("update_show").numberValue()).isEqualTo(0);
        assertThat(actualNode.path("change_reason").isNumber()).isTrue();
        assertThat(actualNode.path("change_reason").numberValue()).isEqualTo(0);
    }
}
