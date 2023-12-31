package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {
    public MapSchema shape(Map<String, BaseSchema> map) {

        map.keySet().forEach(key -> conditions.add(s ->
                map.get(key).isValid(((Map<?, ?>) s).get(key))));

        return this;
    }

    public MapSchema required() {
        conditions.add(Objects::nonNull);
        conditions.add(e -> e instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        conditions.add(s -> ((Map<?, ?>) s).size() == size);
        return this;
    }
}
