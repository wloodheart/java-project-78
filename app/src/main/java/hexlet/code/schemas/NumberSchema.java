package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        conditions.add(Objects::nonNull);
        conditions.add(e -> e instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        conditions.add(e -> e == null || Integer.parseInt(e.toString()) > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        conditions.add(e -> Integer.parseInt(e.toString()) >= from && Integer.parseInt(e.toString()) <= to);
        return this;
    }
}
