package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        conditions.add(Objects::nonNull);
        conditions.add(e -> e instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        conditions.add(e -> e == null || (int) e > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        conditions.add(e -> (int) e >= from && (int) e <= to);
        return this;
    }
}
