package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringSchemaTest {
    Validator validator = new Validator();

    @Test
    void testIsValidNull() {
        StringSchema schema = validator.string();

        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void testIsValidEmpty() {
        StringSchema schema = validator.string();

        assertThat(schema.isValid("")).isTrue();
    }

    @Test
    void testIsValidRequiredNull() {
        StringSchema schema = validator.string();
        schema.required();

        assertThat(schema.isValid(null)).isFalse();
    }

    @Test
    void testIsValidRequiredEmpty() {
        StringSchema schema = validator.string();
        schema.required();

        assertThat(schema.isValid("")).isFalse();
    }


    @Test
    void testIsValidRequiredNonString() {
        StringSchema schema = validator.string();
        schema.required();

        assertThat(schema.isValid(5)).isFalse();
    }

    @Test
    void testIsValid() {
        StringSchema schema = validator.string();

        assertThat(schema.isValid("what does the fox say")).isTrue();
    }

    @Test
    void testIsValidContains() {
        StringSchema schema = validator.string();

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
    }

    @Test
    void testIsValidContains1() {
        StringSchema schema = validator.string();

        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
    }
}
