package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MapSchemaTest {
    private final Validator validator = new Validator();

    @Test
    void testIsValidNull() {
        MapSchema schema = validator.map();

        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void testIsValidRequired() {
        MapSchema schema = validator.map();
        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    void testIsValidSize() {
        MapSchema schema = validator.map();
        schema.sizeof(2);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(data)).isFalse();

        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
    }
}
