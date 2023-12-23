package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberSchemaTest {
    Validator validator = new Validator();

    @Test
    void testIsValidNull() {
        NumberSchema schema = validator.number();

        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void testIsValidPositive() {
        NumberSchema schema = validator.number();
        schema.positive();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(1)).isTrue();
        assertThat(schema.isValid(0)).isFalse();
    }

    @Test
    void testIsValidRequired() {
        NumberSchema schema = validator.number();
        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(10)).isTrue();
    }

    @Test
    void testIsValidRange() {
        NumberSchema schema = validator.number();
        schema.range(5, 10);

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();
    }
}
