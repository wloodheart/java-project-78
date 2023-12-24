package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {
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
