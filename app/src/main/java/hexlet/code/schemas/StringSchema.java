package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema {


    public StringSchema required() {
        conditions.add(Objects::nonNull);
        conditions.add(s -> s instanceof String);
        conditions.add(s -> !s.toString().isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength) {
        conditions.add(s -> ((String) s).length() >= minLength);
        return this;
    }

    public StringSchema contains(String contains) {
        conditions.add(s -> s.toString().contains(contains));
        return this;
    }
}
