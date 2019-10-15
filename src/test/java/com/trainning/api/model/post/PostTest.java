package com.trainning.api.model.post;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PostTest {
    JacksonTester<Post> json;

    private ObjectMapper mapper;

    final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        JacksonTester.initFields(this, mapper);
        assert json != null; // required for FindBugs NP_UNWRITTEN_FIELD
    }

    @Test
    public void testOK() {
        // setup
        Post sut = PostFixtures.createPost();
        // exercise
        Set<ConstraintViolation<Post>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }

    @Test
    public void testNotNullConstraints() {
        // setup
        Post sut = new Post();
        // exercise
        Set<ConstraintViolation<Post>> actual = validator.validate(sut);
        // verify
        assertThat(actual).hasSize(0);
    }
}
